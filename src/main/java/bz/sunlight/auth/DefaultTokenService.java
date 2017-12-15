package bz.sunlight.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.security.Key;
import java.util.Date;

public final class DefaultTokenService {
  private Key signingKey;

  public DefaultTokenService(Key signingKey) {
    this.signingKey = signingKey;
  }

  /**
   * 构造 JSON Web Token.
   *
   * @param subject    认证主体
   * @param ttlSeconds 有效期，以秒为单位
   * @return JWT 字符串
   * @throws SignatureException SigningKey 的算法不被支持
   */
  public String createJwt(String subject, long ttlSeconds) throws SignatureException {
    SignatureAlgorithm signatureAlgorithm = forJcaName(this.signingKey.getAlgorithm());

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    JwtBuilder builder = Jwts.builder()
        .setIssuedAt(now)
        .setSubject(subject)
        .signWith(signatureAlgorithm, this.signingKey);

    if (ttlSeconds >= 0) {
      long expMillis = nowMillis + ttlSeconds * 1000;
      builder.setExpiration(new Date(expMillis));
    }
    return builder.compact();
  }

  /**
   * 验证并解析 JSON Web Token.
   *
   * @param jwt JWT 字符串
   * @return 身份凭据
   */
  public Claims parseJwt(String jwt) {
    try {
      Jws<Claims> jws = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt);
      return jws.getBody();
    } catch (ExpiredJwtException | UnsupportedJwtException
        | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
      return null;
    }
  }

  private static SignatureAlgorithm forJcaName(String jcaName) throws SignatureException {
    if (jcaName == null) {
      return SignatureAlgorithm.NONE;
    }

    for (SignatureAlgorithm alg : SignatureAlgorithm.values()) {
      if (jcaName.equalsIgnoreCase(alg.getJcaName())) {
        return alg;
      }
    }

    throw new SignatureException("Unsupported signature algorithm '" + jcaName + "'");
  }
}

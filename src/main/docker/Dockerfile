# 指定 Java 运行环境
FROM openjdk:8-jre-alpine

# 拷贝 Spring Framework 和其他依赖包
ADD ./org/ /app/org/
ADD ./BOOT-INF/lib/ /app/BOOT-INF/lib/

# 增加应用程序
ADD ./META-INF/ /app/META-INF/
ADD ./BOOT-INF/classes/ /app/BOOT-INF/classes/

# 开放服务端口
ENV SERVER_PORT 80
EXPOSE 80

# 配置容器启动后执行的命令
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -cp /app/ org.springframework.boot.loader.JarLauncher

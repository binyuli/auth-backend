package bz.sunlight.utils;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsHelper {

  /**
   * Bean 转换工具.
   * @param dest.
   * @param orig.
   */
  public static void copyPropertiesWithRuntimeException(Object dest, Object orig) {
    try {
      BeanUtils.copyProperties(dest, orig);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

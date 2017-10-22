package bz.sunlight.constant;

/**
 * 常量.
 */
public class BaseConstant {
  // 基础数据状态
  public static final int BASEDATA_STATUS_INVALID = 1; // 无效/作废
  public static final int BASEDATA_STATUS_VALID = 0; // 有效
  // 用户数据状态
  public static final int USER_STATUS_DISABLE = 2;// 冻结

  //角色的操作
  public static final String ROLE_OPTION_EDITABLE = "editable"; // 可编辑
  public static final String ROLE_OPTION_ABANDONABLE = "abandonable"; //可作废

  //权限类型
  public static final int PERMISSION_TYPE_PAGE = 1; //页面
  public static final int PERMISSION_TYPE_OPERATION = 2; //业务操作
}

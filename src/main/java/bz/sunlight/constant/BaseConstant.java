package bz.sunlight.constant;

/**
 * 常量.
 */
public class BaseConstant {
  // 基础数据状态
  public static final int BASEDATA_STATUS_INVALID = 0;    // 无效/作废/冻结
  public static final int BASEDATA_STATUS_VALID = 2;      // 有效

  // 用户的操作
  public static final String USER_OPTION_EDITABLE = "editable";               // 是否可编辑
  public static final String USER_OPTION_DISABLEORENABLE = "disableOrEnable"; // 是否可冻结或解冻

  //角色的操作
  public static final String ROLE_OPTION_EDITABLE = "editable"; // 可编辑
  public static final String ROLE_OPTION_ABANDONABLE = "abandonable"; //可作废

  //权限类型
  public static final int PERMISSION_TYPE_PAGE = 1; //页面
  public static final int PERMISSION_TYPE_OPERATION = 2; //业务操作
}

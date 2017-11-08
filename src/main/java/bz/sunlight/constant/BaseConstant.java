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
  public static final String USER_OPTION_DISABLE = "disable";                 // 是否可冻结
  public static final String USER_OPTION_ENABLE = "enable";                   // 是否可解冻

  //角色的操作
  public static final String ROLE_OPTION_EDITABLE = "editable"; // 可编辑
  public static final String ROLE_OPTION_ABANDONABLE = "abandonable"; //可作废

  //权限类型
  public static final int PERMISSION_TYPE_PAGE = 1; //页面
  public static final int PERMISSION_TYPE_OPERATION = 2; //业务操作

  // 页码相关
  public static final int MINIMUM_PAGE_SIZE = 10;
  public static final int DEFAULT_PAGE_SIZE = 20;

  public static final int MINIMUM_PAGE_INDEX = 0;
  public static final int DEFAULT_PAGE_INDEX = 0;

  public static final String DEFAULT_SORT_FIELD = "create_time";

  public static final String DEFAULT_SORT_TYPE = "ASC";
  public static final String DESCENDING_SORT_TYPE = "DESC";
  public static final String ASCENDING_SORT_TYPE = "ASC";

}

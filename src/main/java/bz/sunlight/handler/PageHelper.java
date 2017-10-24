package bz.sunlight.handler;

public class PageHelper {
  /**
   * 根据pageIndex,pageSize计算数据Offset.
   *
   * @param pageIndex.
   * @param pageSize.
   * @return Integer
   */
  public static Integer toOffset(Integer pageIndex, Integer pageSize) {
    if (pageSize != null) {
      int pageNo = pageIndex == null ? 1 : pageIndex;
      pageNo = Math.max(pageNo - 1, 0);
      int offset = pageNo * pageSize;
      return offset;
    } else {
      return null;
    }
  }

  /**
   * 获取页面总数
   *
   * @param totalItemCount 数据总数.
   * @param pageSize 每页展示数量.
   */
  public static Integer getTotalPage(Integer totalItemCount, Integer pageSize) {
    if (pageSize != null) {
      if (totalItemCount % pageSize == 0) {
        return totalItemCount / pageSize;
      } else {
        return totalItemCount / pageSize + 1;
      }
    } else {
      return null;
    }
  }

}

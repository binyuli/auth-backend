package bz.sunlight.handler;

public class PageHelper {
  public static Integer toOffset(Integer pageIndex, Integer pageSize) {
    int pageNo = pageIndex == null ? 1 : pageIndex;
    pageNo = Math.max(pageNo - 1, 0);
    int offset = pageNo * pageSize;
    return offset;
  }
}

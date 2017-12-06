package bz.sunlight.api;

import bz.sunlight.dto.PageDTO;
import bz.sunlight.entity.Page;
import bz.sunlight.mapstruct.PageMapStruct;
import bz.sunlight.service.PageService;
import bz.sunlight.service.UserService;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.PageDetailsVO;
import bz.sunlight.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class PageController extends BaseContext {
  @Autowired
  private PageService pageService;
  @Autowired
  private PageMapStruct pageMapStruct;
  @Autowired
  private UserService userService;

  /**
   * 获取当前用户可访问的菜单项.
   *
   * @return string
   */
  @RequestMapping("/users/me/pages")
  public ResponseEntity<ResultInfo> getMenuByUser(@RequestHeader("X-USER-ID") String userId) {
    LoginUser user = userService.getUserById(userId);
    List<PageDTO> pages = pageService.getMenuByByExample(user.getId(), user.getEnterpriseId());
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, pageMapStruct.pageDTOToMenu(pages)));
  }

  /**
   * 获取指定页当前用户的权限.
   *
   * @param code 页面编号
   * @return ResultInfo
   */
  @GetMapping(value = "/users/me/pages/{code}")
  public ResponseEntity<ResultInfo> getOperationsByPage(@PathVariable String code,
                                                        @RequestHeader("X-USER-ID") String userId) {
    LoginUser user = userService.getUserById(userId);
    Page page = pageService.getPageByCode(code);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null,
        pageService.getOperationsByPage(user.getId(), page.getId())));
  }

  /**
   * 获取page列表.
   *
   * @param maxLevel 最大层数
   * @return resultInfo
   */
  @GetMapping(value = "/pages")
  public ResponseEntity<ResultInfo> getPages(@RequestParam(value = "maxLevel", required = false) Integer maxLevel,
                                             @RequestHeader("X-USER-ID") String userId) {
    //方便计算返回结构中的 itemCount 或 operationCount
    if (maxLevel != null) {
      maxLevel += 1;
    }
    LoginUser user = userService.getUserById(userId);
    List<PageDTO> pagesDTO = pageService.getPagesByMaxLevel(maxLevel, user.getEnterpriseId());
    List<PageVO> pagesVO = pageMapStruct.dtoToPageVOList(pagesDTO);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, pagesVO));
  }

  /**
   * 获取page详情.
   *
   * @param id 页面Id
   * @return ResultInfo
   */
  @GetMapping(value = "/pages/{id}")
  public ResponseEntity<ResultInfo> getPages(@PathVariable String id, @RequestHeader("X-USER-ID") String userId) {
    LoginUser user = userService.getUserById(userId);
    List<PageDTO> pagesDTO = pageService.getPageDetailsByPageId(id, user.getEnterpriseId());
    PageDetailsVO pageDetailsVO = pageMapStruct.dtoToPageDetailsVO(pagesDTO.get(0));
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, pageDetailsVO));
  }
}
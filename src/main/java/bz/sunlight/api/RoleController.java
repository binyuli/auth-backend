package bz.sunlight.api;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dto.PageDTO;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;
import bz.sunlight.mapstruct.PageMapStruct;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.PageService;
import bz.sunlight.service.RoleService;
import bz.sunlight.service.UserService;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class RoleController extends BaseContext {
  @Autowired
  private RoleService roleService;
  @Autowired
  private RoleMapStruct roleMapStruct;
  @Autowired
  private PageMapStruct pageMapStruct;
  @Autowired
  private PageService pageService;
  @Autowired
  private UserService userService;

  /**
   * 获取角色列表.
   *
   * @return resultInfo list
   */
  @GetMapping(value = "/roles")
  public ResponseEntity<ResultInfo> getRoles(@RequestParam(value = "status", required = false) Integer status,
                                             @RequestHeader("X-USER-ID") String userId) {
    if (status == null) {
      status = BaseConstant.BASEDATA_STATUS_VALID;
    }
    LoginUser user = userService.getUserById(userId);
    String enterpriseId = user.getEnterpriseId();
    List<RoleDTO> roles = roleService.getRoles(status, enterpriseId);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, roleMapStruct.dtoToVOList(roles)));
  }

  /**
   * 新增角色.
   *
   * @param saveRoleDTO 角色信息
   * @return void
   */
  @PostMapping(value = "/roles")
  public ResponseEntity<Void> add(@RequestBody SaveRoleDTO saveRoleDTO, @RequestHeader("X-USER-ID") String userId) {
    roleService.save(saveRoleDTO, createCommonDTO(userId));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  /**
   * 修改角色.
   *
   * @param id 角色Id
   * @param editRoleDTO  角色信息
   * @return void
   */
  @PutMapping(value = "/roles/{id}")
  public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody SaveRoleDTO editRoleDTO) {
    roleService.edit(id, editRoleDTO);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  /**
   * 作废角色.
   *
   * @param id 角色Id
   * @return void
   */
  @PutMapping(value = "/roles/{id}/abandon")
  public ResponseEntity<Void> abandon(@PathVariable String id) {
    roleService.abandon(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 修改角色权限以外的信息.
   *
   * @param id  角色Id
   * @param map 角色信息
   * @return void.
   */
  @PutMapping(value = "/roles/{id}/info")
  public ResponseEntity<Void> info(@PathVariable String id, @RequestBody Map map) {
    roleService.editRoleInfo(id, map.get("name").toString());
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 获取角色详情.
   *
   * @param id 角色Id
   * @return ResultInfo
   */
  @GetMapping(value = "/roles/{id}")
  public ResponseEntity<ResultInfo> getRoleDetails(@PathVariable String id) {
    RoleVO roleVO = roleMapStruct.dtoToVO(roleService.getRole(id));
    List<PageDTO> pagesDTO = pageService.getPagesByRoleId(id);
    roleVO.setPermissions(pageMapStruct.pageDTOToRolePage(pagesDTO));
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, roleVO));
  }
}

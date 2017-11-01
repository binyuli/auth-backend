package bz.sunlight.api;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dto.PageDTO;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;
import bz.sunlight.mapstruct.PageMapStruct;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.PageService;
import bz.sunlight.service.RoleService;
import bz.sunlight.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  /**
   * 获取角色列表.
   *
   * @return resultInfo list
   */
  @GetMapping(value = "/roles")
  public ResponseEntity<ResultInfo> getRoles(@RequestParam(value = "status", required = false) Integer status) {
    if (status == null) {
      status = BaseConstant.BASEDATA_STATUS_VALID;
    }
    String enterpriseId = getLoginUser().getEnterpriseId();
    List<RoleDTO> roles = roleService.getRoles(status, enterpriseId);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, roleMapStruct.dtoToVOList(roles)));
  }

  /**
   * 新增角色.
   *
   * @param saveRoleDTO.
   * @return void
   */
  @PostMapping(value = "/roles")
  public ResponseEntity<Void> add(@RequestBody SaveRoleDTO saveRoleDTO) {
    roleService.save(saveRoleDTO, createCommonDTO());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  /**
   * 修改角色.
   *
   * @param id.
   * @param editRoleDTO.
   * @return void.
   */
  @PutMapping(value = "/roles/{id}")
  public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody SaveRoleDTO editRoleDTO) {
    roleService.edit(id, editRoleDTO);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  /**
   * 作废角色.
   *
   * @param id.
   * @return void.
   */
  @GetMapping(value = "/roles/{id}/abandon")
  public ResponseEntity<Void> abandon(@PathVariable String id) {
    roleService.abandon(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 修改角色权限以外的信息.
   *
   * @param id.
   * @param map.
   * @return void.
   */
  @PutMapping(value = "/roles/{id}/info")
  public ResponseEntity<Void> info(@PathVariable String id, @RequestBody Map map) {
    roleService.editRoleInfo(id, map.get("name").toString());
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 获取角色详情
   *
   * @param id.
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

package bz.sunlight.api;

import bz.sunlight.dto.RoleDTO;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class RoleController extends BaseController {
  @Autowired
  private RoleService roleService;
  @Autowired
  private RoleMapStruct roleMapStruct;

  /**
   * 获取角色列表.
   *
   * @return resultInfo list
   */
  @GetMapping(value = "/roles")
  public ResponseEntity<ResultInfo> getRoles() {
    List<RoleDTO> roles = roleService.getRoles();
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, roleMapStruct.dtoToVO(roles)));
  }

  /**
   * 作废角色.
   *
   * @param id.
   * @return void
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
   * @return v
   */
  @PutMapping(value = "/roles/{id}/info")
  public ResponseEntity<Void> info(@PathVariable String id, @RequestBody Map map) {
    roleService.editRoleInfo(id, map.get("name").toString());
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}

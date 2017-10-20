package bz.sunlight.api;

import bz.sunlight.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class RoleController extends BaseController {
  @Autowired
  private RoleService roleService;

  @GetMapping(value = "/roles")
  public ResultInfo getRoles() {
    return buildResultInfo(null, roleService.getRoles());
  }

  @GetMapping(value = "/roles/{id}/abandon")
  public ResponseEntity abandon(@PathVariable String id) {
    roleService.abandon(id);
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }
}

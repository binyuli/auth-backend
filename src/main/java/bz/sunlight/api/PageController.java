package bz.sunlight.api;

import java.util.List;

import bz.sunlight.dao.PageMapper;
import bz.sunlight.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PageController extends BaseController {
  @Autowired
  PageMapper pageMapper;

  @RequestMapping("/users/me/pages")
  public String getPagesByUser() {
    List<Page> pages = pageMapper.selectByExample(null);
    for (int i = 0; i < pages.size(); i++) {
      System.out.println("a = " + pages.get(i).getName());
    }
    return "asdfasdfd";
  }
}
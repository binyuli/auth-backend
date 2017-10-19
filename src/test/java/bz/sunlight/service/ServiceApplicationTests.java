package bz.sunlight.service;

import java.util.List;

import bz.sunlight.dao.ApiMapper;
import bz.sunlight.dao.PageMapper;
import bz.sunlight.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {
  @Autowired
  PageMapper pageMapper;

  @Test
  public void contextLoads() {
    List<Page> pages = pageMapper.selectByExample(null);
    for (int i = 0; i < pages.size(); i++) {
      System.out.println("a = " + pages.get(i).getName());
    }
  }

}

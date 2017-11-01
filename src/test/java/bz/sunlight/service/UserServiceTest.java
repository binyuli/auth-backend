package bz.sunlight.service;

import bz.sunlight.async.AsyncTask;
import bz.sunlight.dto.SaveUserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserServiceTest {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  public final int poolSize = 5;

//  @Autowired
//  private AsyncTask asyncTask;

  @Test
  public void edit() throws Exception {
//    String id = "786b676f-b424-11e7-b9e5-005056af50a8";
//    SaveUserDTO userDTO = new SaveUserDTO();
//    userDTO.setName("bruce");
//    userDTO.setRoles(Arrays.asList("b271a95b-237f-4275-9eb2-474777e99bd8", "ef3c8562-b424-11e7-b9e5-005056af50a8"));
//    int updateFailedCount = 0;
//
//    List<Future> tasks = new ArrayList<>();
//    for (int i = 0; i < poolSize; i++) {
//      Future<String> task = asyncTask.editDetail(id, userDTO);
//      tasks.add(task);
//    }
//
//    // 控制主线程不让其立即结束
//    while (true) {
//      int finishedCount = 0;
//      for (int i = 0; i < tasks.size(); i++) {
//        Future task = tasks.get(i);
//        if (!task.isDone()) {
//          Thread.sleep(1000);
//        } else {
//          finishedCount += 1;
//        }
//      }
//
//      if (finishedCount == tasks.size()) {
//        break;
//      }
//    }
//
//    // 最终更新成功的线程只有一个
//    for (Future task : tasks) {
//      if (task.get().equals("failed")) {
//        updateFailedCount++;
//      }
//    }
//
//    logger.info("All tasks finished.");
//    Assert.assertTrue(updateFailedCount == poolSize - 1);
  }

}
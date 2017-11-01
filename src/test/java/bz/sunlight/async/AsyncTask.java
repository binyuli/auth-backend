package bz.sunlight.async;

import bz.sunlight.dao.UserMapper;
import bz.sunlight.dao.UserRoleMapper;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.entity.User;
import bz.sunlight.entity.UserExample;
import bz.sunlight.entity.UserRole;
import bz.sunlight.entity.UserRoleExample;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.mapstruct.UserMapStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@Component
public class AsyncTask {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRoleMapper userRoleMapper;
  @Autowired
  private UserMapStruct userMapStruct;

  /**
   * 用户修改细节.
   *
   * @param String.
   * @param SaveUserDTO.
   * @return Future
   */
  @Async("myAsync")
  public Future<String> editDetail(String id, SaveUserDTO userDTO) {
    logger.info("thread " + Thread.currentThread().getId() + " started.");
    long start = System.currentTimeMillis();
    User userOrig = userMapper.selectByPrimaryKey(id);
    Random random = new Random();

    try {
      Thread.sleep(random.nextInt(100));
      if (userOrig != null) {
        User user = userMapStruct.dtoToEntity(userDTO);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(userOrig.getRowVersion());
        int updateResult = userMapper.updateByExampleSelective(user, userExample);

        if (updateResult == 0) {
          throw new BusinessException("当前用户正在被其他操作修改");
        } else {
          handleRelation(userDTO, id);
          long end = System.currentTimeMillis();
          logger.info("thread " + Thread.currentThread().getId() + " update success. time elapsed: {} ms.", end - start);
        }
      }
    } catch (Exception e) {
      long end = System.currentTimeMillis();
      logger.info("thread " + Thread.currentThread().getId() + " update failed. time elapsed: {} ms.", end - start);
      e.printStackTrace();

      return new AsyncResult<>("failed");
    }

    return new AsyncResult<>("success");
  }

  private void handleRelation(SaveUserDTO userDTO, String userId) {
    UserRoleExample userRoleExample = new UserRoleExample();
    userRoleExample.createCriteria().andUserIdEqualTo(userId);
    userRoleMapper.deleteByExample(userRoleExample);

    List<String> roles = userDTO.getRoles();
    if (roles != null && roles.size() > 0) {
      for (String role : roles) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(role);
        userRoleMapper.insert(userRole);
      }
    }
  }

}

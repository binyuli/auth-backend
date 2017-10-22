package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;

public interface UserService {
  public void save(SaveUserDTO userDTO, CommonDTO commonDTO);
}

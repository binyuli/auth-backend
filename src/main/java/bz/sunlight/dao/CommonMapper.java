package bz.sunlight.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

@Mapper
public interface CommonMapper {
  @Select("SELECT CURRENT_TIMESTAMP(6)")
  public Timestamp now();
}

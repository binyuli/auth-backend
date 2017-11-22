package bz.sunlight;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, E, PrimaryKeyT extends Serializable> {
  int countByExample(E example);

  int deleteByExample(E example);

  int deleteByPrimaryKey(PrimaryKeyT pk);

  int insert(T record);

  int insertSelective(T record);

  List<T> selectByExample(E example);

  T selectByPrimaryKey(PrimaryKeyT pk);

  int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

  int updateByExample(@Param("record") T record, @Param("example") E example);

  int updateByPrimaryKeySelective(T record);

  int updateByPrimaryKey(T record);
}

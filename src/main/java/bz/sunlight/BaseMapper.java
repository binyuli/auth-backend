package bz.sunlight;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
//todo: 目前通过generator 生成的mapper.xml 可能丢失 selectByPrimaryKey，updateByPrimaryKeySelective，updateByPrimaryKey方法
// 缺失上述方法的 有 OperationApiMapper.xml, PageApiMapper.xml，UserRoleMapper.xml, WhiteListMapper.xml 使用的时候需注意以下

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

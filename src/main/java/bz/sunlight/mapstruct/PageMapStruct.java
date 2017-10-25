package bz.sunlight.mapstruct;

import bz.sunlight.dto.OperationDTO;
import bz.sunlight.dto.PageDTO;
import bz.sunlight.dto.PageMenuDTO;
import bz.sunlight.dto.PageRoleDTO;
import bz.sunlight.entity.Operation;
import bz.sunlight.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageMapStruct {
  @Mapping(target = "title", source = "name")
  PageMenuDTO entityToMenuDTO(Page pages);

  PageDTO entityToPageDTO(Page pages);

  //TODO 暂不会使用List 转换时的 Mapping
  List<PageMenuDTO> pageDTOToMenu(List<PageDTO> pageDTOList);

  OperationDTO entityToOperationDTO(Operation operation);

  List<OperationDTO> entityToOperationDTOList(List<Operation> operation);

  List<PageRoleDTO> pageDTOToRolePage(List<PageDTO> pageDTOList);
}

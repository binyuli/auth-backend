package bz.sunlight.mapstruct;

import bz.sunlight.dto.PageMenuDTO;
import bz.sunlight.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PageMapStruct {
  @Mapping(target = "title", source = "name")
  PageMenuDTO entityToMenuDTO(Page pages);
}

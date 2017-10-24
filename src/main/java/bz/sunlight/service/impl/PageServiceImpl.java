package bz.sunlight.service.impl;

import bz.sunlight.dao.OperationMapper;
import bz.sunlight.dao.PageMapper;
import bz.sunlight.dto.PageMenuDTO;
import bz.sunlight.entity.Operation;
import bz.sunlight.entity.OperationExample;
import bz.sunlight.entity.Page;
import bz.sunlight.mapstruct.PageMapStruct;
import bz.sunlight.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {
  @Autowired
  private OperationMapper operationMapper;
  @Autowired
  private PageMapper pageMapper;
  @Autowired
  private PageMapStruct pageMapStruct;

  @Override
  public List<String> getOperationsByPage(String pageId) {
    OperationExample operationExample = new OperationExample();
    operationExample.createCriteria().andPageIdEqualTo(pageId);
    List<Operation> operations = operationMapper.selectByExample(operationExample);
    return operations.stream().map(e -> e.getCode()).collect(Collectors.toList());
  }

  @Override
  public List<PageMenuDTO> getMenuByByExample(String userId, String enterpriseId) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    //TODO 后续加缓存
    List<Page> pages = pageMapper.getMenuByByExample(userId, enterpriseId);
    stopWatch.stop();
    stopWatch.start("java 8 stream");
    //加载第一层数据
    List<Page> pagesRoot = pages.stream().filter(p -> p.getLevel() == 0).collect(Collectors.toList());
    pagesRoot.sort((p1, p2) -> p1.getWeight().compareTo(p2.getWeight()));
    stopWatch.stop();
    System.out.println(stopWatch.prettyPrint());
    pagesRoot.forEach(p -> System.out.println(p.getWeight() + " " + p.getName()));
    List<PageMenuDTO> menus = new ArrayList<PageMenuDTO>();
    buildMenuTree(pagesRoot, pages, menus);
    return menus;
  }

  private void buildMenuTree(List<Page> pagesRoot, List<Page> pages, List<PageMenuDTO> menus) {
    for (Page page : pagesRoot) {
      PageMenuDTO menu = pageMapStruct.entityToMenuDTO(page);
      recursionSubPage(menu, pages);
      menus.add(menu);
    }
  }

  private void recursionSubPage(PageMenuDTO menu, List<Page> pagesOrig) {
    List<Page> subPages = getPageByParentId(menu.getId(), pagesOrig);
    if (subPages != null && subPages.size() > 0) {
      subPages.forEach(p -> {
        PageMenuDTO pageMenuDTO = pageMapStruct.entityToMenuDTO(p);
        menu.add(pageMenuDTO);
        recursionSubPage(pageMenuDTO, pagesOrig);
      });
    } else {
      menu.setItems(null);
    }
  }

  /**
   * 根据父节点获取子节点集合
   *
   * @param parentId.
   * @param pages.
   * @return list
   */
  private List<Page> getPageByParentId(String parentId, List<Page> pages) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("获取子节点数据");
    List<Page> result = pages.stream().filter(p -> p.getParentId().equals(parentId)).collect(Collectors.toList());
    // ASC
    if (result != null && result.size() > 0) {
      result.sort((p1, p2) -> p1.getWeight().compareTo(p2.getWeight()));
    }
    stopWatch.stop();
    System.out.println(stopWatch.prettyPrint());
    return result;
  }
}

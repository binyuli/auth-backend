package bz.sunlight.service.impl;

import bz.sunlight.dao.OperationMapper;
import bz.sunlight.dao.PageMapper;
import bz.sunlight.dto.PageDTO;
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
  public List<PageDTO> getMenuByByExample(String userId, String enterpriseId) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    //TODO 加载所有页面 后续加缓存
    List<Page> pages = pageMapper.getMenuByByExample(userId, enterpriseId);
    stopWatch.stop();
    stopWatch.start("java 8 stream");
    //加载第一层数据
    List<Page> pagesRoot = pages.stream().filter(p -> p.getLevel() == 0).collect(Collectors.toList());
    pagesRoot.sort((p1, p2) -> p1.getWeight().compareTo(p2.getWeight()));
    stopWatch.stop();
    System.out.println(stopWatch.prettyPrint());
    //TODO 加载所有业务操作 后续加缓存
    OperationExample operationExample = new OperationExample();
    operationExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
    List<Operation> operationsOrig = operationMapper.selectByExample(operationExample);
    pagesRoot.forEach(p -> System.out.println(p.getWeight() + " " + p.getName()));

    return buildMenuTree(pagesRoot, pages, operationsOrig, true);
  }

  private List<PageDTO> buildMenuTree(List<Page> pagesRoot, List<Page> pages,
                                      List<Operation> operationsOrig, boolean isOperations) {
    List<PageDTO> menus = new ArrayList<PageDTO>();
    for (Page page : pagesRoot) {
      PageDTO menu = pageMapStruct.entityToPageDTO(page);
      recursion(menu, pages, operationsOrig, isOperations);
      menus.add(menu);
    }
    return menus;
  }

  private void recursion(PageDTO currentPage, List<Page> pagesOrig,
                         List<Operation> operationsOrig, boolean isOperations) {
    List<Page> subPages = getPageByParentId(currentPage.getId(), pagesOrig);
    if (subPages != null && subPages.size() > 0) {
      subPages.forEach(p -> {
        PageDTO pageDTO = pageMapStruct.entityToPageDTO(p);
        currentPage.add(pageDTO);
        recursion(pageDTO, pagesOrig, operationsOrig, isOperations);
      });
    } else {
      currentPage.setItems(null);
      if (isOperations) {
        List<Operation> operations = operationsOrig.stream()
            .filter(o -> o.getPageId().equals(currentPage.getId())).collect(Collectors.toList());
        currentPage.setOperations(pageMapStruct.entityToOperationDTOList(operations));
      }
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
    return result;
  }
}

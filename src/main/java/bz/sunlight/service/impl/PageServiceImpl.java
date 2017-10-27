package bz.sunlight.service.impl;

import bz.sunlight.dao.OperationMapper;
import bz.sunlight.dao.PageMapper;
import bz.sunlight.dto.PageDTO;
import bz.sunlight.entity.Operation;
import bz.sunlight.entity.OperationExample;
import bz.sunlight.entity.Page;
import bz.sunlight.entity.PageExample;
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

  private static final Integer rootLevel = 0;

  @Override
  public List<String> getOperationsByPage(String pageId) {
    OperationExample operationExample = new OperationExample();
    operationExample.createCriteria().andPageIdEqualTo(pageId);
    List<Operation> operations = operationMapper.selectByExample(operationExample);
    return operations.stream().map(e -> e.getCode()).collect(Collectors.toList());
  }

  @Override
  public List<PageDTO> getPagesByRoleId(String roleId) {
    //TODO 考虑加缓存
    List<Operation> operations = operationMapper.getOperationByRole(roleId);
    List<Page> pages = pageMapper.getPageByRole(roleId);
    return buildPageTree(pages, operations, true, null);
  }

  @Override
  public List<PageDTO> getPageDetailsByPageId(String pageId, String enterpriseId) {
    Page page = pageMapper.selectByPrimaryKey(pageId);
    List<Page> pages = getAllPages(enterpriseId);
    List<Operation> operations = getAllOperations(enterpriseId);
    return buildPageTree(pages, operations, true, null, page);
  }

  @Override
  public List<PageDTO> getPagesByMaxLevel(Integer maxLevel, String enterpriseId) {
    List<Page> pages = getAllPages(enterpriseId);
    List<Operation> operations = getAllOperations(enterpriseId);
    return buildPageTree(pages, operations, true, maxLevel);
  }

  @Override
  public List<PageDTO> getMenuByByExample(String userId, String enterpriseId) {
    List<Page> pages = getAllPages(userId, enterpriseId);
    //List<Operation> operationsOrig = getAllOperations(enterpriseId);
    return buildPageTree(pages, null, false, null);
  }

  private List<PageDTO> buildPageTree(List<Page> pages,
                                      List<Operation> operationsOrig, boolean isOperations, Integer maxLevel) {
    return buildPageTree(pages, operationsOrig, isOperations, maxLevel, null);
  }

  private List<PageDTO> buildPageTree(List<Page> pages,
                                      List<Operation> operationsOrig, boolean isOperations,
                                      Integer maxLevel, Page pageDetails) {
    List<Page> pagesRoot;
    if (pageDetails != null) {
      pagesRoot = pages.stream().filter(p -> p.getId().equals(pageDetails.getId())).collect(Collectors.toList());
    } else {
      pagesRoot = pages.stream().filter(p -> p.getLevel() == rootLevel).collect(Collectors.toList());
    }

    List<PageDTO> pageList = new ArrayList<PageDTO>();
    for (Page page : pagesRoot) {
      PageDTO pageDTO = pageMapStruct.entityToPageDTO(page);
      pageDTO.setMaxLevel(maxLevel != null ? maxLevel - 1 : null);
      if (maxLevel == null) {
        recursion(pageDTO, pages, operationsOrig, isOperations, maxLevel);
      } else {
        if (maxLevel > pageDTO.getLevel()) {
          recursion(pageDTO, pages, operationsOrig, isOperations, maxLevel);
        }
      }

      pageList.add(pageDTO);
    }
    return pageList;
  }

  /**
   * 递归查询节点数据到最后一层
   * 如果isOperations 为 true 则 operationsOrig 不能为空
   *
   * @param currentPage.
   * @param pagesOrig.
   * @param operationsOrig.
   * @param isOperations.
   * @param maxLevel..
   */
  private void recursion(PageDTO currentPage, List<Page> pagesOrig,
                         List<Operation> operationsOrig, boolean isOperations, Integer maxLevel) {
    if (maxLevel != null) {
      if (maxLevel <= currentPage.getLevel()) {
        return;
      }
    }
    List<Page> subPages = getPageByParentId(currentPage.getId(), pagesOrig);
    if (subPages != null && subPages.size() > 0) {
      subPages.forEach(p -> {
        PageDTO pageDTO = pageMapStruct.entityToPageDTO(p);
        pageDTO.setMaxLevel(maxLevel != null ? maxLevel - 1 : null);
        currentPage.add(pageDTO);
        recursion(pageDTO, pagesOrig, operationsOrig, isOperations, maxLevel);
      });
    } else {
      currentPage.setItems(null);
      if (isOperations) {
        List<Operation> operations = operationsOrig.stream()
            .filter(o -> o.getPageId().equals(currentPage.getId())).collect(Collectors.toList());
        if (operations != null && operations.size() > 0) {
          currentPage.setOperations(pageMapStruct.entityToOperationDTOList(operations));
        }
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

  private List<Operation> getAllOperations(String enterpriseId) {
    //TODO 加载所有业务操作 后续加缓存
    OperationExample operationExample = new OperationExample();
    operationExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
    return operationMapper.selectByExample(operationExample);
  }

  private List<Page> getAllPages(String userId, String enterpriseId) {
    //TODO 加载所有页面 后续加缓存
    return pageMapper.getMenuByByExample(userId, enterpriseId);
  }

  /**
   * 根据企业ID加载page
   *
   * @param enterpriseId.
   * @return list page
   */
  public List<Page> getAllPages(String enterpriseId) {
    //TODO 加载所有页面 后续加缓存
    PageExample pageExample = new PageExample();
    pageExample.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
    pageExample.setOrderByClause("level,Weight asc");
    return pageMapper.selectByExample(pageExample);
  }
}

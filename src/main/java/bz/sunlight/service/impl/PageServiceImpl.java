package bz.sunlight.service.impl;

import bz.sunlight.dao.OperationMapper;
import bz.sunlight.entity.Operation;
import bz.sunlight.entity.OperationExample;
import bz.sunlight.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {
  @Autowired
  private OperationMapper operationMapper;

  @Override
  public List<String> getOperationsByPage(String pageId) {
    OperationExample operationExample = new OperationExample();
    operationExample.createCriteria().andPageIdEqualTo(pageId);
    List<Operation> operations = operationMapper.selectByExample(operationExample);
    return operations.stream().map(e -> e.getCode()).collect(Collectors.toList());
  }
}

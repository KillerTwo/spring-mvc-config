package org.lwt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwt.dao.DepartmentsMapper;
import org.lwt.entity.Departments;
import org.lwt.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

  @Autowired
  private DepartmentsMapper departmentsMapper;
  
  @Override
  public List<Departments> selectAll() {
    List<Departments> list = new ArrayList<>();
    PageHelper.startPage(1, 3);
    list = departmentsMapper.selectAll();
    return list;
  }

  @Override
  public Departments getOne() {
    
    return departmentsMapper.selectByPrimaryKey("1003");
  }

}

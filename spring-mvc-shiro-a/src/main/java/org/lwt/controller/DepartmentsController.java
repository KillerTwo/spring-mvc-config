package org.lwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwt.entity.Departments;
import org.lwt.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class DepartmentsController {
  @Autowired
  private DepartmentsService departmentsService;
  
  @RequestMapping(value="/all",method=RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> selectAllDepartments(){
    Map<String, Object> map = new HashMap<>();
    List<Departments> list = departmentsService.selectAll();
    //Departments dept = departmentsService.getOne();
    map.put("msg", "success");
    map.put("results", list);
    return map;
  }
}

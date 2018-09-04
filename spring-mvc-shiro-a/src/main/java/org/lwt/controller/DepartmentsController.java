package org.lwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwt.entity.Departments;
import org.lwt.entity.JavaBeanPerson;
import org.lwt.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
  
  public String report(Model model) {
 // 报表数据源  
    JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanPerson.getList());  
          
    // 动态指定报表模板url  
    model.addAttribute("url", "/WEB-INF/jasper/MvcIReportExample.jasper");  
    model.addAttribute("format", "pdf"); // 报表格式  
    model.addAttribute("jrMainDataSource", jrDataSource);  
    return "iReportView";   // 对应jasper-defs.xml中的bean id  
  }
  
}

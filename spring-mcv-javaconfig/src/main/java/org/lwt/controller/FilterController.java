package org.lwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/filter")
public class FilterController {
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String testFilter() {
    System.out.println("test controllerִ�С�����");
    return "filter";
  }
  
}

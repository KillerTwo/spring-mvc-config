package org.lwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/filter")
public class FilterController {
  @RequestMapping(value="/test", method=RequestMethod.GET)
  public String testFilter() {
    System.out.println("test controller÷¥––°£°£°£");
    return "filter";
  }
}

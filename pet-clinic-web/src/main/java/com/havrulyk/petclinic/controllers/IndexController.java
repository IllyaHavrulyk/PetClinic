package com.havrulyk.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
  @RequestMapping({"", "/", "home", "index", "index.html"})
  public String index(){
    return "index";
  }

  @RequestMapping({"/oups"})
  public String oups() {
    return "notimplemented";
  }

  @RequestMapping({"/vets.html"})
  public String vets(){
    return "notimplemented";
  }
}

package com.havrulyk.petclinic.controllers;

import com.havrulyk.petclinic.map.OwnerServiceMap;
import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {


  private OwnerService ownerService;

  public OwnerController() {
    this.ownerService = new OwnerServiceMap();
  }

  @RequestMapping({"","/", "/index", "/index.html"})
  public String listOwners(Model model){
    ownerService.save(new Owner(1L, "George", "Phillips"));
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }

  @RequestMapping({"/find"})
  public String find(Model model){
    return "notimplemented";
  }
}

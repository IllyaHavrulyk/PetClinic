package com.havrulyk.petclinic.controllers;

import com.havrulyk.petclinic.map.VetServiceMap;
import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
  private VetService vetService;

  public VetController() {
    this.vetService = new VetServiceMap();
  }

  @RequestMapping({"","/", "/index", "/index.html"})
  public String listVets(Model model){
    vetService.save(new Vet(1L, "George", "Vet"));
    model.addAttribute("vets", vetService.findAll());
    return "vets/index";
  }
}

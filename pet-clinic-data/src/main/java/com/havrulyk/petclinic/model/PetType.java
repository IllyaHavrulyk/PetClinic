package com.havrulyk.petclinic.model;

public class PetType extends BaseEntity {
  public PetType(Long id, String name) {
    super(id);
    this.name = name;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package com.havrulyk.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
  public Pet(Long id, PetType petType, Owner owner, LocalDate birthDate) {
    super(id);
    this.petType = petType;
    this.owner = owner;
    this.birthDate = birthDate;
  }

  private PetType petType;
  private Owner owner;
  private LocalDate birthDate;

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}

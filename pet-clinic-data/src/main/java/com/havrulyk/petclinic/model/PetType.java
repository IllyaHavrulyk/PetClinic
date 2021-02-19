package com.havrulyk.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

  public PetType(Long id, String name) {
    super(id);
    this.name = name;
  }

  public PetType(Long id) {
    super(id);
  }

  @Column(name = "name")
  private String name;

  public PetType() {
    super();

  }
}

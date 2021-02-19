package com.havrulyk.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

  public Specialty(Long id) {
    super(id);
  }


  @Column(name = "description")
  private String description;


}

package com.havrulyk.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Person extends BaseEntity {

  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;


}

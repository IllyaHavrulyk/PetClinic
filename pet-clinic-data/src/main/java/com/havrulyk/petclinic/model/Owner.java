package com.havrulyk.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Builder
@Table(name = "owners")
public class Owner extends Person {

    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Owner() {
        super();
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();


    public Owner(Long id, String firstName, String lastName, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.pets = pets;
    }
}

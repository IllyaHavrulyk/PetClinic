package com.havrulyk.petclinic.repositories;

import com.havrulyk.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}

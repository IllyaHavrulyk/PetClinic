package com.havrulyk.petclinic.repositories;

import com.havrulyk.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}

package com.havrulyk.petclinic.repositories;

import com.havrulyk.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}

package com.havrulyk.petclinic.repositories;

import com.havrulyk.petclinic.model.Owner;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
  Owner findByLastName(String lastName);

  @Override
  Optional<Owner> findById(Long aLong);
}

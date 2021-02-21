package com.havrulyk.petclinic.services;

import com.havrulyk.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}

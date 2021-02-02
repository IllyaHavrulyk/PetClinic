package com.havrulyk.petclinic.services;

import spring.illyahavrulyk.javapetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastname(String lastName);
}

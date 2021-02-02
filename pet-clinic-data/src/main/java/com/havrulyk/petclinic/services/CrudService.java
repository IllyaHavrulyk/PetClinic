package com.havrulyk.petclinic.services;

import java.util.Set;

public interface CrudService <T, ID>{
    T save(T entity);
    Set<T> findAll();
    T findById(ID id);
    void delete(T object);
    void deleteById(ID id);
}

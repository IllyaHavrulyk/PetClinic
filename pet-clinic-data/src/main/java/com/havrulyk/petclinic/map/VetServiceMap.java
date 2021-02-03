package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.services.CrudService;
import com.havrulyk.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
    @Override
    public Vet save(Vet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.BaseEntity;
import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.model.Pet;
import com.havrulyk.petclinic.services.OwnerService;

import com.havrulyk.petclinic.services.PetService;
import com.havrulyk.petclinic.services.PetTypeService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Autowired
    private PetTypeService petTypeService;

    @Autowired
    private PetService petService;

    @Override
    public Owner save(Owner entity) {

        if(entity != null){
            if(entity.getPets() != null){
                entity.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required.");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(entity.getId(), entity);
        }else{
            return null;
        }

    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastname(String lastName) {
        return null;
    }
}

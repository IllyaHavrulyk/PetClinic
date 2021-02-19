package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.Pet;
import com.havrulyk.petclinic.repositories.PetRepository;
import com.havrulyk.petclinic.services.PetService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

  private final PetRepository petRepository;

  public PetSDJpaService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Pet save(Pet entity) {
    return petRepository.save(entity);
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public Pet findById(Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    petRepository.deleteById(id);
  }
}

package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.PetType;
import com.havrulyk.petclinic.repositories.OwnerRepository;
import com.havrulyk.petclinic.repositories.PetRepository;
import com.havrulyk.petclinic.repositories.PetTypeRepository;
import com.havrulyk.petclinic.services.PetTypeService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  public PetTypeSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public PetType save(PetType entity) {
    return petTypeRepository.save(entity);
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long id) {
    return petTypeRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepository.deleteById(id);
  }
}

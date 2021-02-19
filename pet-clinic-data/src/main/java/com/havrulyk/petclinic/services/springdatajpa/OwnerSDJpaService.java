package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.repositories.OwnerRepository;
import com.havrulyk.petclinic.repositories.PetRepository;
import com.havrulyk.petclinic.repositories.PetTypeRepository;
import com.havrulyk.petclinic.services.OwnerService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Owner findByLastname(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public Owner save(Owner entity) {
    return ownerRepository.save(entity);
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long id) {
    return ownerRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }
}

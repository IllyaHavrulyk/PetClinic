package com.havrulyk.petclinic.services.springdatajpa;


import com.havrulyk.petclinic.model.Specialty;
import com.havrulyk.petclinic.repositories.OwnerRepository;
import com.havrulyk.petclinic.repositories.PetRepository;
import com.havrulyk.petclinic.repositories.PetTypeRepository;
import com.havrulyk.petclinic.repositories.SpecialtyRepository;
import com.havrulyk.petclinic.services.SpecialtiesService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSpecialtySDJpaService implements SpecialtiesService {
  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;
  private final SpecialtyRepository specialtyRepository;

  public VetSpecialtySDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository, SpecialtyRepository specialtyRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Specialty save(Specialty entity) {
    return specialtyRepository.save(entity);
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialties = new HashSet<>();
    specialtyRepository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public Specialty findById(Long id) {
    return specialtyRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Specialty object) {
    specialtyRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
      specialtyRepository.deleteById(id);
  }
}

package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.repositories.VetRepository;
import com.havrulyk.petclinic.services.VetService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

  private final VetRepository vetRepository;

  public VetSDJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Vet save(Vet entity) {

    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");
    System.out.println("##########################");

    return vetRepository.save(entity);
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long id) {
   return vetRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    vetRepository.deleteById(id);
  }
}

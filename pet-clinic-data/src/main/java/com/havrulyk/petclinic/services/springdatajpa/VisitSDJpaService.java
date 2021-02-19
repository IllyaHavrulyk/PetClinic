package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.Visit;
import com.havrulyk.petclinic.repositories.VisitRepository;
import com.havrulyk.petclinic.services.VisitService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

  private VisitRepository visitRepository;

  public VisitSDJpaService(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Visit save(Visit entity) {
    return visitRepository.save(entity);
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
      visitRepository.deleteById(id);
  }
}

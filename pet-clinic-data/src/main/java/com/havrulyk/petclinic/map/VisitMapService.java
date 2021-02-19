package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.Visit;
import com.havrulyk.petclinic.services.VisitService;
import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Visit save(Visit visit) {
    if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
      throw new RuntimeException("Invalid visit");
    }
    return super.save(visit.getId(), visit);
  }

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Visit visit) {
    super.delete(visit);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }
}

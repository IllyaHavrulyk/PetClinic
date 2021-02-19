package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.Specialty;
import com.havrulyk.petclinic.services.SpecialtiesService;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtiesMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

  @Override
  public Specialty save(Specialty entity) {
    return super.save(entity.getId(), entity);
  }

  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void delete(Specialty object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}

package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.PetType;
import com.havrulyk.petclinic.services.PetTypeService;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public PetType save(PetType entity) {
    return super.save(entity.getId(), entity);
  }

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(PetType object) {
    super.delete(object);
  }

  @Override
  public PetType findById(Long id) {
    return super.findById(id);
  }
}

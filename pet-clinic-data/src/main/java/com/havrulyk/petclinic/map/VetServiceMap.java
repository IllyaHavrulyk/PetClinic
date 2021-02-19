package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.Specialty;
import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.services.SpecialtiesService;
import com.havrulyk.petclinic.services.VetService;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

    private SpecialtiesService specialtiesService;

    public VetServiceMap() {
        specialtiesService = new SpecialtiesMapService();
    }

    @Override
    public Vet save(Vet entity) {
        if(entity.getSpecialties().size() > 1){
            entity.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null){
                    Specialty savedSpecialty = specialtiesService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

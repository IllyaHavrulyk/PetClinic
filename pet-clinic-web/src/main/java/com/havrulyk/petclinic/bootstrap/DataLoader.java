package com.havrulyk.petclinic.bootstrap;



import com.havrulyk.petclinic.map.OwnerServiceMap;
import com.havrulyk.petclinic.map.PetTypeMapService;
import com.havrulyk.petclinic.map.SpecialtiesMapService;
import com.havrulyk.petclinic.map.VetServiceMap;
import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.model.Pet;
import com.havrulyk.petclinic.model.PetType;
import com.havrulyk.petclinic.model.Specialty;
import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.services.OwnerService;
import com.havrulyk.petclinic.services.PetTypeService;
import com.havrulyk.petclinic.services.SpecialtiesService;
import com.havrulyk.petclinic.services.VetService;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtiesService specialtiesService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtiesService = specialtiesService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();
    if(count == 0){
      loadData();
    }

  }

  private void loadData(){
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType cat = new PetType();
    cat.setName("Cat");
    petTypeService.save(dog);
    petTypeService.save(cat);
    System.out.println("Saved PetTypes ...");

    Owner borisJohnson = new Owner(Long.valueOf(12345), "Boris", "Johnson");
    borisJohnson.setAddress("Pushkina");
    borisJohnson.setCity("Moscow");
    borisJohnson.setTelephone("+32010233432");
    Set<Pet> borisPets = new HashSet<>();
    Pet jason = new Pet(1L, "Jason", new PetType(1L, "Dog"), borisJohnson, LocalDate.now());
    borisPets.add(jason);
    borisJohnson.setPets(borisPets);


    Owner michaelAnisimov = new Owner(Long.valueOf(12346), "Michael", "Anisimov");
    borisJohnson.setAddress("Kolotushkina");
    borisJohnson.setCity("Moscow");
    borisJohnson.setTelephone("+32010233432");
    Set<Pet> michaelPets = new HashSet<>();
    Pet Mock = new Pet(2L, "Mock", new PetType(2L, "Cat"), michaelAnisimov, LocalDate.now());
    michaelPets.add(Mock);
    michaelAnisimov.setPets(michaelPets);

    ownerService.save(borisJohnson);
    ownerService.save(michaelAnisimov);
    System.out.println(ownerService.findAll().toString());
    System.out.println("Saved owners....");

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    specialtiesService.save(radiology);

    Specialty dentistry = new Specialty();
    radiology.setDescription("Dentistry");
    specialtiesService.save(dentistry);

    Specialty surgery = new Specialty();
    radiology.setDescription("Surgery");
    specialtiesService.save(surgery);

    Vet karimArabi = new Vet(Long.valueOf(21353), "Karim", "Arabi");
    Vet chingChong = new Vet(Long.valueOf(21353), "Ching", "Chong");
    karimArabi.getSpecialties().add(radiology);
    karimArabi.getSpecialties().add(dentistry);

    chingChong.getSpecialties().add(dentistry);
    chingChong.getSpecialties().add(surgery);
    vetService.save(karimArabi);
    vetService.save(chingChong);
    System.out.println("Saved vets....");
  }
}

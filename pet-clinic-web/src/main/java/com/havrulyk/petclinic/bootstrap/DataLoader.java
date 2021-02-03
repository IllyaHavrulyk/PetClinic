package com.havrulyk.petclinic.bootstrap;


import com.havrulyk.petclinic.map.OwnerServiceMap;
import com.havrulyk.petclinic.map.VetServiceMap;
import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.model.Vet;
import com.havrulyk.petclinic.services.OwnerService;
import com.havrulyk.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner borisJohnson = new Owner(Long.valueOf(12345),"Boris", "Johnson");
        Owner michaelAnisimov = new Owner(Long.valueOf(12346),"Michael", "Anisimov");
        ownerService.save(borisJohnson);
        ownerService.save(michaelAnisimov);
        System.out.println("Saved owners....");

        Vet karimArabi = new Vet(Long.valueOf(21353),"Karim", "Arabi");
        Vet chingChong = new Vet(Long.valueOf(21353),"Ching", "Chong");
        vetService.save(karimArabi);
        vetService.save(chingChong);
        System.out.println("Saved vets....");
    }
}

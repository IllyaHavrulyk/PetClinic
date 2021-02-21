package com.havrulyk.petclinic.map;

import com.havrulyk.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap OwnerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        OwnerServiceMap = new OwnerServiceMap();

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);

        OwnerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = OwnerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = OwnerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = new Owner();
        owner2.setId(id);

        Owner savedOwner = OwnerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());

    }


    @Test
    @Disabled
    void saveNoId() {
        Owner owner = new Owner();
        owner.setLastName("Johnson");
        Owner savedOwner = OwnerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        OwnerServiceMap.delete(OwnerServiceMap.findById(ownerId));

        assertEquals(0, OwnerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        OwnerServiceMap.deleteById(ownerId);

        assertEquals(0, OwnerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = OwnerServiceMap.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId, smith.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = OwnerServiceMap.findByLastName("foo");

        assertNull(smith);
    }
}
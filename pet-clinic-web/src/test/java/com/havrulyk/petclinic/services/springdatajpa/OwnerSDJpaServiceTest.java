package com.havrulyk.petclinic.services.springdatajpa;

import com.havrulyk.petclinic.model.Owner;
import com.havrulyk.petclinic.repositories.OwnerRepository;
import com.havrulyk.petclinic.repositories.PetRepository;
import com.havrulyk.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final String LAST_NAME = "Smith";
    Owner smith;


    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        smith = new Owner();
        smith.setLastName(LAST_NAME);
        smith.setId(1L);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(smith);
        Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(smith.getLastName(), this.smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        when(ownerRepository.save(any())).thenReturn(smith);
        Owner returnedOwner = ownerRepository.save(ownerToSave);
        assertNotNull(returnedOwner);
        assertEquals(ownerToSave.getId(), returnedOwner.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(smith);
        when(ownerRepository.findAll()).thenReturn(returnOwners);
        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {

    }

    @Test
    void delete() {
        ownerSDJpaService.delete(smith);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }
}
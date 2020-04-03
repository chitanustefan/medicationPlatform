package com.app.app.services.interfaces;

import com.app.app.entities.Caregiver;

import java.util.List;

public interface ICaregiverService {

    List<Caregiver> getAllCaregivers();
    Caregiver saveCaregiver(Caregiver user);
    Caregiver updateCaregiver(Long id, Caregiver user);
    void deleteCaregiver(Long id);

}

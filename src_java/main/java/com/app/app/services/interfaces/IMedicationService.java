package com.app.app.services.interfaces;

import com.app.app.entities.Medication;

import java.util.List;

public interface IMedicationService {

    List<Medication> getAllMedications();
    Medication saveMedication(Medication user);
    Medication updateMedication(Long id, Medication user);
    void deleteMedication(Long id);
}

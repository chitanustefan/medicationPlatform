package com.app.app.services;

import com.app.app.entities.Medication;
import com.app.app.entities.MedicationTaken;
import com.app.app.repository.MedicationTakenRepository;
import com.app.app.services.interfaces.IMedicationTakenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationTakenService implements IMedicationTakenService {


    @Autowired
    MedicationTakenRepository medicationTakenRepository;

    @Override
    public List<MedicationTaken> getAllMedicationsTaken() {
        List<MedicationTaken> result = medicationTakenRepository.findAll();
        return result;
    }

    @Override
    public MedicationTaken saveMedicationTaken(MedicationTaken medicationTaken) {
        System.out.println("SAVE: " + medicationTaken.getMedication() + " " + medicationTaken.getId_medication_taken() + " " + medicationTaken.getDateTaken());
        MedicationTaken savedUser = this.medicationTakenRepository.save(medicationTaken);
        System.out.println("SAVED: " + savedUser.getMedication());
        return savedUser;
    }

    @Override
    public MedicationTaken updateMedicationTaken(Long id, MedicationTaken user) {
        return null;
    }

    @Override
    public void deleteMedicationTaken(Long id) {

    }
}

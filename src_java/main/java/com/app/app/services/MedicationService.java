package com.app.app.services;

import com.app.app.entities.Medication;
import com.app.app.repository.MedicationRepository;
import com.app.app.repository.UserRepository;
import com.app.app.services.interfaces.IMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService implements IMedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Medication> getAllMedications() {
        List<Medication> result = medicationRepository.findAll();
        return result;
    }

    @Override
    public Medication saveMedication(Medication user) {
        Medication savedUser = this.medicationRepository.save(user);
        return savedUser;
    }

    @Override
    public Medication updateMedication(Long id, Medication medication) {

        Medication optionalUser = medicationRepository.findById(id).get();
        Medication result = medicationRepository.save(medication);

        return result;
    }

    @Override
    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}

package com.app.app.services.interfaces;

import com.app.app.entities.Medication;
import com.app.app.entities.MedicationTaken;

import java.util.List;

public interface IMedicationTakenService {

    List<MedicationTaken> getAllMedicationsTaken();
    MedicationTaken saveMedicationTaken(MedicationTaken user);
    MedicationTaken updateMedicationTaken(Long id, MedicationTaken user);
    void deleteMedicationTaken(Long id);

}

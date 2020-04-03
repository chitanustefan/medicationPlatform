package com.app.app.services.interfaces;

import com.app.app.entities.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> getAllPatient();
    Patient savePatient(Patient user);
    Patient updatePatient(Long id, Patient user);
    void deletePatient(Long id);
}

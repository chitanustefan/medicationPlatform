package com.app.app.services.interfaces;

import com.app.app.entities.Doctor;

import java.util.List;

public interface IDoctorService {

    List<Doctor> getAllDoctor();
    Doctor saveDoctor(Doctor user);
    Doctor updateDoctor(Long id, Doctor user);
    void deleteDoctor(Long id);

}

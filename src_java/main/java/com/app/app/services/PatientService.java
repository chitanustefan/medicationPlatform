package com.app.app.services;

import com.app.app.entities.Patient;
import com.app.app.repository.PatientRepository;
import com.app.app.repository.UserRepository;
import com.app.app.services.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> result = patientRepository.findAll();
        return result;
    }

    @Override
    public Patient savePatient(Patient user) {
        Patient savedUser = this.patientRepository.save(user);
        return savedUser;

    }

    public Patient getPatientByID(long id){
        List<Patient> list = patientRepository.findAll();
        for(Patient p : list){
            if (p.getId_patient() == id)
            {
                return p;

            }
        }
        return null;
    }

    @Override
    @Transactional
    public Patient updatePatient(Long id, Patient user) {

        System.out.println("ID: " + id + "Patient Name: " + user.getUser().getName());
        Patient optionalUser = patientRepository.findById(id).get();
        optionalUser.setUser(user.getUser());
        userRepository.save(optionalUser.getUser());
        Patient result = patientRepository.save(optionalUser);
        System.out.println(result.getUser().getName());
        return result;

    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

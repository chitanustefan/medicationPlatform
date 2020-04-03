package com.app.app.services;


import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import com.app.app.repository.UserRepository;
import com.app.app.services.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Doctor> getAllDoctor() {
        List<Doctor> result = doctorRepository.findAll();
        return result;
    }

    @Override
    public Doctor saveDoctor(Doctor user) {
        Doctor savedUser = this.doctorRepository.save(user);
        return savedUser;
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor user) {
        Doctor optionalUser = doctorRepository.findById(id).get();
        optionalUser.setUser(user.getUser());
        userRepository.save(optionalUser.getUser());
        Doctor result = doctorRepository.save(optionalUser);
        return result;
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);

    }

    public Doctor getDoctorById(int id_user){
        boolean found = false;
        List<Doctor> list = getAllDoctor();
        for(Doctor d : list){
            if(d.getUser().getId_user() == id_user) {
                found = true;
                return d;
            }
        }
        return null;
    }
}

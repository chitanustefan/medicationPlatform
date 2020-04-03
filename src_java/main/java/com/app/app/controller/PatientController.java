package com.app.app.controller;

import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.entities.User;
import com.app.app.services.DoctorService;
import com.app.app.services.PatientService;
import com.app.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    PatientService patientService = new PatientService();

    @Autowired
    UserService userService = new UserService();

    @Autowired
    DoctorService doctorService = new DoctorService();

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

    public String dateFormater(String dateFromJSON, String expectedFormat, String oldFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
        Date date = null;
        String convertedDate = null;
        try {
            date = dateFormat.parse(dateFromJSON);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(expectedFormat);
            convertedDate = simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertedDate;
    }

    @GetMapping("{id_user}/caregiver")
    public List<Patient> getPatientsByCaregiver(@PathVariable("id_user") int id_user){
        List<Patient> list = patientService.getAllPatient();
        List<Patient> l2 = new ArrayList<>();
        for(Patient p: list){
            if (p.getCaregiver().getId_caregiver()==id_user+1){
                l2.add(p);
            }

        }
        return l2;
    }

    @PostMapping("{id_user}/add/patient")
    public Patient addPatient(@RequestBody User user, @PathVariable("id_user") int id_user) throws ParseException {
        Date date = format.parse(dateFormater(user.getBirthday().toString(), "dd/MM/YYYY", "EEE MMM dd HH:mm:ss z yyyy"));

       // System.out.println("ID User: " + id_user);
        Doctor d = doctorService.getDoctorById(id_user);

       // System.out.println("Doctor " + d.getUser().getName());
       // System.out.println("Name: " + user.getName());
        user.setRole("patient");

        Patient p = new Patient();
        p.setUser(user);
        p.setDoctor(d);
        return patientService.savePatient(p);

    }

    @PostMapping("/delete/patient")
    public void deletePatient(@RequestBody int id_patient) {

        System.out.println("Delete: " + id_patient);
        Long id = (long) id_patient;
        patientService.deletePatient(id);

    }

    @GetMapping("{id_user}/doctor/patient-list")
    public List<Patient> getAllPatients(@PathVariable("id_user") int id_user){
        List<Patient> list = patientService.getAllPatient();
        return list;
    }

    @PostMapping("/doctor/patient-list")
    public Patient editPatient(@RequestBody Patient patient){
        //System.out.println(patient.getId_patient());
        return patientService.updatePatient(patient.getId_patient(), patient);
    }

}

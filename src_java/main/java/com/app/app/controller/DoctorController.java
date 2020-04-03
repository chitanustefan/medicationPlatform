package com.app.app.controller;


import com.app.app.entities.*;
import com.app.app.repository.UserRepository;
import com.app.app.services.*;
import com.app.app.services.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @Autowired
    private DoctorService doctorService = new DoctorService();


    @Autowired
    UserRepository userRepository;

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


    @GetMapping("{id_user}/doctor/get")
    public Doctor getDoctorById(@PathVariable("id_user") int id_user){
        boolean found = false;
        List<Doctor> list = doctorService.getAllDoctor();
        for(Doctor d : list){
            if(d.getUser().getId_user() == id_user) {
                found = true;
                return d;
            }
        }
        return null;

    }



}

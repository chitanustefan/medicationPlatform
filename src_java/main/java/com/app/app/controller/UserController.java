package com.app.app.controller;


import com.app.app.entities.Caregiver;
import com.app.app.entities.Doctor;
import com.app.app.entities.Patient;
import com.app.app.entities.User;
import com.app.app.repository.CaregiverRepository;
import com.app.app.repository.DoctorRepository;
import com.app.app.repository.PatientRepository;
import com.app.app.repository.UserRepository;
import com.app.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    @Autowired
    private UserService userService = new UserService();

    @Autowired
    UserRepository userRepository;

    @Autowired
    CaregiverRepository caregiverRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        System.out.println(user.getEmail() + " " + user.getPassword());
        User u = userService.login(user.getEmail(),user.getPassword());
        System.out.println("idUser: " + u.getId_user());
        return u;
    }

    @GetMapping("/")
    public String home() {
        System.out.println("test");
        return "test";
    }


    @PostMapping("/register")
    public Doctor register() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
/*        User u = new User();
        u.setName("Caregiver");
        u.setEmail("caregiver@gmail.com");
        u.setPassword("parola");
        u.setRole("caregiver");
        u.setBirthday(new Date());
        u.setGender("f");

        userRepository.save(u);

        Caregiver d = new Caregiver();
        d.setUser(u);*/

/*        User u = new User();
        u.setName("Patient");
        u.setEmail("patient@gmail.com");
        u.setPassword("parola");
        u.setRole("patient");
        u.setBirthday(new Date());
        u.setGender("m");

        userRepository.save(u);

        Patient d = new Patient();
        d.setUser(u);*/

        User u = new User();
        u.setName("Doctor");
        u.setEmail("doctor@gmail.com");
        u.setPassword("parola");
        u.setRole("doctor");
       // Date date = format.parse( "27/06/1998" );
        u.setBirthday(new Date());
        u.setGender("f");

        userRepository.save(u);

        Doctor d = new Doctor();
        d.setUser(u);

        return doctorRepository.save(d);
    }

}

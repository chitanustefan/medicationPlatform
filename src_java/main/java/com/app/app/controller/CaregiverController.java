package com.app.app.controller;

import com.app.app.entities.Caregiver;
import com.app.app.entities.Patient;
import com.app.app.entities.Recommendation;
import com.app.app.entities.User;
import com.app.app.repository.UserRepository;
import com.app.app.services.CaregiverService;
import com.app.app.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CaregiverController {


    @Autowired
    private CaregiverService caregiverService = new CaregiverService();

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecommendationService recommendationService = new RecommendationService();

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

    @PostMapping("{id_user}/add/caregiver")
    public Caregiver addCaregiver(@RequestBody User user, @PathVariable("id_user") int id_user) throws ParseException {

        Date date = format.parse(dateFormater(user.getBirthday().toString(),
                "dd/MM/YYYY", "EEE MMM dd HH:mm:ss z yyyy"));

        System.out.println(user.getName());
        user.setRole("caregiver");

        userRepository.save(user);

        Caregiver p = new Caregiver();
        p.setUser(user);

        return caregiverService.saveCaregiver(p);

    }

    @GetMapping("{id_user}/doctor/caregiver-list")
    public List<Caregiver> getAllCaregivers(@PathVariable("id_user") int id_user){
        List<Caregiver> list = caregiverService.getAllCaregivers();
        return list;
    }

    @GetMapping("/caregiver/recommendations")
    public List<Recommendation> getAllRecommendations(){
        List<Recommendation> list = recommendationService.getAllRecommendations();
        return list;
    }

    @PostMapping("/delete/caregiver")
    public void deleteCaregiver(@RequestBody int id_caregiver) {
        System.out.println("Delete: " + id_caregiver);
        Long id = (long) id_caregiver;
        caregiverService.deleteCaregiver(id);

    }

    @PostMapping("/doctor/caregiver-list")
    public Caregiver editPatient(@RequestBody Caregiver caregiver){
        //System.out.println(patient.getId_patient());
        return caregiverService.updateCaregiver(caregiver.getId_caregiver(), caregiver);
    }

}

package com.app.app.services;

import com.app.app.entities.Caregiver;
import com.app.app.repository.CaregiverRepository;
import com.app.app.repository.UserRepository;
import com.app.app.services.interfaces.ICaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiverService implements ICaregiverService {


    @Autowired
    CaregiverRepository caregiverRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Caregiver> getAllCaregivers() {
        List<Caregiver> result = caregiverRepository.findAll();
        return result;
    }

    @Override
    public Caregiver saveCaregiver(Caregiver user) {
        Caregiver savedUser = this.caregiverRepository.save(user);
        return savedUser;
    }

    @Override
    public Caregiver updateCaregiver(Long id, Caregiver caregiver) {

        System.out.println(caregiver.getUser().getName());
        Caregiver optionalUser = caregiverRepository.findById(id).get();
        optionalUser.setUser(caregiver.getUser());
/*        userRepository.save(optionalUser.getUser());*/
        Caregiver result = caregiverRepository.save(caregiver);
        return result;
    }

    @Override
    public void deleteCaregiver(Long id) {

        caregiverRepository.deleteById(id);

    }
}

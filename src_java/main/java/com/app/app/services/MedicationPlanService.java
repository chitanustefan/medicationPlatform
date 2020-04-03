package com.app.app.services;

import com.app.app.entities.MedicationPlan;
import com.app.app.repository.MedicationPlanRepository;
import com.app.app.repository.MedicationRepository;
import com.app.app.services.interfaces.IMedicationPlanService;
import com.app.app.services.interfaces.IMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicationPlanService implements IMedicationPlanService {


    @Autowired
    MedicationPlanRepository medicationPlanRepository;

    @Override
    public List<MedicationPlan> getAllMedicationPlans() {
        List<MedicationPlan> result = medicationPlanRepository.findAll();
        return result;
    }

    @Override
    public MedicationPlan saveMedicationPlan(MedicationPlan medPlan) {
        MedicationPlan savedPlan = this.medicationPlanRepository.save(medPlan);
        return savedPlan;
    }

    @Override
    public MedicationPlan updateMedicationPlan(Long id, MedicationPlan user) {
        MedicationPlan optionalUser = medicationPlanRepository.findById(id).get();
        MedicationPlan result = medicationPlanRepository.save(user);
        return result;
    }

    @Override
    public void deleteMedicationPlan(Long id) {
        medicationPlanRepository.deleteById(id);
    }
}

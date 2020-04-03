package com.app.app.services;

import com.app.app.entities.MedicationPerPlan;
import com.app.app.repository.MedicationPerPlanRepository;
import com.app.app.services.interfaces.IMedicationPerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationPerPlanService implements IMedicationPerPlanService {

    @Autowired
    MedicationPerPlanRepository medicationPerPlanRepository;

    @Override
    public List<MedicationPerPlan> getAllMedicationPerPlans() {
        List<MedicationPerPlan> result = medicationPerPlanRepository.findAll();
        return result;
    }

    @Override
    public MedicationPerPlan saveMedicationPerlan(MedicationPerPlan mpp) {
        MedicationPerPlan savedPlan = this.medicationPerPlanRepository.save(mpp);
        return savedPlan;
    }

    @Override
    public MedicationPerPlan updateMedicationPerPlan(Long id, MedicationPerPlan mpp) {
        return null;
    }

    @Override
    public void deleteMedicationPlan(Long id) {
        medicationPerPlanRepository.deleteById(id);
    }
}

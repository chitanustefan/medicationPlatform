package com.app.app.services.interfaces;

import com.app.app.entities.MedicationPerPlan;

import java.util.List;

public interface IMedicationPerPlanService {

    List<MedicationPerPlan> getAllMedicationPerPlans();
    MedicationPerPlan saveMedicationPerlan(MedicationPerPlan mpp);
    MedicationPerPlan updateMedicationPerPlan(Long id, MedicationPerPlan mpp);
    void deleteMedicationPlan(Long id);

}

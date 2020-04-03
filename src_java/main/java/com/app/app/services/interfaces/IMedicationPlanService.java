package com.app.app.services.interfaces;

import com.app.app.entities.MedicationPlan;

import java.util.List;

public interface IMedicationPlanService {

    List<MedicationPlan> getAllMedicationPlans();
    MedicationPlan saveMedicationPlan(MedicationPlan user);
    MedicationPlan updateMedicationPlan(Long id, MedicationPlan user);
    void deleteMedicationPlan(Long id);
}

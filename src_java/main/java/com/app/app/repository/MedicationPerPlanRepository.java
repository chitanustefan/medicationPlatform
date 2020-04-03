package com.app.app.repository;

import com.app.app.entities.MedicationPerPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationPerPlanRepository extends JpaRepository<MedicationPerPlan, Long> {
}

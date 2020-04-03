package com.app.app.repository;

import com.app.app.entities.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Long> {
}

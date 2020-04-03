package com.app.app.repository;

import com.app.app.entities.Medication;
import com.app.app.entities.MedicationTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationTakenRepository extends JpaRepository<MedicationTaken, Long> {
}

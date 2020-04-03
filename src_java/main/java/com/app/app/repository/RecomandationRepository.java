package com.app.app.repository;

import com.app.app.entities.Patient;
import com.app.app.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomandationRepository extends JpaRepository<Recommendation, Long> {
}

package com.app.app.services.interfaces;

import com.app.app.entities.Patient;
import com.app.app.entities.Recommendation;

import java.util.List;

public interface IRecommendationService {

    List<Recommendation> getAllRecommendations();
    Recommendation saveRecommendation(Recommendation user);
    Recommendation updateRecommendation(Long id, Recommendation user);
    void deleteRecommendation(Long id);
}

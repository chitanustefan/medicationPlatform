package com.app.app.services;

import com.app.app.entities.Recommendation;
import com.app.app.repository.RecomandationRepository;
import com.app.app.services.interfaces.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService implements IRecommendationService {

    @Autowired
    RecomandationRepository recomandationRepository;

    @Override
    public List<Recommendation> getAllRecommendations() {
        List<Recommendation> result = recomandationRepository.findAll();
        return result;
    }

    @Override
    public Recommendation saveRecommendation(Recommendation user) {
        Recommendation savedUser = this.recomandationRepository.save(user);
        return savedUser;
    }

    @Override
    public Recommendation updateRecommendation(Long id, Recommendation user) {
        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {

    }
}

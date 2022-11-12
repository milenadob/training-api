package com.mak.trainingapi.service;

import com.mak.trainingapi.dto.TrainingProjection;
import com.mak.trainingapi.model.Training;
import com.mak.trainingapi.model.User;
import com.mak.trainingapi.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserService userService;

    public TrainingService(TrainingRepository trainingRepository, UserService userService) {
        this.trainingRepository = trainingRepository;
        this.userService = userService;
    }

    public void addTraining(Training training, String login) {
        User user = userService.getUserByLogin(login);
        training.setUser(user);
        trainingRepository.save(training);
    }

    public ArrayList<TrainingProjection> getAllTrainings(String login){
        User user = userService.getUserByLogin(login);
        return trainingRepository.getTrainingByUser(user);
    }
}

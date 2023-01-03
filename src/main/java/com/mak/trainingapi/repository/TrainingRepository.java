package com.mak.trainingapi.repository;

import com.mak.trainingapi.model.Training;
import com.mak.trainingapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    ArrayList<Training> findAll();

    ArrayList<Training> getTrainingByUser(User user);

    void deleteAllByUser(User user);
}

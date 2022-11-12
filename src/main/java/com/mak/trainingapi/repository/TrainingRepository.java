package com.mak.trainingapi.repository;

import com.mak.trainingapi.dto.TrainingProjection;
import com.mak.trainingapi.model.Training;
import com.mak.trainingapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    ArrayList<Training> findAll();

    ArrayList<TrainingProjection> getTrainingByUser(User user);
}

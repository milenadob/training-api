package com.mak.trainingapi.service;

import com.mak.trainingapi.dto.TrainingCreateDto;
import com.mak.trainingapi.dto.TrainingUpdateDto;
import com.mak.trainingapi.dto.TrainingViewDto;
import com.mak.trainingapi.mapper.TrainingMapper;
import com.mak.trainingapi.mapper.TrainingViewMapper;
import com.mak.trainingapi.model.Training;
import com.mak.trainingapi.model.User;
import com.mak.trainingapi.repository.TrainingRepository;
import com.mak.trainingapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;

    public TrainingService(TrainingRepository trainingRepository, UserRepository userRepository) {
        this.trainingRepository = trainingRepository;
        this.userRepository = userRepository;
    }

    public TrainingViewDto getTrainingById(Integer id){
        Training training = trainingRepository.findById(id).orElseThrow();
        return TrainingViewMapper.INSTANCE.trainingToTrainingViewDto(training);
    }
    public ArrayList<TrainingViewDto> getAllTrainings(String username){
        User user = userRepository.getUserByUsername(username);
        ArrayList<Training> trainingArrayList = trainingRepository.getTrainingByUser(user);

        return TrainingViewMapper.INSTANCE.toTrainingViewList(trainingArrayList);
    }

    @Transactional
    public TrainingViewDto createTraining(TrainingCreateDto trainingCreateDto){
        User user = userRepository.getUserByUsername(trainingCreateDto.getUsername());
        Training training = TrainingMapper.INSTANCE.trainingCreateDtoToTraining(trainingCreateDto);
        System.out.println(training);
        training.setUser(user);
        System.out.println(training);
        trainingRepository.save(training);
        return TrainingViewMapper.INSTANCE.trainingToTrainingViewDto(training);
    }

    //TODO custom exception
    @Transactional
    public TrainingViewDto updateTraining(Integer id, TrainingUpdateDto trainingUpdateDto){
        Training training = trainingRepository.findById(id).orElseThrow();
        TrainingMapper.INSTANCE.trainingUpdateDtoToTraining(trainingUpdateDto, training);

        trainingRepository.save(training);

        return TrainingViewMapper.INSTANCE.trainingToTrainingViewDto(training);
    }
    @Transactional
    public void deleteTraining(Integer id){
        Training training = trainingRepository.findById(id).orElseThrow();
        trainingRepository.delete(training);
    }
}

package com.mak.trainingapi.controller;

import com.mak.trainingapi.dto.TrainingCreateDto;
import com.mak.trainingapi.dto.TrainingUpdateDto;
import com.mak.trainingapi.dto.TrainingViewDto;
import com.mak.trainingapi.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/training")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public TrainingViewDto create(@Valid @RequestBody TrainingCreateDto trainingCreateDto) {
        return trainingService.createTraining(trainingCreateDto);
    }

    @PutMapping("{id}")
    public TrainingViewDto update(@PathVariable Integer id, @RequestBody @Valid TrainingUpdateDto trainingUpdateDto){
        return trainingService.updateTraining(id,trainingUpdateDto);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        trainingService.deleteTraining(id);
    }

    @GetMapping("/user/{username}")
    public ArrayList<TrainingViewDto> getAllTrainingsByUser(@PathVariable String username) {
        return trainingService.getAllTrainings(username);
    }

    @GetMapping("{id}")
    public TrainingViewDto getTrainingById(@PathVariable Integer id){
        return trainingService.getTrainingById(id);
    }
}

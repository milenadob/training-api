package com.mak.trainingapi.controller;

import com.mak.trainingapi.dto.TrainingProjection;
import com.mak.trainingapi.model.Training;
import com.mak.trainingapi.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("training")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/{login}")
    public @ResponseBody void addTraining(@PathVariable String login, @Valid @RequestBody Training training) {
        trainingService.addTraining(training, login);
    }

    @GetMapping("/{login}")
    public @ResponseBody ArrayList<TrainingProjection> getAllTrainings(@PathVariable String login) {
        return trainingService.getAllTrainings(login);
    }
}

package com.Taczek.RudyProject.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/train")
public class TrainController {
    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService =  trainService;
    }

    @GetMapping
    public List<Train> getTrain() {
        return trainService.getTrain();
    }

    @PostMapping
    public void registerNewTrain(@RequestBody Train train) { //we take request body and map it to train
        trainService.addNewTrain(train);
    }

    @DeleteMapping(path = "{trainId}")
    public void deleteTrain(@PathVariable("trainId") Long trainId ){
        trainService.deleteTrain(trainId);
    }

    @PutMapping(path = "{trainId}")
    public void updateTrain(
            @PathVariable("trainId") Long trainId,
            @RequestParam(required = false) String number,
            @RequestParam(required = false) String owner) {
        trainService.updateTrain(trainId, number, owner);
    }

}

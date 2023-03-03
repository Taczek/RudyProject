package com.Taczek.RudyProject.train;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TrainService {
    private final TrainRepository trainRepository;
    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }


    public List<Train> getTrain() {
        return trainRepository.findAll();
    }

    public void addNewTrain(Train train) {
        Optional<Train> trainOptional = trainRepository.findTrainsByNumber(train.getNumber());
        if (trainOptional.isPresent()) {
            throw new IllegalStateException("number taken");
        }
        trainRepository.save(train);
    }
    public void deleteTrain (Long trainId) {
            boolean exists = trainRepository.existsById(trainId);
            if (!exists) {
                throw new IllegalStateException("train with id " + trainId +  " does not exists");
            }
            trainRepository.deleteById(trainId);
        }
    @Transactional
    public void updateTrain (Long trainId, String number, String owner){
        Train train =  trainRepository.findById(trainId).orElseThrow(() -> new IllegalStateException(
                "train with id " + trainId + " does not exist"));


        if (number != null && number.length() > 0 && !Objects.equals(train.getNumber(), number)) {
            Optional<Train> trainOptional = trainRepository.findTrainsByNumber(number);
            if (trainOptional.isPresent()) {
                throw new IllegalStateException("number taken");
            }
            train.setNumber(number);
        }

        if (owner != null && owner.length() > 0 && !Objects.equals(train.getOwner(), owner)) {
            train.setOwner(owner);
        }
    }
}


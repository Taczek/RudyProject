package com.Taczek.RudyProject.train;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TrainConfig {

    @Bean
    CommandLineRunner commandLineRunner(TrainRepository repository) {
        return args -> {
            Train trainOne = new Train(
                    1L     ,
                    "Company1",
                     "777L",
                    "cargo",
                    LocalDate.of(2022, APRIL, 20)
                    );
            Train trainTwo = new Train(
                    2L,
                    "Company2",
                     "778L",
                    "cargo",
                    LocalDate.of(2021, APRIL, 20)
                    );
            repository.saveAll(
                    List.of(trainOne, trainTwo)
            );
        };
    }
}

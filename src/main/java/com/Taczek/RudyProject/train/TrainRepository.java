package com.Taczek.RudyProject.train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    @Query("SELECT s FROM Train s WHERE s.number = ?1")
    Optional<Train> findTrainsByNumber(String number);
}

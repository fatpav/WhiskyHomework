package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);
    List<Whisky> findWhiskyByAge(int age);
    List<Whisky> findWhiskyByDistilleryAndAge(Distillery distillery, int age);
    List<Whisky> findByDistilleryRegion( region);
}
//

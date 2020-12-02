package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year, @RequestParam(name = "distillery", required = false) String distillery, @RequestParam(name = "age", required = false)Integer age){
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        if (distillery != null & age != null) {
            Distillery foundDistillery = distilleryRepository.findDistilleryByName(distillery);
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryAndAge(foundDistillery, age), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryAndAge(
//            @RequestParam(name = "distillery", required = false)String distillery, @RequestParam(name = "age", required = false)Integer age) {
//        if (distillery != null & age != null) {
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryNameAndAge(distillery, age), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }

}

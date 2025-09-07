package com.example.demomusic.controller;

import com.example.demomusic.models.CheckInModel;
import com.example.demomusic.models.CheckOutModel;
import com.example.demomusic.services.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController("/train")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping("/checkIn")
    public ResponseEntity<String> checkIn(@Valid @RequestBody CheckInModel checkIn) {

        trainService.checkIn(checkIn.getCardId(), checkIn.getStation(), Instant.now());
        return ResponseEntity.ok(
                String.format("CardId %s is Checked in from %s!", checkIn.getCardId(), checkIn.getStation()));
    }

    @PostMapping("/checkOut")
    public ResponseEntity<String> checkOut(@RequestBody CheckOutModel checkOut) {

        trainService.checkOut(checkOut.getCardId(), checkOut.getStation(), Instant.now());
        return ResponseEntity.ok(String.format("CardId %s is Checked Out from %s!",
                checkOut.getCardId(), checkOut.getStation()));
    }


}

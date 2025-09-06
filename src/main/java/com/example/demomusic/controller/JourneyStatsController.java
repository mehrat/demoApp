package com.example.demomusic.controller;

import com.example.demomusic.exception.JourneyException;
import com.example.demomusic.models.JourneyModel;
import com.example.demomusic.services.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController("/journey")
public class JourneyStatsController {

    JourneyService journeyService;

    @Autowired
    public JourneyStatsController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @PostMapping("getJourneyAverageTime")
    public ResponseEntity<String> getJourneyAverageTime(@RequestBody JourneyModel journeyModel) {

        final String sourceDest = journeyModel.getSource() + journeyModel.getDest();

        try {
            long journeyAverageTime = journeyService.getJourneyAverageTime(sourceDest);
            String message = "Average time between " + journeyModel.getSource() + " and "
                    + journeyModel.getDest() + " is " + journeyAverageTime;
            return ResponseEntity.ok(message);
        } catch (JourneyException journeyException) {
            return ResponseEntity.badRequest().body(journeyException.getMessage());
        }


    }
}

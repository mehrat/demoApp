package com.example.demomusic.services.impl;

import com.example.demomusic.models.JourneyModel;
import com.example.demomusic.models.JourneyStats;
import com.example.demomusic.repository.JourneyTimeDao;
import com.example.demomusic.repository.TrainTimingDAO;
import com.example.demomusic.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Configuration
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainTimingDAO trainTimingDAO;

    @Override
    public void checkIn(final String cardId, final String station, final Instant checkInTime) {
        trainTimingDAO.checkIn(cardId, station, checkInTime);
    }

    @Override
    public void checkOut(String cardId, String station, Instant checkOutTime) {
        trainTimingDAO.checkOut(cardId, station, checkOutTime);
    }
}

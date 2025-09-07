package com.example.demomusic.services.impl;

import com.example.demomusic.models.JourneyModel;
import com.example.demomusic.models.JourneyStats;
import com.example.demomusic.repository.JourneyTimeDao;
import com.example.demomusic.repository.TrainTimingDAO;
import com.example.demomusic.services.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Configuration
public class TrainServiceImpl implements TrainService {

    private static final Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);

    private final TrainTimingDAO trainTimingDAO;

    @Autowired
    public TrainServiceImpl(TrainTimingDAO trainTimingDAO) {
        this.trainTimingDAO = trainTimingDAO;
    }

    @Override
    public void checkIn(final String cardId, final String station, final Instant checkInTime) {
        logger.info("Check In requested for user {} at station {} at {}", cardId, station, checkInTime.toString());
        trainTimingDAO.checkIn(cardId, station, checkInTime);
    }

    @Override
    public void checkOut(String cardId, String station, Instant checkOutTime) {
        trainTimingDAO.checkOut(cardId, station, checkOutTime);
    }
}

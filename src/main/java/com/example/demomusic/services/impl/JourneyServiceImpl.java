package com.example.demomusic.services.impl;

import com.example.demomusic.exception.JourneyException;
import com.example.demomusic.models.JourneyStats;
import com.example.demomusic.repository.JourneyTimeDao;
import com.example.demomusic.services.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyTimeDao journeyTimeDao;

    @Override
    public long getJourneyAverageTime(String sourceDest) {
        JourneyStats journeyStats = journeyTimeDao.getJourneyStats(sourceDest);
        if (journeyStats != null) {
            return journeyStats.getAverageTime();
        } else {
            throw new JourneyException("Insufficiant Data");
        }
    }
}

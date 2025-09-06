package com.example.demomusic.repository;

import com.example.demomusic.models.JourneyStats;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JourneyTimeDao {

    Map<String, JourneyStats> journeyTimeMap = new ConcurrentHashMap<>();

    public JourneyStats getJourneyStats(String sourceDest) {
            return journeyTimeMap.getOrDefault(sourceDest, null);
    }

    public void addJourneyData(String sourceToDest, long journeyTime) {
        JourneyStats journeyStats;

        if (journeyTimeMap.containsKey(sourceToDest)) {

            JourneyStats oldJourneyStats = journeyTimeMap.get(sourceToDest);
            long newTime = oldJourneyStats.getTotalTime() + journeyTime;
            int newCount = oldJourneyStats.getCount() + 1;

            journeyStats = new JourneyStats(newTime, newCount);

        } else {
            journeyStats = new JourneyStats(journeyTime, 1);

        }
        journeyTimeMap.put(sourceToDest, journeyStats);

    }


}

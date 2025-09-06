package com.example.demomusic.repository;

import com.example.demomusic.models.StationCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Component
public class TrainTimingDAO {

    @Autowired
    private JourneyTimeDao journeyTimeDao;

    private final Map<String, StationCheckIn> checkInDataMap = new ConcurrentHashMap<>();

    public void checkIn(final String cardId, String startStation, final Instant checkInTime) {

        final StationCheckIn stationCheckIn = new StationCheckIn(startStation, checkInTime);
        if (checkInDataMap.containsKey(cardId)) {
            return;
        }
        checkInDataMap.put(cardId, stationCheckIn);
    }

    public void checkOut(final String cardId, final String endStation, final Instant checkOutTime) {

        if (checkInDataMap.containsKey(cardId)) {

            final StationCheckIn stationCheckIn = checkInDataMap.get(cardId);
            final String sourceToDest = stationCheckIn.getStation() + endStation;
            final long journeyTime = Duration.between(stationCheckIn.getCheckIn(), checkOutTime).getSeconds();
            journeyTimeDao.addJourneyData(sourceToDest, journeyTime);

            checkInDataMap.remove(cardId);
        }

    }
}

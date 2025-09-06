package com.example.demomusic.services;

import java.time.Instant;

public interface TrainService {

    void checkIn(String cardId, String station, Instant checkInTime);

    void checkOut(String cardId, String station, Instant checkOutTime);

}

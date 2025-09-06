package com.example.demomusic.models;

import java.time.Instant;

public class StationCheckIn {

    private String station;
    private Instant checkIn;

    public StationCheckIn(String station, Instant checkIn) {
        this.station = station;
        this.checkIn = checkIn;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Instant checkIn) {
        this.checkIn = checkIn;
    }
}

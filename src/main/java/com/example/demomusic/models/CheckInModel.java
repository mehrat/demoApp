package com.example.demomusic.models;

public class CheckInModel {

    private String cardId;
    private String station;

    public CheckInModel(String cardId, String station) {
        this.cardId = cardId;
        this.station = station;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

}

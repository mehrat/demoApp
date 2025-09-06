package com.example.demomusic.models;

public class CheckOutModel {

    private String cardId;
    private String station;

    public CheckOutModel(String cardId, String station) {
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

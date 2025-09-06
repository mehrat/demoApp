package com.example.demomusic.models;

public class JourneyStats {

    private long totalTime;

    private int count;

    public JourneyStats(long totalTime, int count) {
        this.totalTime = totalTime;
        this.count = count;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public int getCount() {
        return count;
    }

    public long getAverageTime() {
        return this.totalTime / this.count;
    }
}

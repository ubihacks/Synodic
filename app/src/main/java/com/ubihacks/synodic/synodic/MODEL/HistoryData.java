package com.ubihacks.synodic.synodic.MODEL;

/**
 * Created by Atiq on 5/20/2018.
 */

public class HistoryData {
    int deviceId;
    String from;
    String to;

    public HistoryData(int deviceId, String from, String to) {
        this.deviceId = deviceId;
        this.from = from;
        this.to = to;
    }

    public HistoryData() {

    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

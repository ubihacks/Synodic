package com.ubihacks.synodic.synodic.MODEL;

import java.io.Serializable;

/**
 * Created by UBAID IFTIKHAR on 10/21/2018.
 */

public class Summary implements Serializable {


    int deviceId;

    String deviceName;
    double maxSpeed;

    double averageSpeed ;

    double distance;

    double spentFuel;

    double engineHours;

    public Summary() {
    }

    public Summary(int deviceId, String deviceName, double maxSpeed, double averageSpeed, double distance, double spentFuel, double engineHours) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.maxSpeed = maxSpeed;
        this.averageSpeed = averageSpeed;
        this.distance = distance;
        this.spentFuel = spentFuel;
        this.engineHours = engineHours;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpentFuel() {
        return spentFuel;
    }

    public void setSpentFuel(double spentFuel) {
        this.spentFuel = spentFuel;
    }

    public double getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(double engineHours) {
        this.engineHours = engineHours;
    }
}


package com.ubihacks.synodic.synodic.MODEL;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stop {

    @SerializedName("deviceId")
    @Expose
    private Integer deviceId;
    @SerializedName("deviceName")
    @Expose
    private String deviceName;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("averageSpeed")
    @Expose
    private Integer averageSpeed;
    @SerializedName("maxSpeed")
    @Expose
    private Integer maxSpeed;
    @SerializedName("spentFuel")
    @Expose
    private Integer spentFuel;
    @SerializedName("startOdometer")
    @Expose
    private Double startOdometer;
    @SerializedName("endOdometer")
    @Expose
    private Double endOdometer;
    @SerializedName("positionId")
    @Expose
    private Integer positionId;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("engineHours")
    @Expose
    private Integer engineHours;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Integer averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getSpentFuel() {
        return spentFuel;
    }

    public void setSpentFuel(Integer spentFuel) {
        this.spentFuel = spentFuel;
    }

    public Double getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(Double startOdometer) {
        this.startOdometer = startOdometer;
    }

    public Double getEndOdometer() {
        return endOdometer;
    }

    public void setEndOdometer(Double endOdometer) {
        this.endOdometer = endOdometer;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(Integer engineHours) {
        this.engineHours = engineHours;
    }

}
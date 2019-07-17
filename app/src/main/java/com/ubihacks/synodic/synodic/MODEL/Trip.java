
package com.ubihacks.synodic.synodic.MODEL;

import com.google.gson.annotations.SerializedName;

public class Trip {

    @SerializedName("averageSpeed")
    private Double mAverageSpeed;
    @SerializedName("deviceId")
    private Long mDeviceId;
    @SerializedName("deviceName")
    private String mDeviceName;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName("driverName")
    private Object mDriverName;
    @SerializedName("driverUniqueId")
    private Object mDriverUniqueId;
    @SerializedName("duration")
    private Long mDuration;
    @SerializedName("endAddress")
    private Object mEndAddress;
    @SerializedName("endLat")
    private Double mEndLat;
    @SerializedName("endLon")
    private Double mEndLon;
    @SerializedName("endOdometer")
    private Double mEndOdometer;
    @SerializedName("endPositionId")
    private Long mEndPositionId;
    @SerializedName("endTime")
    private String mEndTime;
    @SerializedName("maxSpeed")
    private Double mMaxSpeed;
    @SerializedName("spentFuel")
    private Long mSpentFuel;
    @SerializedName("startAddress")
    private Object mStartAddress;
    @SerializedName("startLat")
    private Double mStartLat;
    @SerializedName("startLon")
    private Double mStartLon;
    @SerializedName("startOdometer")
    private Double mStartOdometer;
    @SerializedName("startPositionId")
    private Long mStartPositionId;
    @SerializedName("startTime")
    private String mStartTime;

    public Double getAverageSpeed() {
        return mAverageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        mAverageSpeed = averageSpeed;
    }

    public Long getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(Long deviceId) {
        mDeviceId = deviceId;
    }

    public String getDeviceName() {
        return mDeviceName;
    }

    public void setDeviceName(String deviceName) {
        mDeviceName = deviceName;
    }

    public Double getDistance() {
        return mDistance;
    }

    public void setDistance(Double distance) {
        mDistance = distance;
    }

    public Object getDriverName() {
        return mDriverName;
    }

    public void setDriverName(Object driverName) {
        mDriverName = driverName;
    }

    public Object getDriverUniqueId() {
        return mDriverUniqueId;
    }

    public void setDriverUniqueId(Object driverUniqueId) {
        mDriverUniqueId = driverUniqueId;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Object getEndAddress() {
        return mEndAddress;
    }

    public void setEndAddress(Object endAddress) {
        mEndAddress = endAddress;
    }

    public Double getEndLat() {
        return mEndLat;
    }

    public void setEndLat(Double endLat) {
        mEndLat = endLat;
    }

    public Double getEndLon() {
        return mEndLon;
    }

    public void setEndLon(Double endLon) {
        mEndLon = endLon;
    }

    public Double getEndOdometer() {
        return mEndOdometer;
    }

    public void setEndOdometer(Double endOdometer) {
        mEndOdometer = endOdometer;
    }

    public Long getEndPositionId() {
        return mEndPositionId;
    }

    public void setEndPositionId(Long endPositionId) {
        mEndPositionId = endPositionId;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public Double getMaxSpeed() {
        return mMaxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        mMaxSpeed = maxSpeed;
    }

    public Long getSpentFuel() {
        return mSpentFuel;
    }

    public void setSpentFuel(Long spentFuel) {
        mSpentFuel = spentFuel;
    }

    public Object getStartAddress() {
        return mStartAddress;
    }

    public void setStartAddress(Object startAddress) {
        mStartAddress = startAddress;
    }

    public Double getStartLat() {
        return mStartLat;
    }

    public void setStartLat(Double startLat) {
        mStartLat = startLat;
    }

    public Double getStartLon() {
        return mStartLon;
    }

    public void setStartLon(Double startLon) {
        mStartLon = startLon;
    }

    public Double getStartOdometer() {
        return mStartOdometer;
    }

    public void setStartOdometer(Double startOdometer) {
        mStartOdometer = startOdometer;
    }

    public Long getStartPositionId() {
        return mStartPositionId;
    }

    public void setStartPositionId(Long startPositionId) {
        mStartPositionId = startPositionId;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

}

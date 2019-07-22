package com.ubihacks.synodic.synodic.MODEL;

import java.util.Date;

public class DriverStatus {
    public static final String STATUS_DRIVING = "driving";
    public static final String STATUS_ON_DUTY = "onDuty";
    public static final String STATUS_OFF_DUTY = "offDuty";
    public static final String STATUS_SLEEPER_BERTH = "sleeper";

    private String driverState;
    private Date serverTime;
    private long userId;
    private long deviceId;
    private String driverComment;

    public String getDriverState() {
        return driverState;
    }

    public void setDriverState(String driverState) {
        this.driverState = driverState;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(String driverComment) {
        this.driverComment = driverComment;
    }

}

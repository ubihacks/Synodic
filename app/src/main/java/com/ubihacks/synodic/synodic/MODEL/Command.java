package com.ubihacks.synodic.synodic.MODEL;

/**
 * Created by Atiq on 5/18/2018.
 */

public class Command {

    private int deviceId;
    private String type;
    public static String ENGINE_STOP = "engineStop";
    public static String ENGINE_RESUME = "engineResume";

    public Command() {
    }

    public Command(int deviceId) {
        this.deviceId = deviceId;
    }

    public Command(int deviceId, Boolean engine) {
        this.type = (engine) ? ENGINE_RESUME : ENGINE_STOP;
        this.deviceId = deviceId;
    }

    public Command(int deviceId, String type) {
        this.deviceId = deviceId;
        this.type = type;
    }

    public Command stop(){
        this.type = ENGINE_STOP;
        return this;
    }

    public Command resume(){
        this.type = ENGINE_RESUME;
        return this;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

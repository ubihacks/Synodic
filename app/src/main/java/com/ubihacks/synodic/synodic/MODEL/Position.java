package com.ubihacks.synodic.synodic.MODEL;

import java.util.ArrayList;
import java.util.Date;

public class Position
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private Attributes attributes;

    public Attributes getAttributes() { return this.attributes; }

    public void setAttributes(Attributes attributes) { this.attributes = attributes; }

    private int deviceId;

    public int getDeviceId() { return this.deviceId; }

    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }

    private double type;

    public double getType() { return this.type; }

    public void setType(double type) { this.type = type; }

    private String protocol;

    public String getProtocol() { return this.protocol; }

    public void setProtocol(String protocol) { this.protocol = protocol; }

    private Date serverTime;

    public Date getServerTime() { return this.serverTime; }

    public void setServerTime(Date serverTime) { this.serverTime = serverTime; }

    private Date deviceTime;

    public Date getDeviceTime() { return this.deviceTime; }

    public void setDeviceTime(Date deviceTime) { this.deviceTime = deviceTime; }

    private Date fixTime;

    public Date getFixTime() { return this.fixTime; }

    public void setFixTime(Date fixTime) { this.fixTime = fixTime; }

    private boolean outdated;

    public boolean getOutdated() { return this.outdated; }

    public void setOutdated(boolean outdated) { this.outdated = outdated; }

    private boolean valid;

    public boolean getValid() { return this.valid; }

    public void setValid(boolean valid) { this.valid = valid; }

    private double latitude;

    public double getLatitude() { return this.latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    private double longitude;

    public double getLongitude() { return this.longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    private double altitude;

    public double getAltitude() { return this.altitude; }

    public void setAltitude(double altitude) { this.altitude = altitude; }

    private double speed;

    public double getSpeed() { return this.speed; }

    public void setSpeed(double speed) { this.speed = speed; }

    private double course;

    public double getCourse() { return this.course; }

    public void setCourse(double course) { this.course = course; }

    private String address;

    public String getAddress() { return this.address; }

    public void setAddress(String address) { this.address = address; }

    private double accuracy;

    public double getAccuracy() { return this.accuracy; }

    public void setAccuracy(double accuracy) { this.accuracy = accuracy; }

    private Network network;

    public Network getNetwork() { return this.network; }

    public void setNetwork(Network network) { this.network = network; }

    public class Attributes
    {
        private boolean ignition;

        public boolean getIgnition() { return this.ignition; }

        public void setIgnition(boolean ignition) { this.ignition = ignition; }

        private double status;

        public double getStatus() { return this.status; }

        public void setStatus(double status) { this.status = status; }

        private double distance;

        public double getDistance() { return this.distance; }

        public void setDistance(double distance) { this.distance = distance; }

        private double totalDistance;

        public double getTotalDistance() { return this.totalDistance; }

        public void setTotalDistance(double totalDistance) { this.totalDistance = totalDistance; }

        private boolean motion;

        public boolean getMotion() { return this.motion; }

        public void setMotion(boolean motion) { this.motion = motion; }

        private Integer batteryLevel;

        public Integer getBatteryLevel() { return this.batteryLevel; }

        public void setBatteryLevel(Integer batteryLevel) { this.batteryLevel = batteryLevel; }

        private Integer sat;

        public Integer getSat() { return this.sat; }

        public void setSat(Integer sat) { this.sat = sat; }

        private Boolean charge;

        public Boolean getCharge() { return this.charge; }

        public void setCharge(Boolean charge) { this.charge = charge; }

        private Integer in2;

        public Integer getIn2() { return this.in2; }

        public void setIn2(Integer in2) { this.in2 = in2; }

        private Integer panic;

        public Integer getPanic() { return this.panic; }

        public void setPanic(Integer panic) { this.panic = panic; }

        private Integer out2;

        public Integer getOut2() { return this.out2; }

        public void setOut2(Integer out2) { this.out2 = out2; }

        private Integer fuel = 0;

        public Integer getFuel() { return this.fuel; }

        public void setFuel(Integer fuel) { this.fuel = fuel; }

        private Integer odometer;

        public Integer getOdometer() { return this.odometer; }

        public void setOdometer(Integer odometer) { this.odometer = odometer; }

        private String alarm;

        public String getAlarm() { return this.alarm; }

        public void setAlarm(String alarm) { this.alarm = alarm; }
    }

    public class CellTower
    {
        private int cellId;

        public int getCellId() { return this.cellId; }

        public void setCellId(int cellId) { this.cellId = cellId; }

        private int locationAreaCode;

        public int getLocationAreaCode() { return this.locationAreaCode; }

        public void setLocationAreaCode(int locationAreaCode) { this.locationAreaCode = locationAreaCode; }

        private int mobileCountryCode;

        public int getMobileCountryCode() { return this.mobileCountryCode; }

        public void setMobileCountryCode(int mobileCountryCode) { this.mobileCountryCode = mobileCountryCode; }

        private int mobileNetworkCode;

        public int getMobileNetworkCode() { return this.mobileNetworkCode; }

        public void setMobileNetworkCode(int mobileNetworkCode) { this.mobileNetworkCode = mobileNetworkCode; }
    }

    public class Network
    {
        private String radioType;

        public String getRadioType() { return this.radioType; }

        public void setRadioType(String radioType) { this.radioType = radioType; }

        private boolean considerIp;

        public boolean getConsiderIp() { return this.considerIp; }

        public void setConsiderIp(boolean considerIp) { this.considerIp = considerIp; }

        private ArrayList<CellTower> cellTowers;

        public ArrayList<CellTower> getCellTowers() { return this.cellTowers; }

        public void setCellTowers(ArrayList<CellTower> cellTowers) { this.cellTowers = cellTowers; }
    }
}
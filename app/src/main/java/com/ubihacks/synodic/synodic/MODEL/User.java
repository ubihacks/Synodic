package com.ubihacks.synodic.synodic.MODEL;

/**
 * Created by Atiq on 4/10/2018.
 */

public class User {
    private int id;
    private Attributes attributes;
    private String name;
    private String login;
    private String email;
    private String phone;
    private boolean readonly;
    private boolean admin;
    private String map;
    private int latitude;
    private int longitude;
    private int zoom;
    private boolean twelveHourFormat;
    private String coordinateFormat;
    private boolean disabled;
    private Object expirationTime;
    private int deviceLimit;
    private int userLimit;
    private boolean deviceReadonly;
    private String token;
    private boolean limitCommands;
    private String poiLayer;
    private Object password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public boolean isTwelveHourFormat() {
        return twelveHourFormat;
    }

    public void setTwelveHourFormat(boolean twelveHourFormat) {
        this.twelveHourFormat = twelveHourFormat;
    }

    public String getCoordinateFormat() {
        return coordinateFormat;
    }

    public void setCoordinateFormat(String coordinateFormat) {
        this.coordinateFormat = coordinateFormat;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Object getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Object expirationTime) {
        this.expirationTime = expirationTime;
    }

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }

    public int getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }

    public boolean isDeviceReadonly() {
        return deviceReadonly;
    }

    public void setDeviceReadonly(boolean deviceReadonly) {
        this.deviceReadonly = deviceReadonly;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLimitCommands() {
        return limitCommands;
    }

    public void setLimitCommands(boolean limitCommands) {
        this.limitCommands = limitCommands;
    }

    public String getPoiLayer() {
        return poiLayer;
    }

    public void setPoiLayer(String poiLayer) {
        this.poiLayer = poiLayer;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public static class Attributes {
    }
}

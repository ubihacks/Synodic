package com.ubihacks.synodic.synodic.MODEL;

import java.util.Date;
import java.util.List;

/**
 * Created by Atiq on 4/10/2018.
 */

public class Device {

    private int id;
    private Attributes attributes;
    private int groupId;
    private String name;
    private String uniqueId;
    private String status;
    private Date lastUpdate;
    private int positionId;
    private String phone;
    private String model;
    private String contact;
    private Object category;
    private boolean disabled;
    private List<?> geofenceIds;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<?> getGeofenceIds() {
        return geofenceIds;
    }

    public void setGeofenceIds(List<?> geofenceIds) {
        this.geofenceIds = geofenceIds;
    }

    public static class Attributes {
    }
}

package com.ubihacks.synodic.synodic.MODEL;

import java.util.LinkedList;
import java.util.List;

public class sideTrip {
    public List<Position> positionList;

    public sideTrip()
    {
        positionList = new LinkedList<>();
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> position) {
        this.positionList = position;
    }
}

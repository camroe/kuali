package com.company;


/**
 * Created by camerroe on 3/24/15.
 */
public class Elevator {
    private String direction;
    private String state = ElevatorConstants.STATE_LOCKEDOUT;
    private int tripCount=0;
    private int floorCount=0;
    private int maxFloor =0;
    private int minFloor =0;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        if (this.minFloor>this.maxFloor) {
            this.maxFloor=minFloor;
            System.out.println("Warning: Min Floor .gt. Max Floor");
        }
    }

    //GETTERS - SETTERS

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void setState(String state) {
        //DO state transition checks here
        this.state = state;
    }

    public String getDirection() {
        return direction;
    }

    public String getState() {
        return state;
    }

    public int getTripCount() {
        return tripCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public boolean requestTOFloor(int floor) {
        if (floor > maxFloor) {
            floor = maxFloor;
            System.out.println("Warn: request to floor .gt. max floor");
        } else if (floor < minFloor) {
            floor = minFloor;
            System.out.println("Warn: requet to floor .lt. min floor");
        }
        if (this.isLockedout() || this.isMoving()) {
            return false;
        } else return true;
    }

    public boolean isLockedout(){
        return (state == ElevatorConstants.STATE_LOCKEDOUT);
    }

    public boolean isMoving() {
        return (state == ElevatorConstants.STATE_MOVING);
    }

    public boolean isStopped() {
        return (state == ElevatorConstants.STATE_STOPPED);
    }

    public void moveToFloor


}

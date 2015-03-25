package com.company;

/**
 * Created by camerroe on 3/24/15.
 */
public class Elevator {
    //TODO:Direction and State could be tied (ie. up/down = moving)
    private String direction;
    private String state = ElevatorConstants.STATE_LOCKEDOUT;
    private String doorState = ElevatorConstants.DOOR_STATE_CLOSED;
    private int tripCount = 0;
    private int floorCount = 0;
    private int maxFloor = 0;
    private int minFloor = 0;
    private int currentFloor = 0;
    private ReportingInterface reportingEntity;
    private int ID;

    public Elevator(int minFloor, int maxFloor, ReportingInterface reportingEntity, int ID) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        if (this.minFloor > this.maxFloor) {
            this.maxFloor = minFloor;
            System.out.println("Warning: Min Floor .gt. Max Floor");
        }
        currentFloor = this.minFloor;
        this.reportingEntity = reportingEntity;
        this.ID = ID;
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
        if (this.isLockedout() || this.isMoving()) {
            return false;
        } else {
            moveToFloor(floor);
            return true;
        }
    }

    public boolean isLockedout() {
        return (state == ElevatorConstants.STATE_LOCKEDOUT);
    }

    public boolean isMoving() {
        return (state == ElevatorConstants.STATE_MOVING);
    }

    public boolean isStopped() {
        return (state == ElevatorConstants.STATE_STOPPED);
    }

    private void moveToFloor(int targetFloor) {
        if (targetFloor > maxFloor) {
            targetFloor = maxFloor;
            System.out.println("Warn: request to floor .gt. max floor");
        } else if (targetFloor < minFloor) {
            targetFloor = minFloor;
            System.out.println("Warn: request to floor .lt. min floor");
        }
        //TODO: To really simulate there should be time added here to simulate travel time.
        this.tripCount++;
        this.doorState = ElevatorConstants.DOOR_STATE_CLOSED;
        setDirection(this.currentFloor, targetFloor);
        this.state = ElevatorConstants.STATE_MOVING;
        setDirection(currentFloor, targetFloor);
        Elevator elevatorMoving;
        if (direction == ElevatorConstants.DIRECTION_UP) {
            for (int i = currentFloor; i < targetFloor; i++) {
                this.currentFloor = i + 1;
                this.reportingEntity.reportFloor(ID, currentFloor);
            }
        } else {
            for (int i = currentFloor; i > targetFloor; i--) {
                this.currentFloor = i - 1;
                this.reportingEntity.reportFloor(ID, currentFloor);
            }
        }
        this.state=ElevatorConstants.STATE_STOPPED;
        this.doorState=ElevatorConstants.DOOR_STATE_OPEN;//let them out or in.
        checkLockout();
    }

    private void checkLockout() {
        if (this.tripCount>=100){
            this.doorState=ElevatorConstants.DOOR_STATE_CLOSED;
            this.state=ElevatorConstants.STATE_LOCKEDOUT;
        }
    }

    private int floorDiff(int currentFloor, int targetFloor) {
        return Math.abs(currentFloor - targetFloor);
    }

    private void closeDoor() {
        //In all states you should be able to close the door.
        this.doorState = ElevatorConstants.DOOR_STATE_CLOSED;
    }

    private void openDoor() {
        //TODO:Check state to open door /safety
        this.doorState = ElevatorConstants.DOOR_STATE_OPEN;
    }

    private void setDirection(int currentFloor, int requestedFloor) {
        direction = ElevatorConstants.DIRECTION_DOWN;
        if (currentFloor >= requestedFloor) {
            this.direction = ElevatorConstants.DIRECTION_UP;
        }
    }
}

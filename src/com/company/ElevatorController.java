package com.company;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by camerroe on 3/24/15.
 */
public class ElevatorController implements ReportingInterface {

    //Maybe just an array?
    ArrayList<Elevator> elevatorList;

    public ElevatorController(int numberOfElevators) {
        elevatorList = new ArrayList<Elevator>(numberOfElevators);
    }

    /**
     * Received a request from a floor for an elevator. This method simulated the on floor call of a person requesting
     * and elevator
     *
     * @param fromFloor floor from which the request was made.
     */
    public void Request(int fromFloor) {
        //TODO: algorithm to optimize for closest elevator could go here
        //TODO: What if All elevators are busy?
        Iterator<Elevator> iterator = elevatorList.iterator();
        Elevator freeElevator = null;
        while (iterator.hasNext()) {
            freeElevator = iterator.next();
            if (freeElevator.isMoving() || freeElevator.isLockedout()) {
                freeElevator = null;
            } else {
                break; //TODO:must be better way to do this
            }
        }
        if (freeElevator == null) {
            System.out.println("WARN:Elevators all busy"); //queue request here
        } else {
            freeElevator.requestTOFloor(fromFloor);
        }
    }

    @Override
    public void reportFloor(int elevator, int floor) {
        System.out.println("Elevator:" + elevator + " : " + floor);
    }

    @Override
    public void reportOpen(int elevator, int floor) {
        System.out.println("Elevator " + elevator + " opened door on floor " + floor);
    }

    @Override
    public void reportClose(int elevator, int floor) {
        System.out.println("Elevator " + elevator + " closed door on floor " + floor);
    }
}

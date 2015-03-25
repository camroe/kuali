package com.company;

import java.util.ArrayList;

/**
 * Created by camerroe on 3/24/15.
 */
public class ElevatorController implements ReportingInterface {

    //Maybe just an array?
    ArrayList<Elevator> elevatorList;

    public ElevatorController(int numberOfElevators) {
        elevatorList = new ArrayList<Elevator>(numberOfElevators);
    }

    /** Received a request from a floor for an elevator
     *
     * @param fromFloor floor from which the request was made.
     */
    public void Request(int fromFloor) {

    }

    @Override
    public void reportFloor(int elevator, int floor) {
        System.out.println("Elevator:" + elevator + " : " + floor);
    }
}

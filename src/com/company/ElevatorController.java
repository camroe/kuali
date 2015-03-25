package com.company;

import java.util.ArrayList;

/**
 * Created by camerroe on 3/24/15.
 */
public class ElevatorController {

    //Maybe just an array?
    ArrayList<Elevator> elevatorList;

    public ElevatorController(int numberOfElevators) {
        elevatorList = new ArrayList<Elevator>(numberOfElevators);
    }

    /** Recieved a request from a floor for an elevator
     *
     * @param fromFloor floor from which the request was made.
     */
    public void Request(int fromFloor) {

    }
}

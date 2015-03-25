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
        for (int i = 0; i < numberOfElevators; i++) {
            elevatorList.add(new Elevator(0, 10, this, i)); //floors fixed for now.
        }
    }

    /**
     * Received a request from a floor for an elevator. This method simulated the on floor call of a person requesting
     * and elevator
     *
     * @param fromFloor floor from which the request was made.
     */
    public void Request(int fromFloor) {
        //TODO: algorithm to optimize for closest elevator could go here
        Elevator selectedElevator = closestElevator(fromFloor);
        if (selectedElevator == null) {
            System.out.println("WARN:Elevators all busy"); //queue request here
        } else {
            selectedElevator.requestTOFloor(fromFloor);
        }
    }

    private Elevator closestElevator(int requestedFloor) {
        /* Search Elevator List, selecting the elevator that is:
           1. Elevator on the same floor
           2. Moving Elevator that will pass by
           3. Closest Stopped (Unoccupied) elevator
        */

        //But in the meantime!
        //TODO: What if All elevators are busy/lockedout?
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
        return freeElevator;
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

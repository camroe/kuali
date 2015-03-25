package com.company;

import sun.jvm.hotspot.debugger.posix.elf.ELFException;

/**
 * Created by camerroe on 3/24/15.
 */
public class Elevator {
    private String direction;
    private String state = ElevatorConstants.STATE_LOCKEDOUT;
    private int tripCount=0;
    private int floorCount=0;
}

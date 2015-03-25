package com.company;

/**
 * Created by camerroe on 3/24/15.
 */
public interface ReportingInterface {

    public void reportFloor(int elevator, int floor);

    public void reportOpen(int elevator, int floor);

    public void reportClose(int elevator, int floor);
}

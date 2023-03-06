package Rooms;

import Cars.Car;
import MyExceptions.TooManyThingsException;
import Things.Thing;

import java.io.Serializable;

public class ParkingSpace extends ConsumerWarehouse implements Serializable {
    static int id=1000;//id
    private int parkingSpaceId;
    Car car;
    public ParkingSpace(int size, Servis servis,  int warehouseFees) {
        super(size, servis, warehouseFees);
        id++;

        this.idWarehouse = id;

    }

    public ParkingSpace(int lenght, int width, int height, Servis servis,  int warehouseFees) {
        super(lenght, width, height ,servis, warehouseFees);
        id++;

        this.idWarehouse = id;


        }
    @Override
    public String toString() {
        return "Parking id " + getIdWarehouse();
    }

    }


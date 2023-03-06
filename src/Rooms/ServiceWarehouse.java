package Rooms;

import java.io.Serializable;

public class ServiceWarehouse extends Warehouse implements Serializable {
    static int id=100;//id

    private int parkingSpaceId;

    public ServiceWarehouse(int size, Servis servis) {
        super(size);
        this.servis = servis;

        id++;
        this.idWarehouse = id;
    }

    public ServiceWarehouse(int lenght, int width, int height, Servis servis, int warehouseFees) {
        super(lenght, width, height);
        this.servis = servis;
        this.warehouseFees =warehouseFees;
        id++;
        this.idWarehouse = id;

    }
    public void addServis(Servis servis) {
        this.servis = servis;
        servis.addServiceWarehouse(this);


    }
}

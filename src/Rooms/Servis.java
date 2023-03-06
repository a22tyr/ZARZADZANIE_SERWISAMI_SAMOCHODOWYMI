package Rooms;

import Cars.Car;

import java.io.*;
import java.util.ArrayList;

public class Servis implements Serializable {
    static int id = 0;
    private int sevisId;
   public static ArrayList<Servis> allServis = new ArrayList<>();
    private ArrayList<CarSServiceSpot> allCarSServiceSpot = new ArrayList<>();
    private ArrayList< ServiceWarehouse> allServicelWarehouse = new ArrayList<>();
    private ArrayList<ConsumerWarehouse> allConsumerWarehouse = new ArrayList<>();
    private ArrayList<ConsumerWarehouse> allParking = new ArrayList<>();

    public Servis() {
       id++;
       sevisId = id;
       allServis.add(this);
    }

    public  ArrayList<ServiceWarehouse>  getallServicelWarehouse() {
        return this.allServicelWarehouse;
    }
    public  ArrayList<ConsumerWarehouse>  getallConsumerWarehouse() {
        return this.allConsumerWarehouse;
    }

    public void addServiceWarehouse (ServiceWarehouse warehouse ) {
        if (!allServicelWarehouse.contains(warehouse)) {
            allServicelWarehouse.add(warehouse);
            warehouse.addServis(this);
        }
    }
    public void addConsumerWarehouse (ConsumerWarehouse warehouse ) {
        if (!allConsumerWarehouse.contains(warehouse)) {
            allConsumerWarehouse.add(warehouse);
            warehouse.addServis(this);
        }
    }
    public void addCarService (CarSServiceSpot carSServiceSpot ) {
        if (!allCarSServiceSpot.contains(carSServiceSpot)) {
            allCarSServiceSpot.add(carSServiceSpot);
            carSServiceSpot.addServis(this);
        }
    }


    public static void removeFromAllServisExist(Servis servis) {
        if (allServis.contains(servis)) {
            allServis.remove(servis);
        } else {
            System.out.println("Ten servis  nieistnieje");
        }
    }
    public static void saveServis() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("services.txt"));
        for (Servis s : allServis){
            objectOutputStreamPerson.writeObject(s);
        }
    }
    public static void LoadServis() throws Exception{
        ObjectInputStream objectInputStreamPerson = new ObjectInputStream(new FileInputStream("services.txt"));
        while(objectInputStreamPerson.available()>0){
            allServis.add( (Servis) objectInputStreamPerson.readObject() );
        }
    }
    public static void addToAllServisExist( Servis servis) {
        if (!allServis.contains(servis)) {
            allServis.add(servis);
        } else {
            System.out.println("Ten servis już istnieje");
        }
    }

    @Override
    public String toString() {
        return "Servis id "+ this.sevisId + " ";
    }
}

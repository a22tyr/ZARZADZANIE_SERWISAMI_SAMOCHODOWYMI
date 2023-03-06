package Rooms;


import MyExceptions.TooManyThingsException;
import Person.Person;
import Things.Thing;
import Threads.DateThread;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Warehouse implements Serializable {
    private int size;
    protected int idWarehouse;
    private int remainingPlace;
    protected Servis servis ;
    protected int warehouseFees;
    private ArrayList<Thing> allThings = new ArrayList<>(); // lista rzeczy włożonych do pomieszczenia

    public static ArrayList<Warehouse> allWarehouse = new ArrayList<>();

        public boolean isInWarhouse(Thing thing){
            if(allThings.contains(thing)){
                return true;
            }else return false;
        }

    public Warehouse(int size) {
        this.size = size;
        this.remainingPlace = size;

    }
    public Warehouse(int lenght, int width, int height) {
        this.size = lenght * width * height;
        this.remainingPlace = size;


    }



    public int getWarehouseFees() {
        return warehouseFees;
    }

    public void setWarehouseFees(int warehouseFees) {
        this.warehouseFees = warehouseFees;
    }





    public static void removeFromAllWarehouse(Warehouse warehouse) {
        if (allWarehouse.contains(warehouse)) {
            allWarehouse.remove(warehouse);
        } else {
            System.out.println("Ten magazyn  nieistnieje");
        }
    }
    public static void saveWarehouse() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("services.txt"));
        for (Warehouse w : allWarehouse){
            objectOutputStreamPerson.writeObject(w);
        }
    }
    public static void LoadWarehouse() throws Exception{
        ObjectInputStream objectInputStreamPerson = new ObjectInputStream(new FileInputStream("services.txt"));
        while(objectInputStreamPerson.available()>0){
            allWarehouse.add( (Warehouse) objectInputStreamPerson.readObject() );
        }
    }
    public static void addToAllWarehouseExist( Warehouse warehouse) {
        if (!allWarehouse.contains(warehouse)) {
            allWarehouse.add(warehouse);
        } else {
            System.out.println("Ten magazyn już istnieje");
        }
    }

    @Override
    public String toString() {
        return "IdSerwisu "+ servis + getIdWarehouse();
    }

    public Servis getServis() {
        return servis;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }



    public void addThing(Thing thing) throws TooManyThingsException {
        if(this.remainingPlace > thing.getSize()) {
            allThings.add(thing);
            this.removePlace(thing.getSize());
        }else throw new TooManyThingsException();
    }
    public void removeThing(Thing thing){
        this.allThings.remove(thing);

        }



    public int getRemainingPlace() {
        return remainingPlace;
    }

    public void removePlace(int removePlace) {
        this.remainingPlace -= removePlace;
    }
    public void addPlace(int addPlace){
        this.remainingPlace += addPlace;
    }

    public ArrayList<Thing> getAllThings() {
        return allThings;
    }
}
//////////brakuje przedmiotów
//////////brakuje osób
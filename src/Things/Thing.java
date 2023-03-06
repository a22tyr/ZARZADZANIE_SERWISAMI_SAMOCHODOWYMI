package Things;

import Cars.Car;
import Rooms.Warehouse;

import java.io.*;
import java.util.ArrayList;

public class Thing implements Serializable {
    private String Name;
    private int size;
    static int id=0;
    private int ThingId;
    public static ArrayList<Thing> allThings = new ArrayList<>();

    public Thing(String name, int size) {
        Name = name;
        this.size = size;
        id++;
        this.ThingId = id;
        allThings.add(this);
    }
    public Thing(String name,int lenght, int width, int height) {
        Name = name;
        this.size = lenght * width * height;
        id++;
        this.ThingId = id;
        allThings.add(this);
    }

    public String getName() {
        return Name;
    }

    public int getSize() {
        return size;
    }

    public static void removeFromAllCarExist(Thing thing) {
        if (allThings.contains(thing)) {
            allThings.remove(thing);
        } else {
            System.out.println("Ten przedmiot  nieistnieje");
        }
    }
    public static void saveThing() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("Thing.txt"));
        for (Thing t : allThings){
            objectOutputStreamPerson.writeObject(t);
        }
    }
    public static void LoadThing() throws Exception{
        ObjectInputStream objectInputStreamPerson = new ObjectInputStream(new FileInputStream("Thing.txt"));
        while(objectInputStreamPerson.available()>0){
            allThings.add( (Thing) objectInputStreamPerson.readObject() );
        }
    }
    public static void addToAllCar( Thing thing) {
        if (!allThings.contains(thing)) {
            allThings.add(thing);
        } else {
            System.out.println("Ten przedmiot już istnieje");
        }
    }

    @Override
    public String toString() {
        return getName() + " id " + this.getThingId();
    }

    public int getThingId() {
        return ThingId;
    }
}

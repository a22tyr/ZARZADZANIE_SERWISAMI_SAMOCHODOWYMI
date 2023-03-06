package Cars;

import Person.Person;
import Things.Thing;

import java.io.*;
import java.util.ArrayList;

public abstract class Car extends Thing implements Serializable {
    private double engineCapacity;
    static int id =100;
    private int carId;
    private String engineType;
    public static ArrayList<Car> allCars  = new ArrayList<>();


    public Car(String name, int size) {
        super(name, size);
        id++;
        carId = id;
    }

    public Car(String name, int lenght, int width, int height) {
        super(name, lenght, width, height);
        id++;
        carId = id;
    }

    //Getery setery
    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }



    public static void removeFromAllCarExist(Car car) {
        if (allCars.contains(car)) {
            allCars.remove(car);
        } else {
            System.out.println("en samochod  nieistnieje");
        }
    }
    public static void saveCar() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("Persons.txt"));
        for (Car c : allCars){
            objectOutputStreamPerson.writeObject(c);
        }
    }
    public static void LoadCar() throws Exception{
        ObjectInputStream objectInputStreamPerson = new ObjectInputStream(new FileInputStream("Persons.txt"));
        while(objectInputStreamPerson.available()>0){
            allCars.add( (Car)objectInputStreamPerson.readObject() );
        }
    }
    public static void addToAllCar( Car car) {
        if (!allCars.contains(car)) {
            allCars.add(car);
        } else {
            System.out.println("Ten samochód już istnieje");
        }
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public String toString() {
        return "Pojzad o nazwie " + this.getName() + " " + this.getCarId();
    }
}

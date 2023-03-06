package Rooms;

import Cars.Car;
import MyExceptions.TooManyThingsException;
import Person.Person;
import Threads.DateThread;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class CarSServiceSpot implements Serializable {
   private int fees = new Random().nextInt(320);
   private int size;
   private static int id =0;
   private int IdCarService;
    private Servis servis;
    private Car car = null;
    private LocalDate dateOfPuting;
    private LocalDate datteOfEndingWork;
    private ParkingSpace parkingSpace;
    private Person person = null;
   private static ArrayList<CarSServiceSpot> allCarServisSpot = new ArrayList<>();

    public CarSServiceSpot(int size, Servis servis) {
        this.size = size;
        addServis(servis);
        parkingSpace = new ParkingSpace(300,servis,0);
        allCarServisSpot.add(this);
        id++;
        this.IdCarService = id;

    }


    public CarSServiceSpot(int lenght, int width, int height, Servis servis) {
        this.size = lenght * width * height;
        addServis(servis);
        parkingSpace = new ParkingSpace(300,servis,0);
        allCarServisSpot.add(this);
        id++;
        this.IdCarService = id;
    }
    public void addToParking(Car car) throws TooManyThingsException {
        parkingSpace.addThing(car);
    }
    public void addServis(Servis servis) {
        this.servis = servis;
        servis.addCarService(this);
    }
        public void addCarToServisSpot(Car car) throws TooManyThingsException {
            if(this.car == null){
                this.car = car;
                this.dateOfPuting = DateThread.getLocalDate();
                this.datteOfEndingWork  = dateOfPuting.plusDays(new Random().nextInt(5));

            }else{
                if(datteOfEndingWork.isBefore(DateThread.getLocalDate())){
                    this.car = car;
                    this.dateOfPuting = DateThread.getLocalDate();
                    this.datteOfEndingWork  = dateOfPuting.plusDays(new Random().nextInt(5));

                }else{
                    this.addToParking(car);
                }
            }


        }


    public static ArrayList<CarSServiceSpot> getAllCarServisSpot() {
        return allCarServisSpot;
    }

    public int getIdCarService() {
        return IdCarService;
    }

    @Override
    public String toString() {
        return "Car servide o id " + this.getIdCarService();
    }

    public static void saveCarServices() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("services.txt"));
        for (CarSServiceSpot css : allCarServisSpot){
            objectOutputStreamPerson.writeObject(css);
        }
    }
}

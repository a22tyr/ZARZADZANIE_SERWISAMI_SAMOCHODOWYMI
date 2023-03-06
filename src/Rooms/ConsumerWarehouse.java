package Rooms;

import MyExceptions.ProblematicTenantException;
import Person.Person;
import Things.Thing;
import Threads.DateThread;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
//Popraw wszędzie Id
public class ConsumerWarehouse extends Warehouse implements Serializable {

    static int id=10;//id
    private int  WarehouseId;
    LocalDate rentedTime;
    LocalDate rentTimeEnd;

    public static ArrayList<ConsumerWarehouse> allwarehouseToRenting = new ArrayList<>();
    private ArrayList<Person> allPersons = new ArrayList<>(); /// Lista osób która może włożć przedmiot do magazynu

    public static ArrayList<ConsumerWarehouse> RentingWarehouse = new ArrayList<>();//zmien
    /////////////
    public ConsumerWarehouse(int size, Servis servis, int warehouseFees ) {
        super(size);
        id++;
        this.idWarehouse = id;
        this.servis = servis;
        this.warehouseFees =warehouseFees;
        allwarehouseToRenting.add(this);



    }
    public ConsumerWarehouse(int lenght, int width, int height, Servis servis, int warehouseFees) {
        super(lenght, width, height);
        this.servis = servis;
        this.warehouseFees =warehouseFees;
        id++;
        this.idWarehouse = id;
        allwarehouseToRenting.add(this);


    }

    public ArrayList<Person> getAllPersons(){
        return allPersons;
    }
    //Getery i setery
    public LocalDate getRentTimeEnd() {
        return rentTimeEnd;
    }

    public void setRentTimeEnd(LocalDate rentTimeEnd) {
        this.rentTimeEnd = rentTimeEnd;
    }
    public LocalDate getRentedTime() {
        return rentedTime;
    }

    public void setRentedTime(LocalDate rentedTime) {
        this.rentedTime = rentedTime;
    }


    public Person getPersonRenting(){// zwraca osobe która wynajmuje magazyn
        return allPersons.get(0);
    }

    public static void addRentingWarehouse(ConsumerWarehouse consumerWarehouse){
        RentingWarehouse.add(consumerWarehouse);

    }
    public static void removeRentingWarehouse(ConsumerWarehouse consumerWarehouse){
        RentingWarehouse.remove(consumerWarehouse);
        for(Person p : consumerWarehouse.allPersons){
            p.removeWarehouse(consumerWarehouse);
        }
        consumerWarehouse.allPersons.clear();


    }


    //Funkcjonalności
    public void addPerson(Person person) throws ProblematicTenantException { // dodaje oosbe do magazynu
        if (!allPersons.contains(person)) {
            allPersons.add(person);
            person.addWarehouse(this);
        }
    }
    public void removePerson(Person person){
        //sprawdz czy to nie piersze
        if (allPersons.contains(person)) {
                allPersons.remove(person);
                person.removeWarehouse(this);
            }
        }
    public static void remoweAllwarehouseToRenting(ConsumerWarehouse consumerWarehouse){
        allwarehouseToRenting.remove(consumerWarehouse);
    }


    public void addServis(Servis servis) {
        this.servis = servis;
        servis.addConsumerWarehouse(this);


    }
   /* public static void checkingWarchouseIfRenting(){
        ConsumerWarehouse tempueryTonsumerwarechouse = null;
            for (ConsumerWarehouse consumerWarehouse : RentingWarehouse) {
                if ((Duration.between(DateThread.getLocalDate().atStartOfDay(), consumerWarehouse.getRentTimeEnd().atStartOfDay()).toDays()) > -30) {
                    tempueryTonsumerwarechouse=consumerWarehouse;
                }if(tempueryTonsumerwarechouse != null) {
                    RentingWarehouse.remove(tempueryTonsumerwarechouse);
                    allwarehouseToRenting.add(tempueryTonsumerwarechouse);
                    Person.removeAllPersonsToUseWarehouse(tempueryTonsumerwarechouse);
                    tempueryTonsumerwarechouse.getAllThings().clear();
                }
        }//spr czy działa
    }*/
    @Override
    public String toString() {
        return "Magazyn id " + getIdWarehouse();
    }



}

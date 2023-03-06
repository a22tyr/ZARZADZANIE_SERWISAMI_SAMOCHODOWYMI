package Person;
import Cars.Car;
import MyExceptions.NeverRentException;
import MyExceptions.ProblematicTenantException;
import MyExceptions.TooManyThingsException;
import Rooms.ConsumerWarehouse;
import Rooms.Servis;
import Rooms.Warehouse;
import Things.Thing;
import Threads.DateThread;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class Person implements Serializable {
    static int id = 0;
    private int idPerson;
    private String name;
    private String lastName;
    private String pesel;
    private String adres;
    private LocalDate birthDate;
    private LocalDate firstRent = null;


    private int fees = 0;

    @Override
    public String toString() {
        return " Osoab to "+ this.name + " "+ this.lastName + " " + this.pesel +" o id " + this.idPerson;
    }
    private ArrayList<Car> PrsonsCar = new ArrayList<>();

   private ArrayList<TenantAlert> tenantAlerts = new ArrayList<>();

    private ArrayList<ConsumerWarehouse> rentingWarehouses = new ArrayList<>();

   private ArrayList<ConsumerWarehouse> allconsumerWarehouse = new ArrayList<>();

    public static  ArrayList<Person> allPersonsEgsist = new ArrayList<>();

    public Person(String name, String lastName, String pesel) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        addToAllPersonExist(this);
        id++;
        idPerson = id;
    }

    //Getery i setery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getBirthDate() {
        return birthDate.getMonth() + " " + birthDate.getYear();
    }

    public void setBirthDate(int day, int month, int year) {
        birthDate = LocalDate.of(year,month,day);
    }

    public ArrayList<TenantAlert> getTenantAlerts() {
        return tenantAlerts;
    }

    public void addCar(Car car){
        PrsonsCar.add(car);
    }

   /* public void addTenantAlerts() {
        this.tenantAlerts.add(new TenantAlert());
    }*/
       /* public void removeTelnetAlert(){
            this.tenantAlerts.remove(tenantAlerts.size()-1);
        }
        public int TelnetAlertSize(){
        return this.tenantAlerts.size();
        }*/
      public ArrayList<ConsumerWarehouse> getAllTenantWarehouse(){
          ArrayList<ConsumerWarehouse> arrayList=new ArrayList<>();
          for(TenantAlert tenantAlert : this.tenantAlerts){
              arrayList.add(tenantAlert.getConsumerWarehouse());
          }
          return arrayList;

      }
      public int getAllTenantCosts(){
          int cost=0;
          for(TenantAlert tenantAlert : this.tenantAlerts){
              cost += tenantAlert.getCost();
          }return cost;
      }

    public int getFees() {
        return fees;
    }

    public int getId() {
        return idPerson;
    }

    public LocalDate getFirstRent() throws NeverRentException {
        if (firstRent == null) {
            throw new NeverRentException();
        }return firstRent;
    }

    public void setFirstRent(LocalDate firstRent) {
        this.firstRent = firstRent;
    }

    //Funkcjonalności
    public void addWarehouse(ConsumerWarehouse consumerWarehouse) throws ProblematicTenantException {//dodaje osobe do magazynu
        if (consumerWarehouse.getAllPersons().isEmpty()) {
            if(this.tenantAlerts.size() < 3) {
                if (this.getFees() + consumerWarehouse.getWarehouseFees() <= 1250) {// sprawdza czy komorne nie jest za wysokie
                    allconsumerWarehouse.add(consumerWarehouse);
                    consumerWarehouse.addPerson(this);
                    this.fees += consumerWarehouse.getWarehouseFees();
                    consumerWarehouse.setRentedTime(DateThread.getLocalDate());
                    consumerWarehouse.setRentTimeEnd(consumerWarehouse.getRentedTime().plusDays(30));
                    ConsumerWarehouse.addRentingWarehouse(consumerWarehouse);
                    this.rentingWarehouses.add(consumerWarehouse);
                    ConsumerWarehouse.remoweAllwarehouseToRenting(consumerWarehouse);
                    if (this.rentingWarehouses.size() == 1) {
                        this.firstRent = consumerWarehouse.getRentedTime();
                    }

                }
            }else {
                throw new ProblematicTenantException("Osoba " + this + "posiadała już najem po-mieszczeń "+ this.rentingWarehouses + " -" + this.getAllTenantWarehouse() + " wysokość_zadłużenia " + this.getAllTenantCosts());

            }

        } else {
            if (!allconsumerWarehouse.contains(consumerWarehouse)) { //dodaje oeobe nie płacącą czynszu
                allconsumerWarehouse.add(consumerWarehouse);
                consumerWarehouse.addPerson(this);


            }
        }
    }

    public void removeWarehouse(ConsumerWarehouse consumerWarehouse) {
        if (allconsumerWarehouse.contains(consumerWarehouse)) {
            allconsumerWarehouse.remove(consumerWarehouse);
            consumerWarehouse.removePerson(this);
        }
    }

    public void putThingToWarehouse(ConsumerWarehouse warehouse, Thing thing) throws TooManyThingsException {
        if (allconsumerWarehouse.contains(warehouse)) {

            if (warehouse.getRemainingPlace() >= thing.getSize()) {
                warehouse.addThing(thing);
                warehouse.removePlace(thing.getSize());
            } else throw new TooManyThingsException();
        }
    }

    public void removeThingFromWarehouse(ConsumerWarehouse warehouse, Thing thing) {//usuwa rzecz pod warunkiem ze osoba może to zrobić
        if (allconsumerWarehouse.contains(warehouse)) {
            if (warehouse.isInWarhouse(thing)) {
                warehouse.removeThing(thing);
                warehouse.addPlace(thing.getSize());
            }
        }
        System.out.println("Nie ma tego przedmiotu");
    }

    public void addPersonToUseWarehouse(ConsumerWarehouse warehouse, Person person) throws ProblematicTenantException { //dodaje przywileje osobie do magazynu ale tylko oosba wynajmująca może to zrobić
        if (this.equals(warehouse.getPersonRenting())) {
            person.addWarehouse(warehouse);
            warehouse.addPerson(person);
        }
    }

    public  void removeAllPersonsToUseWarehouse(ConsumerWarehouse warehouse, Person person) {
      if(this.equals(warehouse.getPersonRenting())) {
          person.removeWarehouse(warehouse);
          warehouse.removePerson(person);
      }
      }
        public static void remoweRenting(ConsumerWarehouse consumerWarehouse, Person person){

              consumerWarehouse.getAllPersons().remove(person);
              person.getRentingWarehouses().remove(consumerWarehouse);



        }


    public void payForRent(ConsumerWarehouse consumerWarehouse){
          TenantAlert ta = null;
        if(this.rentingWarehouses.contains(consumerWarehouse)){
            consumerWarehouse.setRentTimeEnd(consumerWarehouse.getRentedTime().plusDays(30));
            for(TenantAlert tenantAlert : this.tenantAlerts){
                if(tenantAlert.getConsumerWarehouse().equals(consumerWarehouse)){
                    ta = tenantAlert;
                }
            } this.tenantAlerts.remove(ta);
        }


    }
//////// zapis danych
   public static void addToAllPersonExist(Person person) {
        if (!allPersonsEgsist.contains(person)) {
            allPersonsEgsist.add(person);
        } else {
            System.out.println("Ta osoba już istnieje");
        }
    }

    public static void removeFromAllPersonExist(Person person) {
        if (allPersonsEgsist.contains(person)) {
            allPersonsEgsist.remove(person);
        } else {
            System.out.println("Ta osoba już nieistnieje");
        }
    }
    public static void savePersons() throws Exception{
        ObjectOutputStream objectOutputStreamPerson = new ObjectOutputStream(new FileOutputStream("Persons.txt"));
        for (Person p : allPersonsEgsist){
            objectOutputStreamPerson.writeObject(p);
        }
    }
    public static void LoadPersons() throws Exception{
       ObjectInputStream objectInputStreamPerson = new ObjectInputStream(new FileInputStream("Persons.txt"));
       while(objectInputStreamPerson.available()>0){
           allPersonsEgsist.add((Person)objectInputStreamPerson.readObject());
       }
    }
    public void ifGiveTenant(){ //nadaje TenantAlert zakonczonym najmom;
        for(ConsumerWarehouse warehouse : rentingWarehouses){
          /*  if(warehouse.getRentTimeEnd().isBefore(DateThread.getLocalDate())){*/
                if(Duration.between(DateThread.getLocalDate().atStartOfDay(), warehouse.getRentTimeEnd().atStartOfDay()).toDays() == 1){
                    this.tenantAlerts.add(new TenantAlert(warehouse,this));
                }
            //}
        }
    }
   /* public static void deletingWarehouse(ConsumerWarehouse consumerWarehouse){
          for(Person p : consumerWarehouse.getAllPersons()){
              p.removePersonToUseWarehouse(consumerWarehouse,p);

          }

          }*/



    public ArrayList<ConsumerWarehouse> getRentingWarehouses() {
        return rentingWarehouses;
    }

    public ArrayList<Car> getPrsonsCar() {
        return PrsonsCar;
    }

    public ArrayList<ConsumerWarehouse> getAllconsumerWarehouse() {
        return allconsumerWarehouse;
    }
}


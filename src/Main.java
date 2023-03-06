import Cars.Car;
import Cars.CityCar;
import Cars.OffRoadCar;
import MyExceptions.ProblematicTenantException;
import MyExceptions.TooManyThingsException;
import Person.Person;
import Rooms.*;
import Things.Thing;
import Threads.DateThread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) {

                System.out.println("    --------------------------------------------------   ");
                System.out.println("|          ZARZĄDZANIE SERWISAMI SAMOCHODOWYMI          |");
                System.out.println("    --------------------------------------------------   ");


                int input = 0;
                boolean EXIT = false;
                DateThread dateThread = new DateThread();
                dateThread.start();


                Servis fisrtServis = new Servis();
                ConsumerWarehouse consumerWarehouse = new ConsumerWarehouse(150, fisrtServis, 45);
                ConsumerWarehouse consumerWarehouse1 = new ConsumerWarehouse(865, fisrtServis, 500);
                ConsumerWarehouse consumerWarehouse2 = new ConsumerWarehouse(157, fisrtServis, 50);
                ConsumerWarehouse consumerWarehouse3 = new ConsumerWarehouse(456, fisrtServis, 45);
                ServiceWarehouse serviceWarehouse = new ServiceWarehouse(650, fisrtServis);
                ParkingSpace parkingSpace1 = new ParkingSpace(64, fisrtServis, 55);
                ParkingSpace parkingSpace2 = new ParkingSpace(634, fisrtServis, 55);
                ParkingSpace parkingSpace3 = new ParkingSpace(1204, fisrtServis, 55);
                ParkingSpace parkingSpace4 = new ParkingSpace(1252, fisrtServis, 642);
                Person person = new Person("Jerzy", "Malczewski", "851252");
                Person person1 = new Person("Henry", "Kolo", "1654854");
                Person person2 = new Person("Mariola", "Blawdzin", "26598");
                Person person3 = new Person("Jerzy", "Helczyk", "16562");
                Person person4 = new Person("Anrzej", "Mały", "56216968");
                Person person5 = new Person("Dark", "Dubielecki", "2516568");
                CarSServiceSpot carSServiceSpot = new CarSServiceSpot(600,fisrtServis);
                CarSServiceSpot carSServiceSpot1 = new CarSServiceSpot(700,fisrtServis);
                IndependentCarServiceSpot independentCarServiceSpot = new IndependentCarServiceSpot(500,fisrtServis);

                try {
                        person.addWarehouse(consumerWarehouse);
                        person.addWarehouse(consumerWarehouse1);
                        person1.addWarehouse(consumerWarehouse1);
                        person1.addWarehouse(consumerWarehouse2);
                        person2.addWarehouse(consumerWarehouse1);
                        person2.addWarehouse(consumerWarehouse3);
                        person.addWarehouse(parkingSpace1);
                        person3.addWarehouse(parkingSpace1);
                        person4.addWarehouse(consumerWarehouse);
                        person5.addWarehouse(consumerWarehouse1);
                        person5.addWarehouse(consumerWarehouse2);
                        person5.addWarehouse(parkingSpace3);
                        person5.addWarehouse(parkingSpace2);
                        Thing thing = new Thing("łopata", 15);
                        Thing thing1 = new Thing("Pudło", 50);
                        CityCar cityCar = new CityCar("Audi", 150);
                        OffRoadCar offRoadCar = new OffRoadCar("Jeep", 200);
                        consumerWarehouse.addThing(thing);
                        parkingSpace3.addThing(cityCar);
                        person.addCar(cityCar);
                } catch (TooManyThingsException e) {

                } catch (ProblematicTenantException e) {
                        e.printStackTrace();
                }



                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                Person personTemporary = null;
                boolean EXITTemporary = false;
                while (!EXIT) {
                        EXITTemporary=false;
                        System.out.println("---------------------------------------------------");
                        System.out.println("Wybierz 0: by wyjść z aplikacji");
                        System.out.println("Wybierz 1: by wyświetlić wszystkie serwisy");
                        System.out.println("Wybierz 2: by zarządzać osobą");
                        System.out.println("Wybierz 3: by wyświetlić wszystkie możliwe do wynajecia magazyny");
                        System.out.println("Wybierz 4: by wyświetlić dzisiejszą date");
                        System.out.println("Wybierz 5: by zapisać");
                        System.out.println("---------------------------------------------------");

                        try {
                                input = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException ioException) {
                                ioException.printStackTrace();
                        }
                        switch (input) {
                                case 0: {//wyjscie  zprogramu
                                        dateThread.cancel();
                                        EXIT = true;

                                }
                                break;
                                case 1: { //Wypisanie serwisów
                                        System.out.println(Servis.allServis);

                                }
                                break;
                                case 2: {// Wszystko związanie z person



                                        while (!EXITTemporary) {
                                                System.out.println("Wybierz 0 by wyjść z menu osoby");
                                                System.out.println("Wybierz 1 by wybrać którą osobą jesteś");
                                                System.out.println("Wybierz 2 by wyświetlić dane osobowe");
                                                System.out.println("Wybierz 3 by wynająć magazyn, najpierw wybierz którą osobą jesteś");
                                                System.out.println("Wybierz 4 by obejrzeć magazyny, najpierw wybierz którą osobą jesteś");
                                                System.out.println("Wybierz 5 by wsadziś coś do magazynu, najpierw wybierz którą osobą jesteś");
                                                System.out.println("Wybierz 6 by wyjąć coś z magazynu, najpierw wybierz którą osobą jesteś");
                                                System.out.println("Wybierz 7 rozpocząc zgłoszenie serwisowe, najpierw wybierz którą osobą jesteś");
                                                System.out.println("Wybierz 8 by zapłacić za najem");
                                                System.out.println("Wybierz 9 dać uprawnienia do magazynu");
                                                System.out.println("Wybierz 10 zabrać uprawnienia do magazynu");
                                                try {
                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                } catch (IOException ioException) {
                                                        ioException.printStackTrace();
                                                }


                                                switch (input) {
                                                        case 0: {
                                                                EXITTemporary = true;
                                                        }
                                                        break;

                                                        case 1: {//Ustawianie osoby
                                                                System.out.println("Wybierz z listy którą osobą jesteś wybierająć po jej id");
                                                                System.out.println(Person.allPersonsEgsist);
                                                                try {
                                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                                        for (Person p : Person.allPersonsEgsist) {
                                                                                if (p.getId() == input) {
                                                                                        personTemporary = p;
                                                                                        System.out.println("Usawiono");
                                                                                }
                                                                        }
                                                                        if (personTemporary == null)
                                                                                System.out.println("Nie ma takiej osoby");
                                                                } catch (IOException ioException) {
                                                                        ioException.printStackTrace();
                                                                }


                                                        }
                                                        break;
                                                        case 2: { // wyświetla dane osobowe
                                                                if(personTemporary != null) {
                                                                        System.out.println(personTemporary);
                                                                        System.out.println(personTemporary.getRentingWarehouses());
                                                                }else System.out.println("Nie wybrano osoby");
                                                        }
                                                        break;
                                                        case 3: {//wynajmuje magazyn
                                                               ConsumerWarehouse consumerWarehouseTemporary = null;
                                                                System.out.println("Wybierz id Pomieszczenia by go wynająć");
                                                                System.out.println(ConsumerWarehouse.allwarehouseToRenting);
                                                                try {
                                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                                        if (personTemporary != null) {
                                                                        for(ConsumerWarehouse cw: ConsumerWarehouse.allwarehouseToRenting) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                consumerWarehouseTemporary = cw;
                                                                                        }
                                                                                }
                                                                                personTemporary.addWarehouse(consumerWarehouseTemporary);
                                                                                System.out.println("dodano");
                                                                        }else System.out.println("Nie wybrano osoby");

                                                                } catch (IOException ioException) {
                                                                        ioException.printStackTrace();
                                                                } catch (ProblematicTenantException problematicTenantException) {
                                                                        problematicTenantException.printStackTrace();
                                                                }


                                                        }
                                                        break;
                                                        case 4: {

                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id pomieszczenia które chcesz obejrzeć");
                                                                        System.out.println(personTemporary.getRentingWarehouses());
                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getRentingWarehouses()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                System.out.println(cw.getAllThings());

                                                                                        }
                                                                                }
                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        }

                                                                } else System.out.println("Nie wybrałeś osoby");
                                                        }
                                                        break;
                                                        case 5: {

                                                                ConsumerWarehouse consumerWarehouseTemporary = null;
                                                                Thing thing = null;
                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id pomieszczenie do którego chcesz wsadzić przdemiot");
                                                                        System.out.println(personTemporary.getAllconsumerWarehouse());
                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getAllconsumerWarehouse()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                consumerWarehouseTemporary = cw;
                                                                                                System.out.println("udano wybrać");

                                                                                        }
                                                                                }
                                                                                System.out.println("Wybierz po id przedmiotu przedmiot");
                                                                                System.out.println(Thing.allThings);
                                                                                input = Integer.parseInt(bufferedReader.readLine());

                                                                                if (consumerWarehouseTemporary != null) {
                                                                                        for (Thing thing1 : Thing.allThings) {
                                                                                                if (thing1.getThingId() == input) {
                                                                                                        consumerWarehouseTemporary.addThing(thing1);
                                                                                                        System.out.println("dodano");
                                                                                                }
                                                                                        }
                                                                                }else System.out.println("Nie wybrano magazynu");


                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        } catch (TooManyThingsException e) {
                                                                                e.printStackTrace();
                                                                        }


                                                                } else {
                                                                        System.out.println("nie wybrano osoby");

                                                                }
                                                        }break;
                                                        case 6:{
                                                                ConsumerWarehouse consumerWarehouseTemporary = null;
                                                                Thing thing = null;

                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id pomieszczenie z którego chcesz wyjąc przdemiot");
                                                                        System.out.println(personTemporary.getRentingWarehouses());
                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getRentingWarehouses()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                consumerWarehouseTemporary = cw;
                                                                                                System.out.println("udano wybrać");

                                                                                        }
                                                                                }
                                                                                System.out.println("Wybierz po id przedmiotu ktory chcesz wyjąć");
                                                                                System.out.println(consumerWarehouseTemporary.getAllThings());
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for(Thing t : consumerWarehouseTemporary.getAllThings()){
                                                                                        if(t.getThingId() ==  input){
                                                                                                thing = t;
                                                                                        }
                                                                                }
                                                                                consumerWarehouseTemporary.removeThing(thing);




                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        }


                                                                }else
                                                                System.out.println("Nie wybrano osoby");

                                                        }break;
                                                        case 7:{// dodaje zgłoszenie serwisowe
                                                                Car tempueryCar = null;
                                                                CarSServiceSpot tempueryCarServiceSpot = null;
                                                                if(personTemporary!=null){
                                                                        System.out.println("Wybierz z listy serwisów naprawdzych po id, do którego serwisu chcesz wstawić auto");
                                                                        System.out.println(CarSServiceSpot.getAllCarServisSpot());
                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for(CarSServiceSpot css : CarSServiceSpot.getAllCarServisSpot()){
                                                                                        if(css.getIdCarService() == input){
                                                                                                tempueryCarServiceSpot = css;
                                                                                        }
                                                                                }if(tempueryCarServiceSpot != null) {
                                                                                        System.out.println("Dodano");
                                                                                        System.out.println("Wybierz z listy samochodów osoby które auto wstawiasz");
                                                                                        System.out.println(personTemporary.getPrsonsCar());

                                                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                                                        for (Car c : personTemporary.getPrsonsCar()) {
                                                                                                if (c.getCarId() == input) {
                                                                                                        tempueryCar = c;
                                                                                                }
                                                                                        }
                                                                                        if (tempueryCar != null) {
                                                                                                tempueryCarServiceSpot.addCarToServisSpot(tempueryCar);
                                                                                                System.out.println("Dodano zgłoszenie serwisowe");
                                                                                        } else {
                                                                                                System.out.println("Niedodoano");

                                                                                        }
                                                                                }else
                                                                                System.out.println("Nie wybrano servisu");




                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        } catch (TooManyThingsException e) {
                                                                                System.out.println("Za mało miejsca w serwisie");
                                                                        }
                                                                }else
                                                                System.out.println("Brak wybranej osoby");


                                                        }break;
                                                        case 8: {//Przedłuż najem

                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id pomieszczenia które chcesz opłacić");
                                                                        System.out.println(personTemporary.getRentingWarehouses());
                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getRentingWarehouses()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                personTemporary.payForRent(cw);
                                                                                                System.out.println("zapłacono");

                                                                                        }
                                                                                }
                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        }

                                                                } else System.out.println("Nie wybrałeś osoby");
                                                        }break;
                                                        case 9 :{ //nadaje uprawnienia do zarzadzania magazynem
                                                                ConsumerWarehouse consumerWarehouseTemporary = null;
                                                                Person temPerson = null;
                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id magazyn do którego chcesz dać uprawnienia");
                                                                        System.out.println(personTemporary.getRentingWarehouses());

                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getRentingWarehouses()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                consumerWarehouseTemporary = cw;
                                                                                                System.out.println("wybrano magazyn");
                                                                                        }
                                                                                }if(consumerWarehouseTemporary != null) {
                                                                                        System.out.println("Wybierz z listy id Osobe która ma dostać uprawnienia");
                                                                                        System.out.println(Person.allPersonsEgsist);
                                                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                                                        for (Person p : Person.allPersonsEgsist) {
                                                                                                if (p.getId() == input) {
                                                                                                        temPerson = p;
                                                                                                        System.out.println("Wybrano osobe");
                                                                                                }
                                                                                        }
                                                                                        if(temPerson != null){
                                                                                                personTemporary.addPersonToUseWarehouse(consumerWarehouseTemporary,temPerson);
                                                                                                System.out.println("dodano");
                                                                                        }else System.out.println("Nie dodano osoby");
                                                                                }else
                                                                                System.out.println("nie wybrano magazynu");
                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        } catch (ProblematicTenantException problematicTenantException) {
                                                                                problematicTenantException.printStackTrace();
                                                                        }

                                                                }else
                                                                System.out.println("Nie wybrano oosby");




                                                }break;
                                                        case 10 :{ //zabiera uprawnienia do zarzadzania magazynem
                                                                ConsumerWarehouse consumerWarehouseTemporary = null;
                                                                Person temPerson = null;
                                                                if (personTemporary != null) {
                                                                        System.out.println("Wybierz z listy id magazyn z którego chcesz zabrać  uprawnienia");
                                                                        System.out.println(personTemporary.getRentingWarehouses());
                                                                        System.out.println("Jesteś " + personTemporary);

                                                                        try {
                                                                                input = Integer.parseInt(bufferedReader.readLine());
                                                                                for (ConsumerWarehouse cw : personTemporary.getRentingWarehouses()) {
                                                                                        if (cw.getIdWarehouse() == input) {
                                                                                                consumerWarehouseTemporary = cw;
                                                                                                System.out.println("wybrano magazyn");
                                                                                        }
                                                                                }if(consumerWarehouseTemporary != null) {
                                                                                        System.out.println("Wybierz z listy id Osobe której chcesz zabra uprawnienia");
                                                                                        System.out.println(consumerWarehouseTemporary.getAllPersons());
                                                                                        input = Integer.parseInt(bufferedReader.readLine());
                                                                                        for (Person p :consumerWarehouseTemporary.getAllPersons()) {
                                                                                                if (p.getId() == input) {
                                                                                                        temPerson = p;
                                                                                                        System.out.println("Wybrano osobe");
                                                                                                }
                                                                                        }
                                                                                        if(temPerson != null){
                                                                                                personTemporary.removeAllPersonsToUseWarehouse(consumerWarehouseTemporary,temPerson);
                                                                                                System.out.println("usunięto");
                                                                                        }else System.out.println("Nie usunieto osoby");
                                                                                }else
                                                                                        System.out.println("nie wybrano magazynu");
                                                                        } catch (IOException ioException) {
                                                                                ioException.printStackTrace();
                                                                        }

                                                                }else
                                                                        System.out.println("Nie wybrano oosby");




                                                        }break;
                                                        default:
                                                                System.out.println("Brak polecenia");
                                        }
                                        }
                                }break;


                                case 3: {
                                        System.out.println(ConsumerWarehouse.allwarehouseToRenting);
                                }
                                break;
                                case 4:{// wyświetla dzisejszą date
                                        System.out.println("dzisiejsza data to " + DateThread.getLocalDate());
                                }break;
                                case 5:{///zapis do pliku

                                        try {
                                                Thing.saveThing();
                                                Warehouse.saveWarehouse();
                                                CarSServiceSpot.saveCarServices();
                                                Servis.saveServis();
                                                Person.savePersons();
                                                System.out.println("zapisano");
                                        } catch (Exception e) {
                                                System.out.println("NIe udało sie zapisąć aplikacji");
                                        }

                                } default:{
                                        System.out.println("Nie ma takiego polecenia");
                                }



                        }


                }
        }
}

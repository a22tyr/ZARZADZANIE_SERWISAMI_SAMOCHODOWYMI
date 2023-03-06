package Threads;

import Person.Person;

import java.time.LocalDate;

public class DateThread extends Thread{

   private static LocalDate localDate = LocalDate.now();




    private boolean isCancel = false;

    public static LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!this.isCancel) {
                localDate = localDate.plusDays(1);
                for(Person p : Person.allPersonsEgsist ){
                    p.ifGiveTenant();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }
    public  void cancel()
    {
        this.isCancel = true;
    }
}

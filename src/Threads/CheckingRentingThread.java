package Threads;

import Rooms.ConsumerWarehouse;
import Rooms.Servis;

public class CheckingRentingThread extends Thread{
    public static boolean isCancel = false;

    @Override
    public void run() {

        synchronized (this) {
            while (!isCancel) {
                try {
                    Thread.sleep(4000);


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

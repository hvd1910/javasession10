package session09;
import java.util.concurrent.*;
//A SharedData resource or class.
class SharedData {
    static int count = 0;
}
class AppThread extends Thread {
    Semaphore sema;
    String thrdName;

    public AppThread(Semaphore sema, String thrdName) {
        super(thrdName);
        this.sema = sema;
        this.thrdName = thrdName;
    }

    @Override
    public void run() {
        // run by thread X
        if (this.getName().equals("X")) {
            System.out.println("Starting " + thrdName);
            try {
                System.out.println(thrdName + " is waiting for a permit.");
                sema.acquire();
                System.out.println(thrdName + " gets a permit.");
                for (int i = 0; i < 5; i++) {
                    SharedData.count++;
                    System.out.println(thrdName + ":" + SharedData.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            System.out.println(thrdName + "realeases the permit.");
            sema.release();
        } else {
            System.out.println("Starting " + thrdName);
            try {
                System.out.println(thrdName + "IT is waiting for a permit.");
                sema.acquire();
                System.out.println(thrdName + " gets a permit.");
                for (int i = 0; i < 5; i++) {
                    SharedData.count--;
                    System.out.println(thrdName + ": " + SharedData.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            System.out.println(thrdName + "realeases the permit.");
            sema.release();
        }
    }
}
public class SemaphoreExample{
    public static void main(String[] args) throws InterruptedException{
        Semaphore sema = new Semaphore(1);
        AppThread mt1 = new AppThread(sema, "X");
        AppThread mt2 = new AppThread(sema, "Y");

        mt1.start();
        mt2.start();

        mt1.join();
        mt2.join();

        System.out.println("Count : "+SharedData.count);
    }
}

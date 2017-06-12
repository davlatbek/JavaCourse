package concurrency.deadlock;

/**
 * Created by davlet on 6/12/17.
 */
public class Ex2 implements Runnable {
    Object lock1;
    Object lock2;
    public Ex2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2){
            try {
                System.out.println("2 got lock2");
                Thread.sleep(10);
                synchronized (lock1){
                    System.out.println("2 got both locks");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

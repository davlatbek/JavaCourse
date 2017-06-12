package concurrency.deadlock;

/**
 * Created by davlet on 6/9/17.
 */
public class Ex1 implements Runnable {
    Object lock1;
    Object lock2;

    public Ex1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            try {
                System.out.println("1 got lock1");
                Thread.sleep(10);
                synchronized (lock2){
                    System.out.println("1 got both locks");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Object Lock1 = new Object();
        Object Lock2 = new Object();
        Ex1 ex1 = new Ex1(Lock1, Lock2);
        Ex2 ex2 = new Ex2(Lock1, Lock2);
        Thread thread1 = new Thread(ex1);
        Thread thread2 = new Thread(ex2);
        thread1.start();
        thread2.start();
    }
}

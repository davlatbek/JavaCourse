package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Singulator extends Thread {
    int value;
    Semaphore semaphore;
    String threadName;

    public Singulator(String threadName, int exp, Semaphore semaphore) {
        this.value = exp;
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
//            System.out.println(threadName + " thread");
            semaphore.save(calculate(this.value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer calculate(Integer i) {
        return i*i*i;
    }
}

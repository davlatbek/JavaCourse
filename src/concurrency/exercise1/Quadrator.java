package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Quadrator extends Thread {
    int value;
    Semaphore semaphore;
    String threadName;

    public Quadrator(String threadName, int exp, Semaphore semaphore) {
        this.value = exp;
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
//            System.out.println(threadName + " thread");
            Integer result = calculate(this.value);
            semaphore.save(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int calculate(int value) {
        return value*value*value;
    }
}

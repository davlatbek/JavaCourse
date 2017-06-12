package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Semaphore {
    private boolean signal = false;

    public synchronized void take(){
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!this.signal)
            wait();
        this.signal = false;
    }
}

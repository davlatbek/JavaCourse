package concurrency.srez1;

/**
 * Created by davlet on 6/16/17.
 */
public class Semaphore {
    volatile boolean running;

    public Semaphore(){
        running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

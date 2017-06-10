package concurrency;

import java.util.concurrent.*;

/**
 * Created by davlet on 6/10/17.
 */
public class Locker implements Runnable {
    private int number;

    public Locker(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number + " started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        System.out.println(number + " ended");
    }

    public static void main(String[] args) {
        RejectedExecutionHandler rejectedHandler = new RejectedHandler();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(15), Executors.defaultThreadFactory(), rejectedHandler);

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            Runnable runnable = new Locker(i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){

        }
    }
}

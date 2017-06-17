package concurrency.exercise1;

/**
 * Created by davlet on 6/10/17.
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        Integer[] x = {1,2,3};
        Integer[] y = {4,5,6};
        Integer[] z = {7,8,9};
        Semaphore semaphore = new Semaphore(x,y,z);

        for (int i = 0; i < x.length; i++){
            new Singulator("singulator", x[i], semaphore).start();
            new Quadrator("quadrator", y[i], semaphore).start();
            new Cubator("cubator", z[i], semaphore).start();
        }

        Thread.sleep(6000);
        System.out.println("Result of singulator: " + semaphore.resultX);
        System.out.println("Result of quadrator: " + semaphore.resultY);
        System.out.println("Result of cubator: " + semaphore.resultZ.toString());
        System.out.println("Final sum: " + semaphore.resultX + semaphore.resultY + semaphore.resultZ);
    }
}

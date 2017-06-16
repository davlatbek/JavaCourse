package concurrency.srez1;

import java.util.Map;

/**
 * Created by davlet on 6/12/17.
 */
public class Checker implements Runnable {
    private Map<Integer, Integer> integerMap;
    private Integer numberToGenerateUntilStop;
    private Semaphore semaphore;

    public Checker(Map<Integer, Integer> integerMap, Integer numberToGenerateUntilStop, Semaphore semaphore){
        this.integerMap = integerMap;
        this.numberToGenerateUntilStop = numberToGenerateUntilStop;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (semaphore.isRunning()){
            try {
                Integer uniqueNumbers = 0;
                synchronized (integerMap) {
                    uniqueNumbers = integerMap.size();
                    System.out.println(integerMap);
                }
                if (uniqueNumbers > numberToGenerateUntilStop) {
                    this.semaphore.setRunning(false);
                    Thread.yield();
                }
                System.out.println("Amount of unique numbers: " + uniqueNumbers);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Tried to get integers from list before it was added, run again");
            }
        }
    }
}

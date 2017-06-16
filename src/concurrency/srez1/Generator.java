package concurrency.srez1;

import java.util.Map;
import java.util.Random;

/**
 * Created by davlet on 6/12/17.
 */
public class Generator implements Runnable{
    Map<Integer, Integer> integerToNumbOfOccurence;
    private Semaphore semaphore;

    public Generator(Map<Integer, Integer> integersMap, Semaphore semaphore){
        this.integerToNumbOfOccurence = integersMap;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            Integer randomNumber;
            while (semaphore.isRunning()){
                randomNumber = random.nextInt(10);
                System.out.println("Generated " + randomNumber);
                synchronized (integerToNumbOfOccurence){
                    if (!integerToNumbOfOccurence.containsKey(randomNumber))
                        integerToNumbOfOccurence.put(randomNumber, 1);
                    else {
                        int value = integerToNumbOfOccurence.get(randomNumber);
                        integerToNumbOfOccurence.put(randomNumber, ++value);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package concurrency.srez1;

import java.util.List;
import java.util.Random;

/**
 * Created by davlet on 6/12/17.
 */
public class Generator implements Runnable{
    List<Integer> integerList;
    public Generator(List<Integer> integers){
        this.integerList = integers;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 0; i < 100; i++){
                synchronized (integerList){
                    integerList.add(random.nextInt(100));
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

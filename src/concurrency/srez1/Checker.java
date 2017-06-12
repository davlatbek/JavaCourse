package concurrency.srez1;

import java.util.List;

/**
 * Created by davlet on 6/12/17.
 */
public class Checker implements Runnable {
    private List<Integer> integerList;
    private Integer uniqueNumber = 0;

    public Checker(List<Integer> integers){
        this.integerList = integers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                synchronized (integerList){
                    if (isUnique(integerList.get(i), integerList, i)){
                        uniqueNumber++;
                    }
                    System.out.println("Number: " + integerList.get(i) + " " + uniqueNumber);
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Tried to get integers from list before it was added, run again");
            }
        }
    }

    private static boolean isUnique(Integer integer, List<Integer> integers, Integer currentIndex){
        for (int i = 0; i < integers.size(); i++){
            if (i == currentIndex)
                continue;
            if (integers.get(i).equals(integer)){
                return false;
            }
        }
        return true;
    }
}

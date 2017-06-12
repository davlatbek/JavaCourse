package concurrency.exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 6/10/17.
 */
public class Consumer {
    private int result;
    private List<int[]> list = new ArrayList<>();
    /**
     * 3 потока разных типов, всего 9 потоков
     *
     */
    public void save(Cubator cubator, Quadrator quadrator, Singulator singulator) {
//        три директивы синхронизации
        synchronized (Cubator.class) {
            cubator.calculate(list.get(0));
        }

        synchronized (Quadrator.class){
            quadrator.calculate(list.get(1));
        }

        synchronized (Singulator.class){

        }

    }

    public static void main(String[] args) {
        int[] x = {1,2,3};
        int[] y = {4,5,6};
        int[] z = {7,8,9};
        int threadsize = 9;
        for (int i = 0; i < threadsize; i++){

        }
    }
}

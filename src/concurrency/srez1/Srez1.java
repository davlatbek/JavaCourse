package concurrency.srez1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 6/12/17.
 */
public class Srez1 {
    /**
     * variant 1
     * Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в интервале [0;99]. Второй поток раз в пять секунд выводит количество уникальных чисел, сгенерированных первым потоком. После того, как будет сгенерировано все 100 чисел, оба потока должны остановить свое выполнение.
     */
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        Runnable generator = new Generator(integerList);
        Thread thread1 = new Thread(generator);
        thread1.start();

        Runnable checker = new Checker(integerList);
        Thread thread2 = new Thread(checker);
        thread2.start();
    }
}

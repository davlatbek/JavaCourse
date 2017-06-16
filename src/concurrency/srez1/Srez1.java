package concurrency.srez1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davlet on 6/12/17.
 */
public class Srez1 {
    /**
     * variant 1
     * Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в интервале [0;99]. Второй поток раз в пять секунд выводит количество уникальных чисел, сгенерированных первым потоком. После того, как будет сгенерировано все 100 чисел, оба потока должны остановить свое выполнение.
     */
    public static void main(String[] args) {
        Map<Integer, Integer> integersList = new HashMap<>();
        Semaphore semaphore = new Semaphore();

        Runnable generator = new Generator(integersList, semaphore);
        Thread thread1 = new Thread(generator);
        thread1.start();

        Runnable checker = new Checker(integersList, 5, semaphore);
        Thread thread2 = new Thread(checker);
        thread2.start();
    }
}

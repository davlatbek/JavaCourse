package concurrency;

/**
 * 1. Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд. Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время.
 * 2. Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(), notifyAll().
 * Created by davlet on 6/9/17.
 */
public class Chronometer implements Runnable {
    private long current = 0L;
    private Message message;

    public Chronometer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            current++;
            System.out.println("Current time: " + current);
            try {
                Thread.sleep(1000);
                synchronized (message) {
                    message.notifyAll();
                    System.out.println("Notified all threads");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Message message = new Message("!!! 5 sec elapsed");

        Chronometer chronometer = new Chronometer(message);
        Thread thread1 = new Thread(chronometer);
        thread1.start();

        Thread thread2 = new Thread(()->{
            while(true) {
                synchronized (message) {
                    try {
                        message.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (chronometer.current % 5 == 0)
                        System.out.println("!!! Thread 2: " + chronometer.current + " sec elapsed");
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            while (true) {
                synchronized (message) {
                    try {
                        if (chronometer.current % 7 == 0)
                            System.out.println("!!! Thread 3: woke up");
                        message.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread3.start();
    }
}
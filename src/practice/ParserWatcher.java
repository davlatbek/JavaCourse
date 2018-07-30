package practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 6/16/17.
 */
public class ParserWatcher {
    /*
    Необходимо разработать программу, которая получает на вход список ресурсов, содержащих набор чисел и считает сумму всех положительных четных. Каждый ресурс должен быть обработан в отдельном потоке, набор должен содержать лишь числа, унарный оператор "-" и пробелы. Общая сумма должна отображаться на экране и изменяться в режиме реального времени.
    Запуск потоков реализовать через ссылки на методы, итоговый подсчет суммы через stream API
    */
    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        files.add(new File("./src/java8/practice/res1.txt"));
        files.add(new File("./src/java8/practice/res2.txt"));
        WorkerManager workerManager = new WorkerManager(files);
        workerManager.start();
        while (true){
            FileWatchService fileWatchService = new FileWatchService(workerManager);
            fileWatchService.watchFile(files);
        }
    }
}

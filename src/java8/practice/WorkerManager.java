package java8.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by davlet on 6/16/17.
 */
public class WorkerManager {
    private List<Worker> workers;
    private List<File> files;

    public WorkerManager(List<File> files){
        this.files = files;
        workers = new ArrayList<>();
        for (File file : files) {
            workers.add(new Worker(file));
        }
    }

    public void start(){
        ExecutorService executorService = Executors.newFixedThreadPool(files.size());
        System.out.println("Started parsing");
        for (Worker worker : this.workers){
            executorService.execute(worker);
        }
        executorService.shutdown();
    }
}

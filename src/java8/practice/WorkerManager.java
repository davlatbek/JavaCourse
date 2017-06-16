package java8.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 6/16/17.
 */
public class WorkerManager {
    private List<Worker> workers;
    private ThreadStartInterface threadStartInterface = Runnable::run;

    public WorkerManager(List<File> files){
        workers = new ArrayList<>();
        for (File file : files) {
            workers.add(new Worker(file));
        }
    }

    public void start(){
        for (Worker worker : workers){
            threadStartInterface.startThread(worker);
        }
    }
}

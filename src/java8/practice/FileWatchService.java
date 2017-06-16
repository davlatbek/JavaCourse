package java8.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by davlet on 6/16/17.
 */
public class FileWatchService {
    private WorkerManager workerManager;

    public FileWatchService(WorkerManager workerManager){
        this.workerManager = workerManager;
    }

    public static void printFile(Path file){
        List<String> readLines = null;
        try {
            readLines = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(readLines);
    }

    public void watchFile(List<File> files){
        Path path;
        java.nio.file.WatchService watchService;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path = Paths.get("./src/java8/practice/");
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;
            while ((key = watchService.take()) != null){
                for (WatchEvent<?> event : key.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    WatchEvent<Path> pathWatchEvent = (WatchEvent<Path>) event;
                    Path pathContext = pathWatchEvent.context();
                    if (filesChanged(kind, pathContext, files)){
                        restartParser();
                    }
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void restartParser(){
        workerManager.start();
    }

    private static boolean filesChanged(WatchEvent.Kind<?> kind, Path path, List<File> filesToWatch){
        for (File fileToWatch : filesToWatch){
            if (kind.name().equals("ENTRY_MODIFY") &&
                    path.toString().equals(fileToWatch.getName())) return true;
        }
        return false;
    }
}

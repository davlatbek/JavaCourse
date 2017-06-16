package java7;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by davlet on 6/16/17.
 */
public class WatchServiceExample {
    public static void main(String[] args) {
        WatchServiceExample watchServiceExample = new WatchServiceExample();
        watchServiceExample.watchFile(new File("file.txt"));
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

    public void watchFile(File file){
        Path path;
        WatchService watchService;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path = Paths.get("./");
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;
            while ((key = watchService.take()) != null){
                for (WatchEvent<?> event : key.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> pathWatchEvent = (WatchEvent<Path>) event;
                    Path fileName = pathWatchEvent.context();
                    System.out.println(kind.name() + " " + fileName);
                    if (kind.name().equals("ENTRY_MODIFY") &&
                            fileName.toString().equals(file.getName())){
                        System.out.println(fileName + " has been modified!");
                        System.out.println(fileName + " content: ");
                        printFile(Paths.get(file.toURI()));
                        key.reset();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

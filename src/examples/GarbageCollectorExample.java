package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by davlet on 6/14/17.
 */
public class GarbageCollectorExample {
    public static List<Object> cash = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        while(true){
            System.out.println("Wating for command ...");
            command = scanner.next();
            switch (command){
                case "collectable": createCollectable();
                    break;
                case "leakable": cash.add(createBigObject());
                    break;
                default: break;
            }
            System.out.println("Command complete!");
        }
    }

    public static void createCollectable(){
        createBigObject();
    }

    public static Object createBigObject(){
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++){
            list.add("i " + random.nextInt());
        }
        return list;
    }
}

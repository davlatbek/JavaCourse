package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by davlet on 6/16/17.
 */
public class Worker implements Runnable{
    private File file;

    public Worker(File file){
        this.file = file;
    }

    @Override
    public void run() {
        parseCount();
    }

    private void parseCount(){
        String line;
        List<Integer> integerList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null){
                for (String word : line.split(" ")){
                    integerList.add(Integer.parseInt(word));
                }
            }
            Integer sum = integerList.stream()
                    .filter((integer -> integer%2 == 0))
                    .collect(Collectors.toList()).stream()
                    .mapToInt((i -> i))
                    .sum();
            System.out.println("Sum of numbers in file " + file.getName() + " " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

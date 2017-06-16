package java8.practice;

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
        String[] lineSplitted;
        List<Integer> integerList = new ArrayList<>();
        List<Integer> resultList;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null){
                lineSplitted = line.split(" ");
                for (String word : lineSplitted){
                    integerList.add(Integer.parseInt(word.contains("-")? String.valueOf(0) : word));
                }
            }
            resultList = integerList.stream().filter((integer -> integer%2 == 0)).filter(integer -> integer > 0).collect(Collectors.toList());
            Integer sum = resultList.stream().mapToInt((i -> i)).sum();
            System.out.println("Sum of numbers in file " + file.getName() + " " + sum);
            System.out.println("========================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

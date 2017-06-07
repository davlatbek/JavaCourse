package com.innopolis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by davlet on 6/6/17.
 */
public class ExceptionOrder {
    {
        System.out.println("sadfaf");
    }

    public static void main(String[] args) {
        ExceptionOrder.main2(1);
    }

    public static int main2(int i){
        try {
            File file = new File("asdf.txt");
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.hasNext());
        } catch (FileNotFoundException e){
            throw new NullPointerException();
        }
        finally {
            System.out.println("asdfasdf");
            return 1;
        }
    }
}

package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class NewForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.forEach(s -> {
            System.out.println("item in list: " + s);
        });
        Function<String, Integer> function;
        list.forEach(System.out::print);
    }

}

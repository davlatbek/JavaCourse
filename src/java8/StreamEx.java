package java8;

import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by davlet on 6/16/17.
 */
public class StreamEx {
    public static void main(String[] args) {

        //filter
        List<Integer> intlist = new ArrayList<>();
        intlist.add(5);
        intlist.add(6);
        intlist.add(7);
        intlist.add(8);
        Object[] result = intlist.parallelStream().filter((s)->s > 5).toArray();
        for (Object object : result){
            System.out.println(object);
        }




        //reduce
        List<String> strlist = new ArrayList<>();
        strlist.add("asdf");
        strlist.add("asdf1");
        strlist.add("asdf2");
        strlist.add("asdf3");
        Optional<String> res = strlist.stream().reduce((s1, s2)->{
            return s1 + "|" + s2;
        });
        System.out.println(res);

        String s = strlist.stream()
                .filter(s1 -> s1.equals("asdf1"))
                .findAny().orElse(null);
        System.out.println(s);




        //map
        System.out.println(intlist
                .stream()
                .map(i -> i*2)
                .collect(Collectors.toList()));

        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");





        GreetingService greetingService = message -> {
            System.out.println(message + "!");
        };
        greetingService.sayMessage("message");


        Predicate<String> predicate = s1 -> s1.equals("str");
        System.out.println(predicate.test("str"));


    }

    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }
}

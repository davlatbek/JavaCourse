package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by davlet on 6/16/17.
 */
public class StreamEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Object[] result = list.parallelStream().filter((s)->s > 5).toArray();
        for (Object object : result){
            System.out.println(object);
        }

        List<String> stringList = new ArrayList<>();
        stringList .add("asdf");
        stringList .add("asdf1");
        stringList .add("asdf2");
        stringList .add("asdf3");

        Optional<String> res = stringList.stream().reduce((s1, s2)->{
            return s1 + "|" + s2;
        });
        System.out.println(res);
    }
}

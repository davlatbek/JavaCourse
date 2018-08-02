package java8;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReuseStream {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }
}

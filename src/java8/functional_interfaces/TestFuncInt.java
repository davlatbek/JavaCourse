package java8.functional_interfaces;


import java.util.function.Consumer;

public class TestFuncInt {
    public static void main(String[] args) {
        new TestFuncInt().testFunc(() -> System.out.println("Hello World"));
        new TestFuncInt().testFuncDefault((s) -> System.out.println(s));
    }

    public void testFunc(Process process){
        process.process();
    }

    public void testFuncDefault(Consumer<String> consumer){
        consumer.accept("hello");
    }
}

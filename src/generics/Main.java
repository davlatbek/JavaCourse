package generics;

/**
 * Created by davlet on 6/7/17.
 */
public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.setValue(5);
        System.out.println(box1.Compare(6));
    }
}

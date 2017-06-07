package generics;

/**
 * Created by davlet on 6/7/17.
 */
public class Box<T extends Comparable> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean Compare(T value){
        if (this.value.compareTo(value) == 0)
            return true;
        return false;
    }
}

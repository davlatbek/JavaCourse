package generics;

/**
 * Created by davlet on 6/7/17.
 */
public class BoxInteger {
    Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean Compare(Integer integer){
        return this.value == integer;
    }
}

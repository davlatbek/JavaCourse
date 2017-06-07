package generics;

/**
 * Created by davlet on 6/7/17.
 */
public class BoxString {
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean Compare(String value){
        return this.value.length() == value.length();
    }
}

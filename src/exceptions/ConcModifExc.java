package exceptions;

import java.util.HashMap;
import java.util.Map;

public class ConcModifExc {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.replace(entry.getKey(), entry.getValue()-1);
            if (entry.getValue() == 0) {
                map.remove(entry.getKey(), 0);
            }
        }
    }
}

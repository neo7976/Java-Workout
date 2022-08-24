package Easy.Roman13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Alfa {
    public Map<String, Integer> alphabet = new HashMap<>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public void entry() {
        for (Entry<String, Integer> entry : alphabet.entrySet()) {
            System.out.printf("Ключ:%s Значение: %4d\n", entry.getKey(), entry.getValue());
        }
    }

    public void romanToInteger(String s) {
        if(alphabet.containsKey(s))
        System.out.println(alphabet.get(s));
    }
}

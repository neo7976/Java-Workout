package Easy.Roman13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Roman {
    public Map<Integer, String> alphabet = new TreeMap<>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    public void entry() {
        for (Entry<Integer, String> entry : alphabet.entrySet()) {
            System.out.printf("Ключ: %4d Значение: %s\n", entry.getKey(), entry.getValue());
        }
    }
}

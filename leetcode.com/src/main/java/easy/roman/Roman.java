package easy.roman;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Roman {
    public Map<Integer, String> alphabet = new TreeMap<>(Comparator.reverseOrder()) {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(4, "IV");
        put(9, "IX");
        put(40, "XL");
        put(90, "XC");
        put(400, "CD");
        put(900, "CM");
        put(1000, "M");
    }};

    public void entry() {
        for (Entry<Integer, String> entry : alphabet.entrySet()) {
            System.out.printf("Ключ: %4d Значение: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public String arabToRoman(int value) throws NotValidateException {
        validate(value);
        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, String> entry : alphabet.entrySet()) {
            if (value >= entry.getKey()) {
                while (value >= entry.getKey()) {
                    sb.append(entry.getValue());
                    value -= entry.getKey();
                }
            }
        }
        return sb.toString();
    }

    public void validate(int value) throws NotValidateException {
        if (!(1 <= value && value <= 3999))
            throw new NotValidateException("Число больше 3999 или меньше 1");
    }
}




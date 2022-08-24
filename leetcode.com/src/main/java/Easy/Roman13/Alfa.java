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

    public int romanToInteger(String s) throws NotValidateException {
        int result = 0;
        String[] array = s.split("");
        for (int i = 1; i < array.length; i++) {
            String sum = array[i - 1].concat(array[i]);
            if (sum.contains("IV")) {
                result += 4;
                array[i] = "";
                array[i - 1] = "";
            } else if (sum.contains("IX")) {
                result += 9;
                array[i] = "";
                array[i - 1] = "";
            } else if (sum.contains("XL")) {
                result += 40;
                array[i] = "";
                array[i - 1] = "";
            } else if (sum.contains("XC")) {
                result += 90;
                array[i] = "";
                array[i - 1] = "";
            } else if (sum.contains("CD")) {
                result += 400;
                array[i] = "";
                array[i - 1] = "";
            } else if (sum.contains("CM")) {
                result += 900;
                array[i] = "";
                array[i - 1] = "";
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (alphabet.containsKey(array[i])) {
                result += alphabet.get(array[i]);
            }
        }
        validate(result);
        return result;
    }

    public void validate(int result) throws NotValidateException {
        if (!(1 <= result && result <= 3999))
            throw new NotValidateException("Число больше 3999 или меньше 1");
    }
}

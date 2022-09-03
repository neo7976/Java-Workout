package easy.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Alfa {
    public Map<String, Integer> alphabet = new HashMap<>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
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
            if (!array[i - 1].equals("") && !array[i].equals("")) {
                String sum = array[i - 1].concat(array[i]);
                if (alphabet.containsKey(sum)) {
                    result += alphabet.get(sum);
                    array[i] = "";
                    array[i - 1] = "";
                }
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

package codewars.sixkyu;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Сортировка строки по имеющимся в слове цифре
 */
public class Order {

    public static String order(String words) {
        String[] array = words.split(" ");
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            List<String> res = Arrays.stream(array[i].split("")).filter(StringUtils::isNumeric).toList();
            int x = 1;
            if (!res.isEmpty()) {
                x = Integer.parseInt(res.get(0));
                System.out.println(x);
            }
            result[x - 1] = array[i];
        }
        return String.join(" ", result);
    }
}


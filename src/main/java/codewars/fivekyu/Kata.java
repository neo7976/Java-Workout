package codewars.fivekyu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    public String incrementString(String str) {

        List<String> check = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        if (str.length() == 0 || !check.contains(str.substring(str.length() - 1))) {
            return str + "1";
        }


        return str.endsWith("9") ? incrementString(str.substring(0, str.length() - 1)) + "0" :
                str.substring(0, str.length() - 1) + (Integer.parseInt(str.substring(str.length() - 1)) + 1);
    }
}

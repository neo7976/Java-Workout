package codewars.fivekyu;

import java.util.Arrays;
import java.util.Comparator;

public class WeightSort {

    public String orderWeight(String string) {
        String[] array = string.split(" ");
        Arrays.sort(array, comparator);
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int n = o1.chars().reduce(0, (x, y) -> x + (y - '0'));
            int m = o2.chars().reduce(0, (x, y) -> x + (y - '0'));
            if (n > m)
                return 1;
            else if (n < m)
                return -1;
            else {
                return o1.compareTo(o2);
            }
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };
}

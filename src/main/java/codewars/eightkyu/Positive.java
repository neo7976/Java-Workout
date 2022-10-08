package codewars.eightkyu;

import java.util.Arrays;

public class Positive {
    public int sum(int[] arr) {
        if (arr.length != 0) {
            return Arrays.stream(arr).filter(x -> x > 0).sum();
        }
        return 0;
    }
}

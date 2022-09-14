package youtube.hashcoder.yandex.one;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Value {
    private final int[] array = new int[]{
            2, 2, 5, 5, 4, 4, 8, 8, 9, -1, -5
    };

    //Скорость О(n) и Память О(n)
    public int foundValue(int[] array) {
        Map<Integer, Long> map = Arrays.stream(array).boxed().filter(x -> x > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        Value value = new Value();
        System.out.println(value.foundValue(value.array));
    }
}

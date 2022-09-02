package codewars.fivekyu;

import static java.util.Comparator.reverseOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class Greed {
    public int greedy(int[] dice) {
        Random random = new Random();
        int sum = 0;
        int[] chance = new int[5];
        for (int i = 0; i < chance.length; i++) {
            chance[i] = random.nextInt(1, 7);
        }
        System.out.println(Arrays.toString(chance));
        Map<List<Integer>, Integer> map = new HashMap<>() {{
            put(Arrays.asList(1, 1, 1), 1000);
            put(Arrays.asList(6, 6, 6), 600);
            put(Arrays.asList(5, 5, 5), 500);
            put(Arrays.asList(4, 4, 4), 400);
            put(Arrays.asList(3, 3, 3), 300);
            put(Arrays.asList(2, 2, 2), 200);
            put(List.of(1), 100);
            put(List.of(5), 50);
        }};
        Map<List<Integer>, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        for (Entry<List<Integer>, Integer> listIntegerEntry : sortedMap.entrySet()) {
            List<Integer> list = Arrays.stream(chance).boxed().toList();
            System.out.println(list);

        }
        return sum;
    }
}



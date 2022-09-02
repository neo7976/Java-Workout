package codewars.fivekyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Greed {
    //todo добить присвоение значений по ключу вместо выводы на экран
    public int greedy(int[] dice) {
//        Random random = new Random();
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(1, 7);
//        }
        int sum = 0;
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
        List<Integer> listDel = Arrays.stream(dice).boxed().sorted().toList();
        List<Integer> list = new ArrayList<>(listDel);
        System.out.println(list);

        for (Entry<List<Integer>, Integer> listIntegerEntry : sortedMap.entrySet()) {
            for (int i = 0; i < 3; i++) {
                if (list.size() >= 3) {
                    List<Integer> listToCopy = list.subList(i, i + 3);

                    if (listToCopy.equals(listIntegerEntry.getKey())) {
                        System.out.println("Ключ " + listIntegerEntry.getKey() + ": Cписок:" + listToCopy + "-" + listToCopy.equals(listIntegerEntry.getKey()));
                        list.subList(i, i + 3).clear();
                    }
                }
            }
            System.out.println(list);
            for (int j = 0; j < list.size(); j++) {
                List<Integer> listToCopy = list.subList(j, j + 1);
                if (listToCopy.equals(listIntegerEntry.getKey())) {
                    System.out.println("Ключ " + listIntegerEntry.getKey() + ": Cписок:" + listToCopy + "-" + listToCopy.equals(listIntegerEntry.getKey()));
                    list.set(j, 0);
                    System.out.println(list);
                }
            }
        }
        return sum;
    }
}



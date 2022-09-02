package codewars.fivekyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class Greed {

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

        List<Integer> list = Arrays.stream(dice).boxed().sorted().toList();
        System.out.println(list);
//        HashSet<List<Integer>> set = new HashSet<>(map.keySet());
//        System.out.println(set);

//        for (List<Integer> integers : set) {
//            System.out.println("Ключ: " + integers + " - " + list.containsAll(integers));
//        }
        for (Entry<List<Integer>, Integer> listIntegerEntry : sortedMap.entrySet()) {
//            if (list.containsAll(listIntegerEntry.getKey())) {
//                System.out.println("Ключ " + listIntegerEntry.getKey() + ": Да");
            List<Integer> listToCopy = list.subList(0, 3);
            System.out.println("Ключ " + listIntegerEntry.getKey() + ": Cписок:" + listToCopy + "-" + listToCopy.equals(listIntegerEntry.getKey()));


        }

        return sum;
    }

    public <T> boolean myListContains(List<T> list, List<T> element) {
        if (list == null || element == null)
            return false;
        if (list.isEmpty())
            return false;
        for (T t : list) {
            if (element.equals(t))
                return true;
        }
        return false;
    }

}



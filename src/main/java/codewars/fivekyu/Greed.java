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
import java.util.function.Function;
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
                        sum += listIntegerEntry.getValue();
                        System.out.println(list);
                    }
                }
            }
            for (int j = 0; j < list.size(); j++) {
                List<Integer> listToCopy = list.subList(j, j + 1);
                if (listToCopy.equals(listIntegerEntry.getKey())) {
                    System.out.println("Ключ " + listIntegerEntry.getKey() + ": Cписок:" + listToCopy + "-" + listToCopy.equals(listIntegerEntry.getKey()));
                    list.set(j, 0);
                    sum += listIntegerEntry.getValue();
                    System.out.println(list);
                }
            }
        }
        return sum;
    }


    public int greedy1(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) n[d]++;
        return n[1] / 3 * 1000 + n[1] % 3 * 100 + n[2] / 3 * 200 + n[3] / 3 * 300 + n[4] / 3 * 400 + n[5] / 3 * 500 + n[5] % 3 * 50 + n[6] / 3 * 600;
    }

    public int greedy2(int[] dice) {
        Map<Integer, Long> collect = Arrays.stream(dice).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Entry<Integer, Long> integerLongEntry : collect.entrySet()) {
            System.out.println("Ключ: " + integerLongEntry.getKey() + " Значение: " + integerLongEntry.getValue());
        }
        int score = 0;
        for (Map.Entry<Integer, Long> e : collect.entrySet()) {
            switch (e.getKey()) {
                case 1:
                    score += ((e.getValue() >= 3) ? 1000 : 0) + (e.getValue() % 3) * 100;
                    break;
                case 2:
                    score += ((e.getValue() >= 3) ? 200 : 0);
                    break;
                case 3:
                    score += ((e.getValue() >= 3) ? 300 : 0);
                    break;
                case 4:
                    score += ((e.getValue() >= 3) ? 400 : 0);
                    break;
                case 5:
                    score += ((e.getValue() >= 3) ? 500 : 0) + (e.getValue() % 3) * 50;
                    break;
                case 6:
                    score += ((e.getValue() >= 3) ? 600 : 0);
                    break;
            }
        }
        return score;
    }
}



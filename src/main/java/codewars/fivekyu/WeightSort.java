package codewars.fivekyu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {

    public String orderWeight(String string) {
        String[] array = string.trim().split(" ");
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
            return (n - m) != 0 ? n - m : o1.compareTo(o2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    //Добавил trim чтобы проходили пробелы
    public String orderWeight1(String string) {
        String[] split = string.trim().split(" ");
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String a, String b) {
                int aWeight = a.chars().map(Character::getNumericValue).sum();
                int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
                return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
            }
        });
        return String.join(" ", split).trim();
    }

    public String orderWeight2(String strng) {
        return
                Arrays.stream(strng.trim().split(" "))
                        .sorted(Comparator
                                .comparing(WeightSort::sumDigits)
                                .thenComparing(String::compareTo))
                        .collect(Collectors.joining(" ")).trim();

    }

    private static Integer sumDigits(String s) {
        return s.chars().map(c -> c - 48).sum();
    }
}


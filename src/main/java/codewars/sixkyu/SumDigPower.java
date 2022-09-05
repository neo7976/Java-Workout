package codewars.sixkyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> list = new ArrayList<>(LongStream.range(a, b + 1).boxed().toList());
        List<Long> listReturn = new ArrayList<>();
        for (Long aLong : list) {
            String[] array = aLong.toString().split("");
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += (int) Math.pow(Double.parseDouble(array[i]), i + 1);
                if (i == array.length - 1 && aLong == sum)
                    listReturn.add(aLong);
            }
        }
        return listReturn;
    }

    public List<Long> sumDigPow1(long a, long b) {
        return LongStream.rangeClosed(a, b)   //Создание интервала от a до b включительно
                .filter(i -> isValid(i))
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isValid(long x) {
        String value = Long.toString(x);
        return IntStream.range(0, value.length())
                .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i + 1))
                .sum() == x;
    }
}


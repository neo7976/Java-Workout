package codewars.sixku;

import java.util.stream.IntStream;

public class Kata {
    public static String createPhoneNumber1(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i <= 2; i++) {
            sb.append(numbers[i]);
        }
        sb.append(") ");
        for (int i = 3; i <= 5; i++) {
            sb.append(numbers[i]);
        }
        sb.append("-");
        for (int i = 6; i <= 9; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    public static String createPhoneNumber2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }
}

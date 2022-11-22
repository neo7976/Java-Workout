package codewars.fourkyu;

import java.util.stream.LongStream;

public class Kata {
    public static String Factorial(int n) {
        String s = null;
        s = String.valueOf(LongStream.range(1, n + 1).reduce(1, (x, y) -> x * y));
        return s;
    }
    public static void main(String[] args) {
        System.out.println(Factorial(15));
    }
}

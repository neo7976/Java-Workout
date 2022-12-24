package codewars.sevenkyu;

public class Kata {

    public String binaryAddition(int a, int b) {
        int c = a + b;

        StringBuilder sb = new StringBuilder();

        while (true) {
            int x = c / 2;
            sb.append(c % 2);
            c = x;
            if (x <= 0)
                break;
        }
        String result = sb.reverse().toString();
        System.out.printf("%d + %d = %s (%d+%d=%d in decimal or %s in binary)\n",
                a, b, result, a, b, a + b, result);
        return result;
    }

    public String binaryAdditionSecond(int a, int b) {
        return Integer.toBinaryString(a + b);
    }
}

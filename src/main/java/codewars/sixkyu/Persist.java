package codewars.sixkyu;

public class Persist {
    public int persistence(long n) {
        int count = 0;
        String[] split = String.valueOf(n).split("");
        if (split.length > 1) {
            count++;
            long sum = 1;
            for (String s : split) {
                sum *= Long.parseLong(s);
            }
            System.out.println(sum);
            count += persistence(sum);
        } else
            return 0;
        return count;
    }


    public int persistence1(long n) {
        int times = 0;
        while (n >= 10) {
            n = Long.toString(n).chars().reduce(1, (r, i) -> r * (i - '0'));
            System.out.println(n);
            times++;
        }
        return times;
    }
}

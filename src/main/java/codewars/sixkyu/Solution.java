package codewars.sixkyu;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

//todo Ещё не проходил многопоточность, поэтому код не работает
public class Solution {
    public int solveSuperMarketQueue(int[] customers, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int customer : customers) {
            queue.add(customer);
        }
        int[] arrayValue = new int[n];
        int count = 0;
        AtomicInteger count1 = new AtomicInteger();

        while (!queue.isEmpty()) {
            if (arrayValue[0] == 0)
                arrayValue[0] = queue.poll();
            arrayValue[0]--;
            count++;
        }

        if (n == 2) {
            new Thread(() -> {

                while (!queue.isEmpty())
                    if (arrayValue[1] == 0)
                        arrayValue[1] = queue.poll();
                try {
                    System.out.println("Привет");
                    arrayValue[1]--;
                    count1.getAndIncrement();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }).start();
        }
        return Math.max(count, count1.intValue());

    }
}

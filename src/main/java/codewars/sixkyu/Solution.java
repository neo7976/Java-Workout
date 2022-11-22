package codewars.sixkyu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Solution {
    public int solveSuperMarketQueue(int[] customers, int n) throws ExecutionException, InterruptedException {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int customer : customers) {
            queue.add(customer);
        }
        List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Callable<Integer> thread = new MyCallable(queue, "Кассир-" + i);
            callableList.add(thread);
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> task = threadPool.invokeAll(callableList);
        int value = 0;
        for (Future<Integer> future : task) {
            value = Math.max(value, future.get());
            System.out.println(future.get());
        }
        return value;
    }
}

class MyCallable extends Thread implements Callable<Integer> {

    final Queue<Integer> queue;
    int count;
    String name;

    public MyCallable(Queue<Integer> queue, String name) {
        this.queue = queue;
        this.count = 0;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int value = 0;
        while (!queue.isEmpty()) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    value = queue.poll();
                }
            }
            while (value != 0) {
                value--;
                count++;
                Thread.sleep(100);
            }
            System.out.printf("%s - Свободная касса!\n", name);
        }
        return count;
    }
}

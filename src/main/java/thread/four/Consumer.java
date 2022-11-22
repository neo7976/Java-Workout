package thread.four;

public class Consumer implements Runnable {
    private MyQueue<Integer> myQueue;

    public Consumer(MyQueue<Integer> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                myQueue.get();
            }
        }
    }
}
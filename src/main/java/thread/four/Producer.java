package thread.four;

public class Producer implements Runnable {
    private  MyQueue<Integer> myQueue;

    public Producer(MyQueue<Integer> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                myQueue.put(i);
            }
        }
    }
}
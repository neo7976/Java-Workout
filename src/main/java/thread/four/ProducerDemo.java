package thread.four;

public class ProducerDemo {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        Consumer consumer = new Consumer(myQueue);
        Producer producer = new Producer(myQueue);

        Thread t1 = new Thread(consumer, "Покупатель-1");
        Thread t2 = new Thread(consumer, "Покупатель-2");
        Thread t3 = new Thread(producer);

        t3.start();
        t1.start();
        t2.start();
    }
}

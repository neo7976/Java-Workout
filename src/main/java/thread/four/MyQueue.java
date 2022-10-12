package thread.four;

public class MyQueue<T> {
    private T n;
    volatile boolean valueSet = false;

    public synchronized T get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Пoлyчeнo: " + n + " Получил >> " + Thread.currentThread().getName());
        valueSet = false;

        try {
            Thread.sleep(1000);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n;
    }

    public synchronized void put(T n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = true;
        this.n = n;
        System.out.println("Oтпpaвлeнo: " + n);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }
}

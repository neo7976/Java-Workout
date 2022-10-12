package thread.three;

public class MyThread extends Thread implements Runnable {
    StringBuilder sb;

    public MyThread(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        try {
            synchronized (sb) {
                for (int i = 0; i < 100; i++) {
                    System.out.printf("%s >> %s\n", Thread.currentThread().getName(), sb.toString());
                    Thread.sleep(50);
                }
                char s = (char) (sb.toString().charAt(0) + 1);
                sb.replace(0, 1, String.valueOf(s));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

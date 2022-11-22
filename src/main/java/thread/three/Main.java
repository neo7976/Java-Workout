package thread.three;


/**
 * Необходимо создать три потока, которые изменяют один и тот же объект.
 * Каждый поток должен вывести на экран одну букву 100 раз, и затем увеличить значение символа на 1.
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('b');
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new MyThread(sb));
            thread.setName("Поток " + i);
            thread.start();
        }

    }
}

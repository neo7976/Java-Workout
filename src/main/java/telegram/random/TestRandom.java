package telegram.random;

import java.util.*;

public class TestRandom {
    public static void main(String[] args) {
        //Создаем 25 чисел от 1 до 24
        List<Integer> list = new ArrayList<>();
        (new Random()).ints(25, 1,25).sorted().forEach(System.out::println);
        (new Random()).ints(25, 1,25).sorted().forEach(list::add);
        System.out.println(list);
    }
}

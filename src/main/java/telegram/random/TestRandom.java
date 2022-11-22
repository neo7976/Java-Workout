package telegram.random;

import java.util.*;

public class TestRandom {
    public static void main(String[] args) {
        //Создаем 25 чисел от 1 до 24
        (new Random()).ints(25, 1,25).sorted().forEach(System.out::println);
    }
}

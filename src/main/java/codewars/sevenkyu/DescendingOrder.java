package codewars.sevenkyu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Ваша задача состоит в том, чтобы создать функцию, которая может принимать любое неотрицательное целое
 * число в качестве аргумента и возвращать его с цифрами в порядке убывания. По сути, переставьте цифры,
 * чтобы получить максимально возможное число.
 *
 * Примеры:
 * Вход: 42145 Выход:54421
 *
 * Вход: 145263 Выход:654321
 *
 * Вход: 123456789 Выход:987654321
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        List<String> list = Arrays.stream(String.valueOf(num).split(""))
                .sorted(Collections.reverseOrder())
                .toList();
        return Integer.parseInt(String.join("", list));
    }

    public static void main(String[] args) {
        System.out.println(DescendingOrder.sortDesc(1028547));
    }
}

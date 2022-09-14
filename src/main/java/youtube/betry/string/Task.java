package youtube.betry.string;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        String str = "   Изучаю Java      и строки давно     прошёл, но сегодня понял ,    что есть пробелы   в знаниях. Очень полезно!!!";

        //Вырезаем пробелы в начале и конце. Первая замена регулярных знаков идет на пробел,
        // вторая - если пробелов более двух, то они заменяются на 1, далее уже бьем на массив.
        String[] array = str.trim().replaceAll("\\p{P}", " ").replaceAll("\\s{2,}", " ").split(" ");
        for (String s : array) {
            System.out.println(s);
        }
        System.out.println(array.length);

        System.out.println(maskify("4458887455478547"));
    }

    // заменяет все символы кроме последних на решетки
    public static String maskify(String str) throws UnsupportedOperationException {
        return str.replaceAll(".(?=.{4})", "#");
    }
}

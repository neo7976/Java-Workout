package codewars.sixkyu;

import java.util.List;

/**
 * Учитывая массив (arr) в качестве аргумента, завершите функцию countSmileys, которая должна вернуть общее количество улыбающихся лиц.
 * <p>
 * Правила улыбающегося лица:
 * <p>
 * Каждый смайлик должен содержать допустимую пару глаз. Глаза могут быть отмечены как :или;
 * У смайлика может быть нос, но не обязательно. Допустимые символы для носа -или~
 * Каждое улыбающееся лицо должно иметь улыбающийся рот, который должен быть отмечен либо значком, ) либо D
 * Не допускается использование дополнительных символов, кроме упомянутых.
 * <p>
 * Примеры допустимых смайликов: :) :D ;-D :~)
 * Недопустимые смайлики: ;( :> :} :]
 * <p>
 * Пример
 * countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
 * countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
 * countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
 */

public class SmileFaces {
    public int countSmileys(List<String> arr) {
        // Just Smile :)
        int sum = 0;
        for (String s : arr) {
            String[] smile = s.split("");
            if (smile.length == 2) {
                if (smile[0].equals(":") || smile[0].equals(";")) {
                    if (smile[smile.length - 1].equals(")") || smile[smile.length - 1].equals("D")) {
                        sum++;
                    }
                }
            }
            if (smile.length == 3 && (smile[1].equals("-") || smile[1].equals("~"))) {
                if (smile[0].equals(":") || smile[0].equals(";")) {
                    if (smile[smile.length - 1].equals(")") || smile[smile.length - 1].equals("D")) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Использование регулярных выражений и потоков
     * https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
     */

    public static int countSmileys1(List<String> arr) {
        return (int) arr.stream().filter(x -> x.matches("[:;][-~]?[)D]")).count();
    }
}



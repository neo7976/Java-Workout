package codewars.sixku;

/**
 * Цифровой корень — это рекурсивная сумма всех цифр числа.
 * <p>
 * Учитывая n, возьмите сумму цифр n. Если это значение имеет более одной цифры, продолжайте уменьшать таким образом,
 * пока не будет получено однозначное число. Ввод будет неотрицательным целым числом.
 * <p>
 * Примеры
 * 16  -->  1 + 6 = 7
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */

public class DRoot {
    public int digital_root(int n) {
        int sum = 0;
        if (n != 0) {
            sum = n % 10 + digital_root(n / 10);
            if (sum >= 10)
                sum = digital_root(sum);
        }
        return sum;
    }

    public int digital_root1(int n) {
        if (n < 10)
            return n;
        else
            return digital_root(n % 10 + digital_root(n / 10));
    }
}
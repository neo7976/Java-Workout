package youtube.alexlukin.weather;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Требуется найти, через сколько дней погода станет теплее от текущего показателя.
 * Значения нужно указать для каждого дня.
 */

public class Weather {
    //    Скорость О(n^2)   Память О(n) (Если бы просили указать только 1 значение,
    //    когда станет теплее, то память была бы О(1)
    public int[] findSunnyDay(int[] array) {
        int max = 0;
        int[] answer = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    answer[i] = array[i] - array[j];
                    break;
                }
            }
        }
        return answer;
    }

    //    Скорость О(n)   Память О(n)
    public int[] findSunnyDayForStack(int[] array) {
//        Stack<Temp> stack = new Stack<>();
        Deque<Temp> stack = new ArrayDeque<>();
        int[] answer = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().value <= array[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek().index - i;
            }
            stack.push(new Temp(array[i], i));
        }
        return answer;
    }
}

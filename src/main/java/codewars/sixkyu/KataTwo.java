package codewars.sixkyu;

import java.util.Arrays;

public class KataTwo {
    public int findEvenIndex(int[] arr) {
        int memoryLeft = 0;
        int memoryRight = 0;
        for (int i : arr) {
            memoryRight += i;
        }
//        memoryRight = Arrays.stream(arr).sum(); - просуммировать массив
        for (int i = 0; i < arr.length; i++) {
            memoryRight -= arr[i];
            if (memoryLeft == memoryRight)
                return i;
            memoryLeft += arr[i];
        }
        return -1;
    }

}

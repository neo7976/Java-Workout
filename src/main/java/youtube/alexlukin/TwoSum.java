package youtube.alexlukin;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    //Скорость О(n)  Память 0(n)
    public int[] twoSum(int[] array, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int foundValue = k - array[i];
            if (set.contains(foundValue))
                return new int[]{foundValue, array[i]};
            set.add(array[i]);
        }
        return new int[0];
    }

    //Скорость О(n * log n)  Память 0(1)
    public int[] twoSumBinary(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int numberToFind = k - array[i];
            int left = i + 1, right = array.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (array[middle] == numberToFind)
                    return new int[]{array[i], array[middle]};
                if (numberToFind < array[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        }
        return new int[0];
    }

    //Скорость О(n)  Память 0(1)
    public int[] twoSumLine(int[] array, int k) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == k)
                return new int[]{array[left], array[right]};
            else if (sum < k)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}

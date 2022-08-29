package easy.array.remove;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Remove array = new Remove();
        final String[] ints = array.removeDuplicatesFromSortedArray(array.getArrayInput());
        System.out.println(Arrays.toString(ints));

        int[] arrays = new int[]{
                5,
                5,
                5,
                5,
                10,
                10,
                10,
                10,
                10,
                20,
                20,
                20,
                30,
                30,
                30,
                30
        };

        array.setArrayInput(arrays);
        String[] ints2 = array.removeDuplicatesFromSortedArray(array.getArrayInput());
        System.out.println(Arrays.toString(ints2));
    }


}

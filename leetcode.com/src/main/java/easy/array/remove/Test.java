package easy.array.remove;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Remove array = new Remove();
        final String[] ints = array.removeDuplicatesFromSortedArray(array.arrayInput);
        System.out.println(Arrays.toString(ints));
    }
}

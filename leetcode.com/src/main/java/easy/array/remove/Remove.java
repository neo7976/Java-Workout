package easy.array.remove;

public class Remove {

    public String[] arrayInput = {"0", "0", "1", "1", "1", "2", "2", "3", "3", "4"};

    public String[] removeDuplicatesFromSortedArray(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].equals(array[i]) && i != j && !array[j].equals("_") && !array[i].equals("_")) {
                    array[j] = "_";
                    count++;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].equals("_")) {
                    String x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                } else if (Integer.parseInt(array[j]) > Integer.parseInt(array[j] + 1)) {
                    String x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }
        System.out.println(count);
        return array;
    }

//    public void pivoting(int[] array, int pi) {
//        int left = 0;
//        int right = 0;
//        int pivot = array[pi];
//        while (true) {
//            while (array[left] < pivot) {
//                left += 1;
//            }
//            while (array[right] < pivot) {
//                right -= 1;
//            }
//            if (left >= right)
//                pivot = left;
//            int x = array[left];
//            array[left] = array[right];
//            array[right] = x;
//        }
//    }


}

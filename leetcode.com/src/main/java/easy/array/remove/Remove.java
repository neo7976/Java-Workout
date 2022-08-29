package easy.array.remove;

import java.util.Arrays;

public class Remove {

    private String[] arrayInput = {"0", "0", "1", "1", "1", "2", "2", "3", "3", "4"};

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

    public void setArrayInput(int[] arrayInput) {
        String[] arraysStr = new String[arrayInput.length];
        for (int i = 0; i < arrayInput.length; i++) {
            arraysStr[i] = String.valueOf(arrayInput[i]);
        }
        this.arrayInput = arraysStr;
    }

    public String[] getArrayInput() {
        return arrayInput;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }
}

package sort;

import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-09 19:23
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = Utils.shuffledArray(17);
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    Utils.swap(array, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}

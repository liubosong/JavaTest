package sort;

import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-09 19:09
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = Utils.shuffledArray(17);
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minPos] > array[j]) {
                    minPos = j;
                }
            }
            Utils.swap(array, i, minPos);
        }
    }
}

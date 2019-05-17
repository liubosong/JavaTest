package utils;

import java.util.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-08 14:15
 **/
public class ChoiceSort {
    public static void main(String[] args) {
        int[] array = shuffledArray(15);
        shellSort(array);
        System.out.println(Arrays.toString(array));
//        shellSort(array, 4);
//        System.out.println(Arrays.toString(ints));
//        choiceSortOne(ints);
//        choiceSortDouble(ints);
//        insertSort(ints);
//        shellSort(ints, 4);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(ints.length);
    }

     static int[] shuffledArray(int len) {
        int[] ints = new int[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 15; i++) {
            ints[i] = list.get(i);
        }
        System.out.println(Arrays.toString(ints));
        return ints;
    }

    public static void choiceSortOne(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
            }
            swap(array, i, minPos);
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length >> 1; gap > 0; gap -= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (array[j - gap] > array[j]) {
                        swap(array, j - gap, j);
                    }
                }
            }
        }
    }

    public static void choiceSortDouble(int[] array) {
        for (int i = 0; i <= ((array.length) / 2); i++) {
            int minPos = i;
            int maxPos = i;
            for (int j = i + 1; j < array.length - i; j++) {
                minPos = array[j] < array[minPos] ? j : minPos;
                maxPos = array[j] > array[maxPos] ? j : maxPos;

            }
            swap(array, i, minPos);
            if (minPos + maxPos != array.length - 1) {
                swap(array, array.length - i - 1, maxPos);
            }
        }
    }

    static void swap(int[] array, int first, int second) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}

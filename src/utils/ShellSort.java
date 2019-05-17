package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-08 19:22
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] array = shuffledArray(20);
        System.out.println(Arrays.toString(array));
        long before = System.nanoTime();
        shellSort(array);
        long after = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println((after - before) / 1000);
    }

    public static void shellSort(int[] array) {
        int h = 1;
        while (h < (array.length - 1) / 3) {
            h = 3 * h + 1;
        }
        for (int gap = h; gap >= 1; gap = (gap - 1) / 3) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (array[j - gap] > array[j]) {
                        swap(array, j - gap, j);
                    }
                }
            }
        }
    }

     static int[] shuffledArray(int len) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);
        for (int i = 0; i < len; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void swap(int[] array, int before, int after) {
        int temp = array[after];
        array[after] = array[before];
        array[before] = temp;
    }
}

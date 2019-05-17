package utils;

import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-09 09:33
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] array = ShellSort.shuffledArray(28);
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        buildHeap(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            Utils.swap(array, 0, i);
            heapify(array, 0, i);
        }
    }

    public static void buildHeap(int[] array, int length) {
        int lastParent = (length - 2) >> 1;
        for (int i = lastParent; i >= 0; i--) {
            heapify(array, i, length);
        }
    }

    public static void heapify(int[] array, int parent, int length) {
        int c1 = 2 * parent + 1;
        int c2 = 2 * parent + 2;
        int max = parent;
        if (c1 < length && array[c1] > array[max]) {
            max = c1;
        }
        if (c2 < length && array[c2] > array[max]) {
            max = c2;
        }
        if (max != parent) {
            Utils.swap(array, max, parent);
            heapify(array, max, length);
        }

    }
}

package utils;

import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-08 20:36
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] array = ShellSort.shuffledArray(17);
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    public static void sort(int[] array, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) >> 1;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int leftP = left;
        int rightP = mid + 1;
        int tempP = 0;
        while (leftP <= mid && rightP <= right) {
            temp[tempP++] = array[leftP] <= array[rightP] ? array[leftP++] : array[rightP++];
        }
        while (leftP <= mid) {
            temp[tempP++] = array[leftP++];
        }
        while (rightP <= right) {
            temp[tempP++] = array[rightP++];
        }
        tempP = 0;
        while (left <= right) {
            array[left++] = temp[tempP++];
        }
    }
}

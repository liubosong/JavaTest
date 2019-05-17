package sort;

import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-09 19:31
 **/
public class Sorts {
    public static void main(String[] args) {
        int[] array = Utils.shuffledArray(27);
        System.out.println(Arrays.toString(array));
//        insertSort(array);
//        shellSort(array);
        mergeSort(array);
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    Utils.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        int h = 0;
        while (h < (array.length - 1) / 3) {
            h = 3 * h + 1;
        }
        for (int k = h; k > 0; k = (k - 1) / 3) {
            for (int i = k; i < array.length; i++) {
                for (int j = i - k; j >= 0; j--) {
                    if (array[j + k] < array[j]) {
                        Utils.swap(array, j, j + k);
                    }
                }
            }
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int midPos = part(array, left, right);
            quickSort(array, left, midPos - 1);
            quickSort(array, midPos + 1, right);
        }
    }

    public static int part(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        divide(array, 0, array.length - 1, temp);
    }

    public static void divide(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int midPos = (left + right) >> 1;
            divide(array, left, midPos, temp);
            divide(array, midPos + 1, right, temp);
            merge(array, left, midPos, right, temp);
        }
    }

    public static void merge(int[] array, int left, int midPos, int right, int[] temp) {
        int leftP = left;
        int rightP = midPos + 1;
        int p = 0;
        while (leftP <= midPos && rightP <= right) {
            if (array[leftP] <= array[rightP]) {
                temp[p++] = array[leftP++];
            } else {
                temp[p++] = array[rightP++];
            }
        }
        while (leftP <= midPos) {
            temp[p++] = array[leftP++];
        }
        while (rightP <= right) {
            temp[p++] = array[rightP++];
        }
        p = 0;
        while (left <= right) {
            array[left++] = temp[p++];
        }
    }
}

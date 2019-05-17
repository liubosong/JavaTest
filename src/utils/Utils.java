package utils;

import sortDemo.StringCompare;

import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 19:36
 **/
public class Utils {
    /**
     * 容器的排序 List
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        /**
         * 第一步 转成数组
         * 第二步 改变容器中对应的值
         */
        Object[] array = list.toArray();
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            list.set(i, (T) array[i]);
        }
    }

    /**
     * 泛型排序
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }


    /**
     * 数据的排序
     * 从小到大
     */
    public static void bubbleSort(Object[] array) {
        boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    Object temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void bubbleSort(Object[] array, StringCompare comp) {
        boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comp.compare((String) array[j], (String) array[j + 1]) > 0) {
                    Object temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

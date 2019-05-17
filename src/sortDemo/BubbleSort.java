package sortDemo;

import java.util.Arrays;

import static utils.Utils.bubbleSort;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 17:52
 **/
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] array = {7, 4, 6, 2, 8, 4, 6, 2, 9, 11, 2, 5, 2, 4, 7, 3, 8, 3, 6, 9, 6, 5, 7, 4, 8, 5, 6, 3, 1, 7, 5, 1, 9,};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


}

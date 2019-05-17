package sortDemo;

import java.util.Arrays;
import java.util.Date;

import static utils.Utils.bubbleSort;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 19:31
 **/
public class BubbleSortDate {

    public static void main(String[] args) {
        Date[] array = new Date[3];
        array[0] = new Date();
        array[1] = new Date(System.currentTimeMillis() + 1000 * 25);
        array[2] = new Date(System.currentTimeMillis() + 1000 * 30);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }





}

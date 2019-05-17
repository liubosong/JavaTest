package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-09 19:05
 **/
public class Utils {
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] shuffledArray(int len) {
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
}

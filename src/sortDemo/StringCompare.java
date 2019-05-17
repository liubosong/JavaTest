package sortDemo;

import utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 21:17
 **/
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int length1 = o1.length();
        int length2 = o2.length();
        return length1 - length2;
    }

    public static void main(String[] args) {
        String[] strings = {"df", "dfew", "fdf3q", "df", "qw"};
        Utils.bubbleSort(strings, new StringCompare());
        System.out.println(Arrays.toString(strings));
    }
}

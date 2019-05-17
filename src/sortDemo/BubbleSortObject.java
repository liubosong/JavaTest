package sortDemo;

import java.util.ArrayList;

import static utils.Utils.bubbleSort;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 19:25
 **/
public class BubbleSortObject {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("sdf");
        list.add("sdfdf");
        list.add("erw3");
        list.add("fsdwe");
        bubbleSort(list);
        System.out.println(list);

    }


}

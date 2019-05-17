package refType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 15:12
 **/
public class MyList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sdf");
        list.add("sddff");
        list.add("sdsdff");
        list.add("sdewf");
        list.add("sedfdf");
        list.add("sdsdfwef");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("=====");
            System.out.println(iterator.next());
        }
    }
}

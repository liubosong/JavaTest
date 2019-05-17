package refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 10:23
 **/
public class ItemApp {
    public static void main(String[] args) {
        List<NewsItem> list = new ArrayList<>();
        list.add(new NewsItem("Jack", 5000, new Date(System.currentTimeMillis() - 1000 * 60 * 60)));
        list.add(new NewsItem("Rose", 5000, new Date(System.currentTimeMillis() - 1000 * 60 * 60)));
        list.add(new NewsItem("Tom", 5500, new Date(System.currentTimeMillis() - 1000 * 60 * 20)));
        list.add(new NewsItem("Bob", 5900, new Date(System.currentTimeMillis() - 1000 * 60 * 60)));
        list.add(new NewsItem("Tina", 4000, new Date(System.currentTimeMillis() - 1000 * 60 * 120)));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

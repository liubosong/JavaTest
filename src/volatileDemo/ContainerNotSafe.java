package volatileDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-12 16:06
 **/
public class ContainerNotSafe {
    public static void main(String[] args) {
        List<String> objects = Arrays.asList();
        ArrayList<String> strings = new ArrayList<>(objects);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}

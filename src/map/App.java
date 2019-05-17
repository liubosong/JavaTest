package map;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 14:22
 **/
public class App {
    public static void main(String[] args) {
        String fields = "this is a cat and that is a mice and where is the food";
        String[] words = fields.split(" ");
        HashMap<String, Letter> letters = new HashMap<>();
        for (String word : words) {
            if (!letters.containsKey(word)) {
                letters.put(word, new Letter());
            }
            Letter letter = letters.get(word);
            letter.setCount(letter.getCount() + 1);
        }
        Set<String> keys = letters.keySet();
        for (String key : keys) {
            Letter letter = letters.get(key);
            System.out.println(key + "\t" + letter.getCount());
        }
    }
}

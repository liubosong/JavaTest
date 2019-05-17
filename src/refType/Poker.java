package refType;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 13:14
 **/
public class Poker {
    public static void main(String[] args) {
        Person jack = new Person("Jack");
        Person rose = new Person("Rose");
        Person lubai = new Person("Lubai");
        Person last = new Person("剩余");

        ArrayList<Card> pokerS = poker();

        for (int i = 0; i < 54 - 3; i += 3) {
            jack.addCard(pokerS.get(i));

            rose.addCard(pokerS.get(i + 1));

            lubai.addCard(pokerS.get(i + 2));

        }
        last.addCard(pokerS.get(51));
        last.addCard(pokerS.get(52));
        last.addCard(pokerS.get(53));
        System.out.println(jack);
        System.out.println(rose);
        System.out.println(lubai);
        System.out.println(last);
    }

    public static ArrayList<Card> poker() {
        ArrayList<Card> pokers = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            pokers.add(new Card(i + 1));
        }
        Collections.shuffle(pokers);
        return pokers;
    }
}

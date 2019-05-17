package refType;

import java.util.ArrayList;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 13:19
 **/
public class Person {
    private String name;
    private ArrayList<Card> cards;

    public Person(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public Person(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return this.name + "的牌有" + "\t" + this.cards;
    }
}

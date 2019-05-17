package refType;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 13:15
 **/
public class Card {
    private int value;

    public Card() {
        this(1);
    }

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}

package refType;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 14:41
 **/
public class MyStack<E> {
    private Deque<E> container = new ArrayDeque<E>();
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(E e) {
        if (container.size() + 1 > capacity) {
            return false;
        }
        return container.offerLast(e);
    }
}

package myArrayList;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 13:28
 **/


import java.util.Iterator;

/**
 * hasNext
 * next
 * remove
 */
public class MyArrayList implements java.lang.Iterable<String> {
    private String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = elem.length;

    /**
     * n匿名内部类
     *
     * @return
     */
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return cursor < size - 1;
            }

            @Override
            public String next() {
                cursor++;
                return elem[cursor];
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        Iterator<String> iterator = myArrayList.iterator();

    }
}

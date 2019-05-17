package singleton;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-11 19:40
 **/
public class GoUp {
    public static void main(String[] args) {
        int step = loop(40);
        System.out.println(step);
    }

    public static int loop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("台阶数要大于等于1");
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}

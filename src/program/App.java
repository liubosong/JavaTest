package program;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 11:28
 **/
public class App {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Player player = new Player(movie);
        Watcher watcher = new Watcher(movie);
        new Thread(player).start();
        new Thread(watcher).start();
    }
}

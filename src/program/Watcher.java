package program;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 11:29
 **/
public class Watcher implements Runnable {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            movie.consumer();
        }
    }
}

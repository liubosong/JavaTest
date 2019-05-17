package program;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 11:28
 **/
public class Player implements Runnable {
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                movie.product("🐔");
            }else {
                movie.product("🐱");
            }
        }
    }
}

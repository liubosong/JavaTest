package byteCode;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 16:29
 **/
public class App {
    public static void main(String[] args) {
        SplitFile splitFile = new SplitFile("/Users/liubosong/Desktop/Temp/lubai.txt", 64);
        splitFile.split("/Users/liubosong/Desktop/Temp/");
    }
}

package byteCode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 09:06
 **/
public class bufferedRead {
    public static void main(String[] args) throws IOException {
        fun1();
    }

    public static void fun1() throws IOException {
        File file = new File("/Users/liubosong/Desktop/Temp/Poem.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
        bufferedInputStream.close();
    }
}

package byteCode;


import java.io.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 08:21
 **/
public class ByteCode {
    public static void main(String[] args) throws IOException {
        fun1();
    }

    public static void fun1() throws IOException {
        String str = "/Users/liubosong/Desktop/Temp/连城诀.txt";
        String strOut = "/Users/liubosong/Desktop/Temp/连城诀1.txt";

        File file = new File(str);
        File fOut = new File(strOut);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream ops = new FileOutputStream(fOut);
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        OutputStreamWriter opsW = new OutputStreamWriter(ops,"utf-8");
        BufferedReader reader = new BufferedReader(isr);
        BufferedWriter writer = new BufferedWriter(opsW);
        String info = null;
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
            writer.write(info);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}

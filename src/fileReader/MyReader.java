package fileReader;

import java.io.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-28 22:10
 **/
public class MyReader {
    public static void main(String[] args) {
        fun2();
    }

    public static void fun1() {
        String src = "/Users/liubosong/Desktop/Temp/连城诀.txt";
        File srcFile = new File(src);
        int len = 0;
        char[] chars = new char[1024];
        FileReader fr = null;
        try {
            fr = new FileReader(srcFile);
            while ((len = fr.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fun2() {
        String desc = "/Users/liubosong/Desktop/Temp/Poem.txt";
        FileWriter fw = null;
        String s = "大漠孤烟直，长河落日圆。萧关封侯骑，都护在燕然。";
        try {
            fw = new FileWriter(desc, true);
            fw.write(s);
            fw.append(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

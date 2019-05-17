package byteCode;

import java.io.*;
import java.util.Scanner;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 13:33
 **/
public class MyPrintStream {
    public static void main(String[] args) throws IOException {
//        printStream();
//        printFromConsoleToFile();
        randomAccess();
    }

    public static void printStream() throws FileNotFoundException {
        String str = "/Users/liubosong/Desktop/Temp/lubai.txt";
        PrintStream printStream = new PrintStream(new FileOutputStream(new File(str)));
        printStream.println("hello boy fucker");

    }

    public static void printFromConsoleToFile() throws FileNotFoundException {
        String desc = "/Users/liubosong/Desktop/Temp/lubai.txt";
        System.setOut(new PrintStream(new FileOutputStream(new File(desc)), true));
        System.out.println("Good");
        System.out.println("大漠孤烟直，长河落日圆");
    }

    public static void scannerStream() {
        Scanner scanner = new Scanner(System.in);

    }

    public static void randomAccess() throws IOException {
        String str = "/Users/liubosong/Desktop/Temp/lubai.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "r");
        randomAccessFile.seek(310);
        int len = 0;
        byte[] flush = new byte[1024];
        while (-1 != (len = randomAccessFile.read(flush))) {
            if (len <= 30) {
                System.out.println(new String(flush, 0, len));
            } else {
                System.out.println(new String(flush, 0, 30));
                break;
            }
        }
    }
}

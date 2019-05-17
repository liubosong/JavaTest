package byteCode;

import java.io.*;
import java.util.Arrays;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 11:00
 **/
public class ObjectDemo1 {
    public static void main(String[] args) {
        String src = "/Users/liubosong/Desktop/Temp/lubai.txt";
        String desc = "/Users/liubosong/Desktop/Temp/lubai.txt";

        try {
            seri(desc);
            read(src);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void read(String src) throws IOException, ClassNotFoundException {
        File file = new File(src);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        Object object = objectInputStream.readObject();
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            System.out.println(employee.getName() + "\t" + employee.getSalary());
        }
        object = objectInputStream.readObject();
        int[] ints = (int[]) object;
        System.out.println(Arrays.toString(ints));
        objectInputStream.close();
    }

    public static void seri(String descPath) throws IOException {
        Employee lubai = new Employee("lubai", 30000.0);
        int[] arr = {1, 2, 3, 4, 5, 64};
        File file = new File(descPath);
        FileOutputStream fops = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fops);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(lubai);
        objectOutputStream.writeObject(arr);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

}

package map;

import java.util.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 16:10
 **/
public class AppStudent {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        exam(list);
        HashMap<String, ClassRoom> classRooms = new HashMap<>();
        count(classRooms, list);
        Set<String> classNumbers = classRooms.keySet();
        for (String classNumber : classNumbers) {
            ClassRoom classRoom = classRooms.get(classNumber);
            double totalScore = classRoom.getTotalScore();
            double avg = totalScore / classRoom.getStudents().size();
            System.out.println(classRoom.getClassName() + "\t" + totalScore + "\t" + avg);
        }
    }


    public static void count(Map<String, ClassRoom> classRooms, List<Student> list) {
        for (Student student : list) {
            String classNumber = student.getClassNumber();
            double score = student.getScore();
            ClassRoom classRoom = classRooms.get(classNumber);
            if (null == classRoom) {
                classRoom = new ClassRoom(classNumber, score);
                classRooms.put(classNumber, classRoom);
            }
            classRoom.setTotalScore(classRoom.getTotalScore() + score);
            classRoom.getStudents().add(student);
        }
    }


    public static void exam(List<Student> list) {
        list.add(new Student("jack", "1001", 90));
        list.add(new Student("rose", "1002", 95));
        list.add(new Student("tom", "1001", 93));
        list.add(new Student("bob", "1002", 96));
        list.add(new Student("tina", "1001", 98));
        list.add(new Student("lina", "1003", 97));
        list.add(new Student("dog", "1002", 91));
        list.add(new Student("kitty", "1003", 94));
        list.add(new Student("doom", "1003", 93));
        list.add(new Student("lion", "1003", 91));
    }
}

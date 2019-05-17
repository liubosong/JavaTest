package map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 16:16
 **/
public class ClassRoom {
    private String className;
    private double totalScore;
    private List<Student> students;

    public ClassRoom() {
        students = new ArrayList<>();
    }

    public ClassRoom(String className, double totalScore) {
        this();
        this.className = className;
        this.totalScore = totalScore;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

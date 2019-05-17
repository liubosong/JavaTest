package map;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 16:08
 **/
public class Student {
    private String studentName;
    private String classNumber;
    private double score;

    public Student() {
    }

    public Student(String studentName, String classNumber, double score) {
        this.studentName = studentName;
        this.classNumber = classNumber;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

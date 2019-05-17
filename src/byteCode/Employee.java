package byteCode;

import java.io.Serializable;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 10:56
 **/
public class Employee implements Serializable {
    private transient String name;
    private transient double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

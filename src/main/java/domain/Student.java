package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person{
    @Column(name="studentCode")
    private String studentCode;

    public Student() {
    }

    public Student(String studentCode) {
        this.studentCode = studentCode;
    }

    public Student(Integer id, String name, String surname, Integer phoneNumber, String studentCode) {
        super(id, name, surname, phoneNumber);
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                '}';
    }
}

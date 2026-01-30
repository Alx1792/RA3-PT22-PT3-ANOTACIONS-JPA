package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {
    @Column(name="teacherCode")
    private String teacherCode;

    public Teacher() {
    }

    public Teacher(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Teacher(Integer id, String name,  Integer phoneNumber,String surname, String teacherCode) {
        super(id, name, phoneNumber,surname );
        this.teacherCode = teacherCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherCode='" + teacherCode + '\'' +
                '}';
    }
}

package domain;

public class Teacher extends Person {
    private String teacherCode;

    public Teacher(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Teacher(Integer id, String name, String surname, Integer phoneNumber, String teacherCode) {
        super(id, name, surname, phoneNumber);
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

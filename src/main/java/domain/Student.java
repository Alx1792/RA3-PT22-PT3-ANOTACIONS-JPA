package domain;

public class Student extends Person{
    private String studentCode;

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

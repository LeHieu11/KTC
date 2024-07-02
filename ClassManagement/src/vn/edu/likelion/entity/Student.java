package vn.edu.likelion.entity;

import java.time.LocalDate;
import java.util.Random;

public class Student extends Person{

    private String studentId;
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Student(String name, LocalDate birthDate, String idCard) {

        super(name, birthDate, idCard);

        Random ran = new Random();
        studentId = "ID" + String.valueOf(ran.nextInt(10000));
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Student student = (Student) obj;

        return this.getIdCard() == student.getIdCard();
    }

    @Override
    public String toString() {
        return studentId + "\t" + super.toString();
    }
}

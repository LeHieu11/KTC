package vn.edu.likelion.entity;

import java.time.LocalDate;

public class DropedStudent extends Student{
    private String reason;
    
    public DropedStudent(String name, LocalDate birthDate, String idCard) {

        super(name, birthDate, idCard);
    }

    public DropedStudent(Student stu) {

        super(stu.getName(), stu.getBirthDate(), stu.getIdCard());
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

   
}

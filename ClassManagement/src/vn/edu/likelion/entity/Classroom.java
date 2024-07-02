package vn.edu.likelion.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Classroom {
    
    private ArrayList<Student> studentList;
    private ArrayList<Student> archiveStudentList;
    private Person teacher;
    private LocalDate startDate;

    public Classroom() {
        studentList = new ArrayList<>();
        archiveStudentList = new ArrayList<>();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getArchiveStudentList() {
        return archiveStudentList;
    }

    public void setArchiveStudentList(ArrayList<Student> archiveStudentList) {
        this.archiveStudentList = archiveStudentList;
    }

    public void addStudent(Student student) {
        //Phải trong độ tuổi mới thêm
        if (student.getAge() < 18 && student.getAge() > 20){
            return;
        }

        //Lớp đã đầy
        if (studentList.size() >= 10) {
            return;
        }

        studentList.add(student);
    }
    
    public boolean openClass(LocalDate startDate) {
        //Tức là lớp đã mở rồi
        if (this.startDate != null) {
            return false;
        }

        //Chưa đủ số lượng học sinh thì k mở
        if (studentList.size() < 10) {
            return false;
        }

        this.setStartDate(startDate);
        return true;
    }

    //Hàm trả về true nếu drop thành công và ngược lại
    public boolean dropStudent(Student student, String reason) {
        for (Student tmpStu : studentList) {
            //Tìm học sinh đó trong list và đẩy qua danh sách archive
            if (tmpStu.equals(student)) {
                tmpStu.setReason(reason);
                archiveStudentList.add(tmpStu);
                studentList.remove(tmpStu);
                return true;
            }
        }

        return false;
    }

    public boolean updateStudent(String studentId, String name, LocalDate birthday, String idCard) {
        for (Student tmp : studentList) {
            if(tmp.getStudentId().equals(studentId)) {
                tmp.setName(name);
                tmp.setBirthDate(birthday);
                tmp.setIdCard(idCard);

                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer mStringBuffer = new StringBuffer();

        mStringBuffer.append("Teacher: " + teacher.toString() + "\n");
        mStringBuffer.append("Students:\n");

        for (Student tmp : studentList) {
            mStringBuffer.append(tmp.toString() + "\n");
        }

        return mStringBuffer.toString();
    }
}

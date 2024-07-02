package vn.edu.likelion.app;

import java.util.ArrayList;
import java.time.LocalDate;

import vn.edu.likelion.entity.Person;
import vn.edu.likelion.entity.School;
import vn.edu.likelion.entity.Student;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        School mySchool = new School();
        mySchool.addEmptyClassroom();
        mySchool.setTeacherToClassroom(new Person("Tuan", LocalDate.parse("1980-01-01"), "1010101"), 0);
        mySchool.addStudentsToClassroom(getMockData(), 0);

        mySchool.printAllClassroom();
        boolean flag = mySchool.getClassRoomList().get(0).openClass(LocalDate.now());
        if(flag) {
            System.out.println("Mo lop thanh cong");
        }else System.out.println("Mo lop chua duoc");
    }

    public static ArrayList<Student> getMockData() {
        return new ArrayList<Student>(){
            {
                add(new Student("Tan", LocalDate.parse("2007-11-28"), "000001"));
                add(new Student("Anh", LocalDate.parse("2007-10-28"), "000002"));
                add(new Student("Dung", LocalDate.parse("2007-09-28"), "000003"));
                add(new Student("Toan", LocalDate.parse("2007-08-28"), "000004"));
                add(new Student("Hue", LocalDate.parse("2007-11-28"), "000005"));
                add(new Student("Nguyen", LocalDate.parse("2007-10-28"), "000006"));
                add(new Student("Hieu", LocalDate.parse("2007-09-28"), "000007"));
                add(new Student("Nam", LocalDate.parse("2007-08-28"), "000008"));
                add(new Student("Thang", LocalDate.parse("2007-09-28"), "000009"));
                add(new Student("Trinh", LocalDate.parse("2007-08-28"), "000010"));
            }
        };
    }
}
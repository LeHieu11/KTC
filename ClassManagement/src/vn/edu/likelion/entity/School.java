package vn.edu.likelion.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class School {
    private ArrayList<Classroom> classRoomList;

    public School() {
        classRoomList = new ArrayList<>();
    }

    public ArrayList<Classroom> getClassRoomList() {
        return classRoomList;
    }

    public void setClassRoomList(ArrayList<Classroom> classRoomList) {
        this.classRoomList = classRoomList;
    }
    
    public void addClassroom(Classroom classRoom) {
        if (classRoomList.size() < 3) {
            classRoomList.add(classRoom);
        }
    }

    public void addEmptyClassroom() {
        if (classRoomList.size() < 3) {
            classRoomList.add(new Classroom());
        }
    }

    public void addStudentsToClassroom(ArrayList<Student> studentList, int classIndex) {
        for (Student tmp : studentList) {
            classRoomList.get(classIndex).addStudent(tmp);
        } 
    }

    private int countTeacherClassroom(Person teacher) {
        int count = 0;
        for (Classroom classroom : classRoomList) {
            if (classroom.getTeacher() == null) {
                continue;
            }

            if (classroom.getTeacher().equals(teacher)) {
                count++;
            }
        }

        return count;
    }

    public void setTeacherToClassroom(Person teacher, int classIndex) {
        if (countTeacherClassroom(teacher) >= 2) {
            return;
        }

        classRoomList.get(classIndex).setTeacher(teacher);
    }

    public void updateStudent(String studentId, String name, LocalDate birthday, String idCard,
    int classIndex){
        Classroom choosen = classRoomList.get(classIndex);
        choosen.updateStudent(studentId, name, birthday, idCard);
    }

    public Student getStudentByStudentId(String studentId) {
        for (Classroom classroom : classRoomList) {
            for (Student stu : classroom.getStudentList()) {
                if (stu.getStudentId().equals(studentId)) {
                    return stu;
                }
            }
        }

        return null;
    }

    public void printAllClassroom() {
        for (Classroom tmpClass : classRoomList) {
            System.out.println(tmpClass);
        }
    }
}

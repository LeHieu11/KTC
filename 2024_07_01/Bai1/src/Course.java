import java.util.ArrayList;

/**
 * Course
 */
public class Course {

    int courseID;
    String courseName;
    String mentorName;
    int credit;
    ArrayList<Student> students = new ArrayList<>();

    public Course() {
  
    }

    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayDetailCourse() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return courseID + "\t" + courseName + "\t" + 
        mentorName + "\t" + credit;
    }
}
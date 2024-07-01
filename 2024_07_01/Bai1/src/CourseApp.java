import java.util.ArrayList;

public class CourseApp {
    static String longLine = "----------------------------------------------------------------------------------";

    public static void main(String[] args) throws Exception {
        ArrayList<Course> courses = new ArrayList<>();

        Course tmpCourse = new Course();
        tmpCourse.courseID = 1;
        tmpCourse.courseName = "course 1";
        tmpCourse.credit = 10;
        tmpCourse.mentorName = "mentor 1";
        tmpCourse.students.add(new Student("HS1"));
        tmpCourse.students.add(new Student("HS2"));
        courses.add(tmpCourse);

        CourseOnline tmpCourseOnline = new CourseOnline();
        tmpCourseOnline.courseID = 2;
        tmpCourseOnline.courseName = "course 2";
        tmpCourseOnline.credit = 22;
        tmpCourseOnline.mentorName = "mentor 2";
        tmpCourseOnline.nenTang = "Zalo";
        tmpCourseOnline.thoiLuong = 3;
        tmpCourseOnline.students.add(new Student("HS3"));
        tmpCourseOnline.students.add(new Student("HS4"));
        courses.add(tmpCourseOnline);

        for (Course course : courses) {
            course.displayDetailCourse();
            course.displayStudent();
            System.out.println(longLine);
        }
    }
}

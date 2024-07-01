public class CourseOnline extends Course {
    
    String nenTang;
    int thoiLuong; //n month

    public CourseOnline() {
        
    }

    @Override
    public void displayDetailCourse() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + nenTang + 
        "\t" + thoiLuong;
    }

}

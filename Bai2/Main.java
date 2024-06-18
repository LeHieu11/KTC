public class Main {
    public static void main(String[] args) {
        Employee mEmployee = new Employee();
        HRManager mHrManager = new HRManager();

        mEmployee.work();
        System.out.println("Employee salary: " + mEmployee.getSalary());

        mHrManager.work();
        System.out.println("Manager salary: " + mHrManager.getSalary());
        mHrManager.addEmployee();
    }
}

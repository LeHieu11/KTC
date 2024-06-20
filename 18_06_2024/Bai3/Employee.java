public class Employee {
    protected String name;
    protected double salary;
    protected String address;
    protected String position;
    
    public Employee(){
        
    }

    public Employee(String name, double salary, String address){
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.position = "Employee";
    }

    /*
     * Lazy 
     */
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.position = "Employee";
    }

    public void work(){
        System.out.println("Working as employeee");
    }

    public double getSalary(){
        return this.salary;
    }

    public void performanceReport(String rating){
        System.out.println("Performance report for " + this.position
        + " " + this.name + ": " + rating);
    }
}

public class Employee {
    protected int salary;

    public Employee(){
        this.salary = 40000;
    }

    public Employee(int salary){
        this.salary = salary;
    }

    public void work(){
        System.out.println("Working as employeee");
    }

    public int getSalary(){
        return this.salary;
    }
}

public class HRManager extends Employee {

    public HRManager(){
        super(70000);
    }

    @Override
    public void work(){
        System.out.println("Managing employees.");
    }

    public void addEmployee(){
        System.out.println("Adding new employee!");
    }
}
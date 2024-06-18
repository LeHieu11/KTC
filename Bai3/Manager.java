public class Manager extends Employee{
    
    private double bonus = 12000.0;
    
    public Manager(String name, double salary){
        super(name, salary);
        this.position = "Manager";
    }

    @Override
    public void work(){
        System.out.println(this.position + " " + 
        this.name + "is managing a project");
    }

    public double getBonus(){
        return this.bonus;
    }
    
}

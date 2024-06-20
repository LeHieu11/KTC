public class Developer extends Employee{

    private double bonus = 7200.0;
    
    public Developer(String name, double salary){
        super(name, salary);
        this.position = "Developer";
    }

    @Override
    public void work(){
        System.out.println(this.position + " " + 
        this.name + "is writing a code in java");
    }

    public double getBonus(){
        return this.bonus;
    }

    @Override
    public double getSalary(){
        return this.salary + bonus;
    }

}

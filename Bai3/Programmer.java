public class Programmer extends Employee{
    private double bonus = 9210.0;
    
    public Programmer(String name, double salary){
        super(name, salary);
        this.position = "Programmer";
    }

    @Override
    public void work(){
        System.out.println(this.position + " " + 
        this.name + "is debugging code in python");
    }

    public double getBonus(){
        return this.bonus;
    }
}

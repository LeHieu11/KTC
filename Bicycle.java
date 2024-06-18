public class Bicycle extends Vehicle{
    
    public Bicycle(){
        this.speed = 0;
    }

    @Override
    public void speedUp(){
        this.speed += 1;
    }
}

public class Car extends Vehicle {

    public Car(){
        this.speed = 0;
    }

    @Override
    public void speedUp(){
        this.speed += 10;
    }
}
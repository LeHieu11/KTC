import java.util.Random;

public abstract class Vehicle {
    protected String name;
    protected final int ID;
    static int vehicleCount = 0;

    public Vehicle(){
        Random ran = new Random();
        ID = ran.nextInt(100);
        vehicleCount++;
    }

    public void move(){}
}

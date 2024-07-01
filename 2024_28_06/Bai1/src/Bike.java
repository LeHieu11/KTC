public class Bike extends Vehicle{
    private boolean hasGear;

    public boolean isHasGear() {
        return hasGear;
    }

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    @Override
    public void move() {
        System.out.println("Bike is moving");;
    }
}

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String fuelType;
    protected double distanceTravel;
    protected double maxSpeed;
    protected double fuelEfficiency;

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    /*
     * Lazy
     */
    public Vehicle(String model){
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getDistanceTravel() {
        return distanceTravel;
    }

    public void setDistanceTravel(double distanceTravel) {
        this.distanceTravel = distanceTravel;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void lazyPrint(){
        System.out.println("Truck model: " + this.model);
        System.out.println("Fuel Efficiency: " + this.fuelEfficiency + " mpg");
        System.out.println("Distance Travel: " + this.distanceTravel + "miles");
        System.out.println("Max Speed: " + this.maxSpeed + " mph");
    }
}

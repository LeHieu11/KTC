public class Main {
    public static void main(String[] args) {
        Truck mTruck = new Truck("Tatra 810 4x4");
        mTruck.setMaxSpeed(88.0);
        mTruck.setFuelEfficiency(8.0756);
        mTruck.setDistanceTravel(65.509);
        mTruck.lazyPrint();

        System.out.println();

        Car mCar = new Car("Virtus");
        mCar.setMaxSpeed(120.0);
        mCar.setFuelEfficiency(2.355);
        mCar.setDistanceTravel(14.419);
        mCar.lazyPrint();

        System.out.println();

        Motorcycle mMotor = new Motorcycle("Warrior200");
        mMotor.setMaxSpeed(80.0);
        mMotor.setFuelEfficiency(2.1);
        mMotor.setDistanceTravel(4.41);
        mMotor.lazyPrint();
    }
}

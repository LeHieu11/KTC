public class VehicleDemo {
    public static void main(String[] args) throws Exception {
        Vehicle[] vehicles = {
            new Car(),
            new Bike()
        } ;

        for (Vehicle vehicle : vehicles) {
            System.out.print("ID: " + vehicle.ID + "\t\t");
            vehicle.move();
        }

        System.out.println(Vehicle.vehicleCount);
    }
}

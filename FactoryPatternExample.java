package session09;

import session07.Vehicle;

public class FactoryPatternExample {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle carObj = vehicleFactory.getVehicle("Car");
        carObj.move();
        Vehicle truckObj = vehicleFactory.getVehicle("Truck");
        truckObj.move();
    }
}

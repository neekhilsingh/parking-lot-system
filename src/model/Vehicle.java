package model;

public class Vehicle {

    private String vehicleNumber;
    private String vehicleType; // CAR, BIKE, TRUCK

    // Constructor
    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    // Getter
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    // Setter
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    // Getter
    public String getVehicleType() {
        return vehicleType;
    }

    // Setter
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
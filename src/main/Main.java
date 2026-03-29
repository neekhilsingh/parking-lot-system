package main;

import model.Vehicle;
import model.ParkingSlot;
import model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create parking slots
        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot(1, "CAR"));
        slots.add(new ParkingSlot(2, "BIKE"));
        slots.add(new ParkingSlot(3, "TRUCK"));

        // Create parking lot
        ParkingLot parkingLot = new ParkingLot(slots);

        // Create a vehicle
        Vehicle vehicle = new Vehicle("MP04AB1234", "CAR");

        // Print basic info
        System.out.println("Parking Lot Created with Slots: " + parkingLot.getParkingSlots().size());
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Vehicle Type: " + vehicle.getVehicleType());
    }
}
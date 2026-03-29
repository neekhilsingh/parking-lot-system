package model;

import java.util.List;

public class ParkingLot {

    private List<ParkingSlot> parkingSlots;

    // Constructor
    public ParkingLot(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    // Getter
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    // Add a slot
    public void addSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }
}
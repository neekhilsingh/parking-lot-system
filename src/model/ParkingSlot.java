package model;

public class ParkingSlot {

    private int slotId;
    private String slotType; // CAR, BIKE, TRUCK
    private boolean isOccupied;

    // Constructor
    public ParkingSlot(int slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false; // initially free
    }

    // Getter
    public int getSlotId() {
        return slotId;
    }

    // Getter
    public String getSlotType() {
        return slotType;
    }

    // Getter
    public boolean isOccupied() {
        return isOccupied;
    }

    // Setter
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
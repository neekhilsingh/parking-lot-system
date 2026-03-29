package model;

public class ParkingSlot {

    private int slotId;
    private String slotType;
    private boolean isOccupied;

    public ParkingSlot(int slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
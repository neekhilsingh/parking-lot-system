package model;

public class Ticket {

    private int ticketId;
    private String vehicleNumber;
    private int slotId;
    private long entryTime;
    private long exitTime;

    public Ticket(int ticketId, String vehicleNumber, int slotId, long entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.slotId = slotId;
        this.entryTime = entryTime;
        this.exitTime = 0;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getSlotId() {
        return slotId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
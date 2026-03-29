package model;

public class Ticket {

    private int ticketId;
    private String vehicleNumber;
    private long entryTime;
    private long exitTime;

    // Constructor
    public Ticket(int ticketId, String vehicleNumber, long entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = 0; // initially 0 (vehicle not exited yet)
    }

    // Getter
    public int getTicketId() {
        return ticketId;
    }

    // Getter
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    // Getter
    public long getEntryTime() {
        return entryTime;
    }

    // Getter
    public long getExitTime() {
        return exitTime;
    }

    // Setter for exit time
    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
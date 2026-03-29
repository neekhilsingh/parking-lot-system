package model;

public class Ticket {

    private int ticketId;
    private String vehicleNumber;
    private long entryTime;
    private long exitTime;

    public Ticket(int ticketId, String vehicleNumber, long entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = 0;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
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
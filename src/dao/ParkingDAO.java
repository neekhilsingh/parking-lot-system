package dao;

import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingDAO {

    private List<Ticket> tickets = new ArrayList<>();

    // Save ticket (when vehicle enters)
    public void saveTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    // Find ticket by vehicle number
    public Ticket getTicketByVehicleNumber(String vehicleNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getVehicleNumber().equals(vehicleNumber)) {
                return ticket;
            }
        }
        return null;
    }

    // Update exit time
    public void updateExitTime(String vehicleNumber, long exitTime) {
        Ticket ticket = getTicketByVehicleNumber(vehicleNumber);
        if (ticket != null) {
            ticket.setExitTime(exitTime);
        }
    }
}
package dao;

import model.Ticket;
import java.util.ArrayList;
import java.util.List;

public class ParkingDAO {

    private List<Ticket> tickets = new ArrayList<>();

    public void saveTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket getTicketByVehicleNumber(String vehicleNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getVehicleNumber().equals(vehicleNumber)) {
                return ticket;
            }
        }
        return null;
    }
}
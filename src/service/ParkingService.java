package service;

import model.*;
import dao.ParkingDAO;

import java.util.List;

public class ParkingService {

    private ParkingLot parkingLot;
    private ParkingDAO parkingDAO;
    private int ticketCounter = 1;

    // Constructor
    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingDAO = new ParkingDAO();
    }

    // Park Vehicle
    public void parkVehicle(Vehicle vehicle) {

        List<ParkingSlot> slots = parkingLot.getParkingSlots();

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.getSlotType().equals(vehicle.getVehicleType())) {

                slot.setOccupied(true);

                Ticket ticket = new Ticket(ticketCounter++, vehicle.getVehicleNumber(), System.currentTimeMillis());

                parkingDAO.saveTicket(ticket);

                System.out.println("Vehicle Parked in Slot: " + slot.getSlotId());
                System.out.println("Ticket ID: " + ticket.getTicketId());

                return;
            }
        }

        System.out.println("No available slot for this vehicle type");
    }

    // Remove Vehicle
    public void removeVehicle(String vehicleNumber) {

        Ticket ticket = parkingDAO.getTicketByVehicleNumber(vehicleNumber);

        if (ticket == null) {
            System.out.println("Vehicle not found");
            return;
        }

        ticket.setExitTime(System.currentTimeMillis());

        // Free the slot
        for (ParkingSlot slot : parkingLot.getParkingSlots()) {
            if (slot.isOccupied()) {
                slot.setOccupied(false);
                break;
            }
        }

        System.out.println("Vehicle Removed. Ticket ID: " + ticket.getTicketId());
    }
}
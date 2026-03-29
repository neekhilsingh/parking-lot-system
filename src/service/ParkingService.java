package service;

import model.*;
import dao.ParkingDAO;

import java.util.List;

public class ParkingService {

    private ParkingLot parkingLot;
    private ParkingDAO parkingDAO;
    private int ticketCounter = 1;

    public ParkingService(ParkingLot parkingLot, ParkingDAO parkingDAO) {
        this.parkingLot = parkingLot;
        this.parkingDAO = parkingDAO;
    }

    public void parkVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            System.out.println("Invalid vehicle");
            return;
        }

        List<ParkingSlot> slots = parkingLot.getParkingSlots();

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.getSlotType().equals(vehicle.getVehicleType())) {

                slot.setOccupied(true);

                Ticket ticket = new Ticket(ticketCounter++, vehicle.getVehicleNumber(), slot.getSlotId(), System.currentTimeMillis());

                parkingDAO.saveTicket(ticket);

                System.out.println("Vehicle Parked in Slot: " + slot.getSlotId());
                System.out.println("Ticket ID: " + ticket.getTicketId());

                return;
            }
        }

        System.out.println("No available slot");
    }

    public void removeVehicle(String vehicleNumber) {

        Ticket ticket = parkingDAO.getTicketByVehicleNumber(vehicleNumber);

        if (ticket == null) {
            System.out.println("Vehicle not found");
            return;
        }

        ticket.setExitTime(System.currentTimeMillis());

        for (ParkingSlot slot : parkingLot.getParkingSlots()) {
            if (slot.getSlotId() == ticket.getSlotId()) {
                slot.setOccupied(false);
                break;
            }
        }

        System.out.println("Vehicle Removed");
    }
}
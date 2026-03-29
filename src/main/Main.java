package main;

import model.*;
import service.*;
import dao.ParkingDAO;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // Fix ₹ and other Unicode symbols on Windows console
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot(1, "CAR"));
        slots.add(new ParkingSlot(2, "BIKE"));
        slots.add(new ParkingSlot(3, "TRUCK"));

        ParkingLot parkingLot = new ParkingLot(slots);

        ParkingDAO dao = new ParkingDAO();

        ParkingService service = new ParkingService(parkingLot, dao);
        BillingService billingService = new BillingService();

        Vehicle v1 = new Vehicle("MP04AB1234", "CAR");

        service.parkVehicle(v1);

        service.removeVehicle("MP04AB1234");

        Ticket ticket = dao.getTicketByVehicleNumber("MP04AB1234");

        if (ticket != null) {
            double bill = billingService.calculateBill(ticket);
            System.out.println("Total Bill: ₹" + bill);
        }
    }
}
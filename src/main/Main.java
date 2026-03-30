package main;

import model.*;
import service.*;
import dao.ParkingDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // ── Setup: 6 slots (2 CAR, 2 BIKE, 2 TRUCK) ──────────────────────────
        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot(1, "CAR"));
        slots.add(new ParkingSlot(2, "CAR"));
        slots.add(new ParkingSlot(3, "BIKE"));
        slots.add(new ParkingSlot(4, "BIKE"));
        slots.add(new ParkingSlot(5, "TRUCK"));
        slots.add(new ParkingSlot(6, "TRUCK"));

        ParkingLot parkingLot = new ParkingLot(slots);
        ParkingDAO dao        = new ParkingDAO();
        ParkingService service       = new ParkingService(parkingLot, dao);
        BillingService billingService = new BillingService();

        // ── Vehicles ───────────────────────────────────────────────────────────
        Vehicle v1 = new Vehicle("MP04AB1234", "CAR");
        Vehicle v2 = new Vehicle("DL01XY5678", "BIKE");
        Vehicle v3 = new Vehicle("MH12CD9999", "TRUCK");
        Vehicle v4 = new Vehicle("KA03EF4321", "CAR");
        Vehicle v5 = new Vehicle("UP16GH7654", "BIKE");

        System.out.println("=========================================");
        System.out.println("       PARKING LOT SYSTEM - DEMO        ");
        System.out.println("=========================================\n");

        // ── Park all vehicles ──────────────────────────────────────────────────
        System.out.println("--- PARKING VEHICLES ---");
        service.parkVehicle(v1);
        service.parkVehicle(v2);
        service.parkVehicle(v3);
        service.parkVehicle(v4);
        service.parkVehicle(v5);

        // Simulate some time passing (2 seconds) so billing is non-zero
        System.out.println("\n[Simulating time passing...]\n");
        Thread.sleep(2000);

        // ── Remove all vehicles ────────────────────────────────────────────────
        System.out.println("--- REMOVING VEHICLES ---");
        service.removeVehicle("MP04AB1234");
        service.removeVehicle("DL01XY5678");
        service.removeVehicle("MH12CD9999");
        service.removeVehicle("KA03EF4321");
        service.removeVehicle("UP16GH7654");

        // ── Billing ────────────────────────────────────────────────────────────
        System.out.println("\n--- BILLING SUMMARY ---");
        String[] vehicleNumbers = {
            "MP04AB1234", "DL01XY5678", "MH12CD9999", "KA03EF4321", "UP16GH7654"
        };

        double totalRevenue = 0;
        for (String vNum : vehicleNumbers) {
            Ticket ticket = dao.getTicketByVehicleNumber(vNum);
            if (ticket != null) {
                double bill = billingService.calculateBill(ticket);
                totalRevenue += bill;
                System.out.println("Vehicle: " + vNum
                        + " | Slot: " + ticket.getSlotId()
                        + " | Bill: Rs. " + String.format("%.2f", bill));
            }
        }

        System.out.println("\n=========================================");
        System.out.println("  TOTAL REVENUE COLLECTED: Rs. " + String.format("%.2f", totalRevenue));
        System.out.println("=========================================");
    }
}
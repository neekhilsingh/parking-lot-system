package service;

import model.Ticket;

public class BillingService {

    private static final double RATE_PER_HOUR = 10.0; // ₹10 per hour

    public double calculateBill(Ticket ticket) {

        if (ticket.getExitTime() == 0) {
            System.out.println("Vehicle has not exited yet");
            return 0;
        }

        long duration = ticket.getExitTime() - ticket.getEntryTime();

        // convert milliseconds to hours
        double hours = duration / (1000.0 * 60 * 60);

        // minimum 1 hour charge
        if (hours < 1) {
            hours = 1;
        }

        return hours * RATE_PER_HOUR;
    }
}
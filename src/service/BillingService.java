package service;

import model.Ticket;

public class BillingService {

    private static final double RATE_PER_HOUR = 10.0;

    public double calculateBill(Ticket ticket) {

        if (ticket.getExitTime() == 0) {
            System.out.println("Vehicle not exited yet");
            return 0;
        }

        long duration = ticket.getExitTime() - ticket.getEntryTime();

        double hours = Math.ceil(duration / (1000.0 * 60 * 60));

        return hours * RATE_PER_HOUR;
    }
}
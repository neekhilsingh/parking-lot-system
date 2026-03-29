# Parking Lot Management System

A Java console app that handles the basic flow of a parking lot — vehicles in, slot assigned, ticket out, bill on exit. Made this as a BYOP submission for Programming in Java at VIT Bhopal University.

---

## Why I built it this way

The parking lot problem shows up in every DSA list and most people solve it as a flat script — one class, a bunch of if-else, done. I wanted to see what it looks like when you actually separate concerns properly. So there is a model layer, a service layer, and a DAO layer, each doing its own thing. It made the code longer but also made it obvious where to go when something needed changing.

The other thing I cared about was making the data layer swappable. Right now everything sits in ArrayLists. But the DAO is isolated enough that adding real DB support later means touching one file, not rewriting half the project. The schema is already written too, so that work is mostly done.

---

## What it actually does

A vehicle comes in. The system checks what type it is (Car, Bike, or Truck), finds a free slot that fits, and hands back a ticket with the entry time on it. When the same vehicle leaves, the system pulls up the ticket, figures out how long it was parked, calculates the charge, and opens up the slot again.

Nothing fancy, but the full loop works.

---

## Features

- Car, Bike, Truck support with separate slot logic
- Slot allocated on entry, freed on exit
- Ticket generated per vehicle with entry timestamp
- Bill calculated at exit based on actual duration
- In-memory storage using ArrayList (DAO layer ready for DB swap)
- Clean package structure: model → service → dao → util

---

## Requirements

Java 8 or above. That is it, no external libraries needed.

```bash
java -version
```

---

## Running it

```bash
git clone https://github.com/neekhilsingh/parking-lot-system.git
cd parking-lot-system
```

```bash
javac -d . src/main/Main.java
```

```bash
java main.Main
```

---

## Folder layout

```
parking-lot-system/
│
├── src/
│   ├── main/
│   │   └── Main.java                 starts everything
│   ├── model/
│   │   ├── Vehicle.java              vehicle type + registration
│   │   ├── ParkingSlot.java          slot state and occupancy
│   │   ├── Ticket.java               links vehicle to slot, holds entry time
│   │   └── ParkingLot.java           manages the full slot collection
│   ├── service/
│   │   ├── ParkingService.java       handles park and exit end to end
│   │   └── BillingService.java       takes a ticket, returns the charge
│   ├── dao/
│   │   └── ParkingDAO.java           reads and writes to storage
│   └── util/
│       └── DBConnection.java         db setup for when that gets added
│
├── database/
│   └── schema.sql
├── README.md
└── .gitignore
```

---

## How the pieces connect

`Main` sets up the lot and kicks off the flow. `ParkingService` is the one doing the actual work — it calls into the model classes to check slot availability, creates the ticket, and calls `BillingService` on exit to get the charge. `ParkingDAO` handles anything that touches storage so the service layer never knows if it is talking to an ArrayList or a database.

---

## Things left to do

- Wire up the actual JDBC connection, the stub and schema are already there
- Slot tracking is a bit loose right now — it does not pin down exact slot IDs reliably
- No concurrency support yet, two vehicles entering at the same time would be a problem
- A simple menu interface would make it easier to use without reading the code

---

## Course details

**Course:** Programming in Java  
**Submission type:** BYOP (Bring Your Own Project)  
**Name:** Neekhil Kumar Singh  
**Registration No:** 24BAI10907  
**Institution:** VIT Bhopal University

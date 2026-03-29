# Parking Lot Management System

A Java console application that simulates how vehicles move through a parking lot — entry, slot allocation, ticket generation, and billing on exit.

Built as a BYOP (Bring Your Own Project) submission for the Programming in Java course at VIT Bhopal University.

---

## Why this approach

The parking lot problem appears in almost every DSA list, and most implementations treat it as a quick script — one class, many conditionals, and done.

This project takes a more structured approach by separating responsibilities into different layers:

* **Model layer** → represents data
* **Service layer** → handles business logic
* **DAO layer** → manages data access

This makes the code easier to understand, maintain, and extend.

Another key focus was flexibility in the data layer. Currently, data is stored using `ArrayList`, but the DAO layer is isolated enough to allow easy integration of a real database later. The database schema is already included, so most of that setup is prepared.

---

## What the system does

### When a vehicle enters:

* The system identifies its type (Car, Bike, or Truck)
* A suitable available slot is assigned
* A ticket is generated with the entry time

### When the vehicle exits:

* The ticket is retrieved
* Parking duration is calculated
* Charges are computed based on time
* The slot is freed for future use

---

## Features

* Supports Car, Bike, and Truck with separate slot handling
* Automatic slot allocation on entry and release on exit
* Ticket generation with entry timestamp
* Billing based on actual parking duration
* In-memory storage using `ArrayList`
* DAO layer designed for easy database integration
* Clean package structure: `model → service → dao → util`

---

## Requirements

* Java 8 or above
* No external dependencies required

Check your Java version:

```bash
java -version
```

---

## Running the project

### Clone the repository:

```bash
git clone https://github.com/neekhilsingh/parking-lot-system.git
cd parking-lot-system
```

### Compile:

```bash
javac -d . src/main/Main.java
```

### Run:

```bash
java main.Main
```

---

## Project structure

```plaintext
parking-lot-system/
│
├── src/
│  ├── main/
│  │  └── Main.java              entry point of the application
│  ├── model/
│  │  ├── Vehicle.java           vehicle type and registration
│  │  ├── ParkingSlot.java       slot state and occupancy
│  │  ├── Ticket.java            links vehicle, slot, and entry time
│  │  └── ParkingLot.java        manages all parking slots
│  ├── service/
│  │  ├── ParkingService.java    handles entry and exit operations
│  │  └── BillingService.java    calculates parking charges
│  ├── dao/
│  │  └── ParkingDAO.java        handles data storage
│  └── util/
│    └── DBConnection.java       placeholder for database setup
│
├── database/
│  └── schema.sql
├── README.md
└── .gitignore
```

---

## How the pieces work together

* `Main` initializes the system and starts execution
* `ParkingService` handles parking and exit operations
* `BillingService` calculates the parking charges
* `ParkingDAO` manages data storage and retrieval

This separation ensures that the service layer does not depend on how data is stored internally.

---

## Future improvements

* Integrate a real JDBC database connection
* Improve slot tracking accuracy
* Add concurrency support for handling multiple vehicles
* Implement a menu-driven interface for better usability

---

## Course details

* Course: Programming in Java
* Submission Type: BYOP (Bring Your Own Project)
* Name: Neekhil Kumar Singh
* Registration No: 24BAI10907
* Institution: VIT Bhopal University

---

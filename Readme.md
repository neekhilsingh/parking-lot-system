# Parking Lot Management System (Java)

## Project Overview

This project is a simple Parking Lot Management System built using Java. It simulates how vehicles are parked, how parking slots are managed, and how billing is calculated based on the time a vehicle stays in the parking lot.

The main goal of this project is to understand and apply core programming concepts such as Object-Oriented Programming (OOP), collections, and basic system design.

---

## Features

* Park vehicles based on type (Car, Bike, Truck)
* Allocate parking slots dynamically
* Generate a ticket for each vehicle entry
* Track entry and exit time
* Calculate parking charges based on duration
* Organized code structure using packages

---

## Project Structure

```plaintext
parking-lot-system/
│
├── src/
│   ├── main/
│   │   └── Main.java
│   │
│   ├── model/
│   │   ├── Vehicle.java
│   │   ├── ParkingSlot.java
│   │   ├── Ticket.java
│   │   └── ParkingLot.java
│   │
│   ├── service/
│   │   ├── ParkingService.java
│   │   └── BillingService.java
│   │
│   ├── dao/
│   │   └── ParkingDAO.java
│   │
│   └── util/
│       └── DBConnection.java
│
├── database/
│   └── schema.sql
│
├── README.md
└── .gitignore
```

---

## Technologies Used

* Java (Core Java)
* Object-Oriented Programming
* Java Collections (List, ArrayList)
* JDBC (for future database integration)
* Git and GitHub

---

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/neekhilsingh/parking-lot-system.git
```

2. Move into the project directory:

```bash
cd parking-lot-system
```

3. Compile the code:

```bash
javac -d . src/main/Main.java
```

4. Run the application:

```bash
java main.Main
```

---

## Concepts Used

### Object-Oriented Programming

The project is structured using classes like Vehicle, ParkingSlot, Ticket, and ParkingLot. It follows encapsulation and modular design.

### Collections

ArrayList is used to manage parking slots and store ticket data in memory.

### Layered Design

* Model: Represents data (Vehicle, Ticket, etc.)
* Service: Contains business logic (parking, billing)
* DAO: Handles data storage (currently in memory)

### Exception Handling

Basic exception handling is included in the database connection class.

---

## Future Improvements

* Connect the system to a real database using JDBC
* Improve slot allocation logic to track exact slot usage
* Add support for multiple vehicles entering at the same time using multithreading
* Create a user interface for better interaction

---

## Author

Neekhil Kumar Singh
24BAI10907

---

## Conclusion

This project helped in understanding how a real-world system can be designed using Java. It also provided hands-on experience with structuring code, managing data, and implementing basic backend logic.

---

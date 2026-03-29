CREATE DATABASE IF NOT EXISTS parking_lot;

USE parking_lot;

-- Table to store tickets
CREATE TABLE ticket (
    ticket_id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_number VARCHAR(20) NOT NULL,
    entry_time BIGINT NOT NULL,
    exit_time BIGINT
);

-- Table to store parking slots
CREATE TABLE parking_slot (
    slot_id INT PRIMARY KEY,
    slot_type VARCHAR(10),
    is_occupied BOOLEAN
);
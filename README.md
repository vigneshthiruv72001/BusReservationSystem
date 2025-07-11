# 🚌 Bus Reservation System (JDBC + MySQL + Java)

This is a simple **Bus Reservation System** built using **Java**, **JDBC**, and **MySQL**. It allows users to book seats, view available buses, cancel bookings, and manage bus information via a command-line interface.

---

## 🔧 Technologies Used

- Java (JDK 8+)
- JDBC (Java Database Connectivity)
- MySQL (Database)
- Git (Version Control)
- Eclipse / VS Code (IDE)

---

## 📁 Features

- ✅ Add new buses with details like driver, route, AC, duration, and capacity
- 🧍 Passenger booking with seat availability check
- ❌ Cancel a booking using `booking ID`
- 📅 Filter and display available buses by travel date
- 🪑 Prevent double-booking seats
- 📄 View all bus details and real-time seat availability

---

## 📦 Project Structure

BusReservationSystem/
│
├── src/
│ └── BusResv/
│ ├── BusDemo.java # Main menu & driver class
│ ├── Bus.java # Bus model
│ ├── Booking.java # Booking model with date handling
│ ├── BookingDAO.java # Booking DB operations (insert, count, cancel)
│ ├── BusDAO.java # Bus DB operations (display, capacity)
│ ├── Passenger.java # Passenger details model
│ └── DbConnection.java # MySQL DB connection handler

sql
---

## 🗃️ MySQL Database Setup

1. Create a database and tables:

sql
CREATE DATABASE busresv;
USE busresv;

CREATE TABLE bus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ac INT,
    capacity INT,
    driver_name VARCHAR(50),
    `from` VARCHAR(50),
    `to` VARCHAR(50),
    duration VARCHAR(50)
);

CREATE TABLE booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_name VARCHAR(50),
    bus_no INT,
    travel_date DATE
);

SAmple OUTPUT:
Enter 1 to Book
Enter 2 to Cancel Booking
Enter 3 to Add New Bus
Enter 4 to Exit


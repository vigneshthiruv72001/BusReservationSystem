//package BusResv;
//import java.util.*;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//public class Booking {
//	public Passenger passenger;
//	public int busNo;
//	public Date date;
//
//	public Booking(Passenger passenger, int busNo, Date date) {
//        this.passenger = passenger;
//        this.busNo = busNo;
//        this.date = date;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the name of the passenger: ");
//		passengerName= scanner.next();
//		System.out.println("Enter Bus no: ");
//		busNo=scanner.nextInt();
//		System.out.println("Enter date dd-mm-yyyy: ");
//		String dateInput = scanner.next();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		
//		try {
//			date = dateFormat.parse(dateInput);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
//	public boolean isAvailble() throws SQLException {
//		BusDAO busdao = new BusDAO();
//		BookingDAO bookingdao =new BookingDAO();
//		
//		int capacity = busdao.getCapacity(busNo);
//		
//		int booked = bookingdao.getBookedCount(busNo,date);
//		
//		
//		return booked<capacity;
//		
//		
//	}
//}

package BusResv;

import java.util.Date;

public class Booking {
    public Passenger passenger;
    public int busNo;
    public Date date;
    public int seatNo; // optional if using seat booking

    public Booking(Passenger passenger, int busNo, Date date, int seatNo) {
        this.passenger = passenger;
        this.busNo = busNo;
        this.date = date;
        this.seatNo = seatNo;
    }

    // Without seat number
    public Booking(Passenger passenger, int busNo, Date date) {
        this.passenger = passenger;
        this.busNo = busNo;
        this.date = date;
    }
}


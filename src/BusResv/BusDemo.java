package BusResv;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
//import java.util.ArrayList;
//import java.sql.SQLException;
import java.util.Date;

public class BusDemo {
	public static void main(String [] args)  {
		BusDAO busdao = new BusDAO();
//		Passenger passenger = new Passenger();
		
		try {
//			busdao.displayBusInfo();
	
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
			
		
			while(userOpt<4) {
				System.out.println("Enter 1 to book \nEnter 2 cancel the booking \nEnter 3 to add New Bus and Details \n4 to exit");
				userOpt = scanner.nextInt();
				if(userOpt ==1){
					System.out.print("Enter passenger name: ");
					String name = scanner.next();

					System.out.print("Enter age: ");
					int age = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Enter gender: ");
					String gender = scanner.nextLine();

					System.out.print("Enter phone: ");
					String phone = scanner.nextLine();

					Passenger passenger = new Passenger(name, age, gender, phone);
					System.out.print("Enter Bus No: ");
					int busNo = scanner.nextInt();

					System.out.print("Enter date (dd-MM-yyyy): ");
					String dateStr = scanner.next();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date travelDate = sdf.parse(dateStr);

					// You can now use this to create the booking
					Booking booking = new Booking(passenger, busNo, travelDate);

					BookingDAO bookingdao =new BookingDAO();
					

					if (bookingdao.isAvailable(busNo, travelDate)) {
					    // proceed
					} else {
					    System.out.println("No seats available!");
					}

				}
				else if (userOpt == 2) {
					System.out.println("Enter the booking Id number to cancel : ");
					int can = scanner.nextInt();
					BookingDAO dao = new BookingDAO();
					String cans = dao.cancelBooking(can);
					
					System.out.println(cans);
				}
				else if (userOpt==3) {
					Scanner sc = new Scanner(System.in);
			        BusDAO busDao = new BusDAO();
			        
					System.out.println("\n------ BUS MANAGEMENT MENU ------");
		            System.out.println("1. Add New Bus");
		            System.out.println("2. Show Bus Info");
		            System.out.println("3. Exit");
		            System.out.println("4. Show Available Seats by Date");

		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();
		            sc.nextLine();  // consume newline

		            try {
		                switch (choice) {
		                    case 1:
		                        System.out.print("Enter Bus ID: ");
		                        int id = sc.nextInt();

		                        System.out.print("Is it AC? (true/false): ");
		                        boolean ac = sc.nextBoolean();

		                        System.out.print("Enter capacity: ");
		                        int capacity = sc.nextInt();
		                        sc.nextLine(); // consume newline

		                        System.out.print("Enter driver name: ");
		                        String driverName = sc.nextLine();

		                        System.out.print("Enter from location: ");
		                        String from = sc.nextLine();

		                        System.out.print("Enter to location: ");
		                        String to = sc.nextLine();

		                        System.out.print("Enter duration (e.g., 2.5 hrs): ");
		                        String duration = sc.nextLine();

		                        busDao.addBus(id, ac, capacity, driverName, from, to, duration);
		                        break;

		                    case 2:
		                        busDao.displayBusInfo();
		                        break;

		                    case 3:
		                        System.out.println("Exiting...");
		                        sc.close();
		                        System.exit(0);
		                    
		                    case 4:
		                        System.out.print("Enter travel date (yyyy-mm-dd): ");
		                        String dateStr = sc.next();
		                        java.util.Date date = java.sql.Date.valueOf(dateStr); // parses to correct format
		                        busDao.displayAvailableSeatsByDate(date);
		                        break;

		                    default:
		                        System.out.println("Invalid choice!");
		                }
		            } catch (Exception e) {
		                System.out.println("Error: " + e.getMessage());
		            }
					
				}
				
			}
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}


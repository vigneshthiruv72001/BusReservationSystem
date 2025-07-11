package BusResv;
import java.sql.*;


public class BusDAO {
	 public void displayBusInfo() throws SQLException {
		 String query = "Select * from bus";
		 Connection con = DbConnection.getConnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 
		 while(rs.next()) {
			 System.out.println("Bus No: "+ rs.getInt(1));
			 System.out.println("Driver Name: "+ rs.getString(4));
			 System.out.println("from : "+ rs.getString(5));
			 System.out.println("to : "+ rs.getString(6));
			 System.out.println("Duration : "+ rs.getString(7));
			 
			 if (rs.getInt(2)==0)
				 System.out.println("Ac: no ");
			 else
				 System.out.println("AC: Yes ");
			
			 System.out.println("Capacity:" + rs.getInt(3));
			 System.out.println("------------------------------------");
		 }
		 System.out.println("+++++++++++++++++++end++++++++++++++++");
	 }
	 public int getCapacity(int id) throws SQLException {
		 String query ="select capacity from bus where id =" + id;
		 Connection con = DbConnection.getConnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 rs.next();
		 return rs.getInt(1);
	 }
	 public void addBus(int id, boolean ac, int capacity, String driverName, String from, String to, String duration) throws SQLException {
		    String query = "INSERT INTO bus (id, ac, capacity, driver_name, `from`, `to`, duration) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    Connection con = DbConnection.getConnection();
		    PreparedStatement pst = con.prepareStatement(query);
		    pst.setInt(1, id);
		    pst.setBoolean(2, ac);
		    pst.setInt(3, capacity);
		    pst.setString(4, driverName);
		    pst.setString(5, from);
		    pst.setString(6, to);
		    pst.setString(7, duration);
		    pst.executeUpdate();
		    System.out.println("Bus added successfully!");
		}
	 public void displayAvailableSeatsByDate(java.util.Date travelDate) throws SQLException {
		    String query = "SELECT * FROM bus";
		    Connection con = DbConnection.getConnection();
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(query);

		    BookingDAO bookingDAO = new BookingDAO(); // needed to count bookings

		    java.sql.Date sqlDate = new java.sql.Date(travelDate.getTime());

		    System.out.println("\n===== AVAILABLE SEATS ON " + sqlDate + " =====");

		    while (rs.next()) {
		        int busId = rs.getInt("id");
		        boolean isAc = rs.getBoolean("ac");
		        int capacity = rs.getInt("capacity");
		        String driver = rs.getString("driver_name");
		        String from = rs.getString("from");
		        String to = rs.getString("to");
		        String duration = rs.getString("duration");

		        int bookedCount = bookingDAO.getBookedCount(busId, travelDate);
		        int availableSeats = capacity - bookedCount;

		        System.out.println("Bus No        : " + busId);
		        System.out.println("Driver Name   : " + driver);
		        System.out.println("Route         : " + from + " → " + to);
		        System.out.println("Duration      : " + duration);
		        System.out.println("AC            : " + (isAc ? "Yes" : "No"));
		        System.out.println("Capacity      : " + capacity);
		        System.out.println("Booked        : " + bookedCount);
		        System.out.println("Available     : " + availableSeats + " seats");
		        System.out.println("----------------------------------------");
		    }

		    rs.close();
		    st.close();
		    con.close();
		}

}

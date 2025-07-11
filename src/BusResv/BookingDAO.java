package BusResv;
import java.util.Date;
import java.sql.*;



public class BookingDAO {
	public int getBookedCount(int busNo, Date date) throws SQLException {
		
		String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
		
		
	}
	public void addBooking(Booking booking) throws SQLException {
		String query ="INSERT INTO booking (passenger_name, bus_no, travel_date) VALUES (?, ?, ?)";
		
		Connection con = DbConnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passenger.name);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqldate);
		
		pst.executeUpdate();
	}
	public String cancelBooking(int bookingId) throws SQLException {
		String query = "DELETE FROM booking WHERE booking_id =" +bookingId;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		int rowsDeleted = st.executeUpdate(query);
		
		if (rowsDeleted > 0) {
	        return "The booking number " + bookingId + " was successfully cancelled.";
	    } else {
	        return "No booking found with booking ID " + bookingId + ".";
	    }
	}
	public boolean isAvailable(int busNo, Date date) throws SQLException {
	    BusDAO busDao = new BusDAO();
	    int capacity = busDao.getCapacity(busNo);
	    int booked = getBookedCount(busNo, date);
	    return booked < capacity;
	}

}

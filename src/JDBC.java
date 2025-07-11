import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws SQLException {
		
		
		String url = "jdbc:mysql://localhost:3306/vignesh";
		String username = "root";
		String password = "1234";
		String query = "insert into employee values(10,'dhanush','sambath','agri',190000)";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		int rs= st.executeUpdate(query);
		
		
		
		System.out.println("Number of row affected : "+rs);
//		while(rs.next()) {
//			System.out.println("ID is " + rs.getInt(1));
//			System.out.println("First Name is " + rs.getString(2));
//			System.out.println("Last name is " + rs.getString(3));
//		}
		
		con.close();
	}
	
}

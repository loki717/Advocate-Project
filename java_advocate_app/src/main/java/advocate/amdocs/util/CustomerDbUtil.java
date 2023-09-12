package advocate.amdocs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDbUtil {
	private static final String URL="jdbc:mysql://localhost:3306/advocatedb";
	private static final String USER_NAME="root";
	private static final String PASSWORD="lokileee";
	
	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.err.println("Error : Connection Not Established\n" + e );
		}
		return connection;
	}
	
	  public static void main(String[] args) { System.out.println(getConnection());
	  
	  }

}

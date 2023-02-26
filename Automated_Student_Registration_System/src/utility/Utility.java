package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  Utility  {
	
	static final String url = "jdbc:mysql://localhost:3306/studentdb";

    static final String username = "root";
    static final String password = "9484";
	
public static Connection  provideConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn= DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SecondStoreDatabase {
	        
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "";
	    private static Connection con;
	    private static String url = "jdbc:mysql://localhost:3306/SecondStoreDatabase";
	    public  Connection getConnection() {
	        try {
	            Class.forName(driverName);
	            try {
	                con = DriverManager.getConnection(url, username, password);
	                System.out.println("-------------------------------------------");
	                System.out.println("second data base connection is successfully");
	                System.out.println("-------------------------------------------");


	            } catch (SQLException ex) {
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
}

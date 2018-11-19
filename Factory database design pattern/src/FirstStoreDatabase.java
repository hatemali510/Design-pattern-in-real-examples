import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FirstStoreDatabase {
	    private static String url = "jdbc:mysql://localhost:3306/FirstStoreDatabase";    
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "";
	    private static Connection con;
	    
	    public  Connection getConnection() {
	        try {
	            Class.forName(driverName);
	            try {
	                con = DriverManager.getConnection(url, username, password);
	                System.out.println("-------------------------------------------");
	                System.out.println("first data base connection is successfully");
	                System.out.println("-------------------------------------------");
	            } catch (SQLException ex) {
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
	    
}

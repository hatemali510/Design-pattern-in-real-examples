import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    static Connection DB_Connection = null; 
    private static DB dbInstace=null;
    String driver = "com.mysql.jdbc.Driver";
    private Statement statement;
    // put your database mysql configuration paramaters 
    private static String DB_name=" /*YOUR_DATABASE_NAME*/ ";
    private static String DB_user="/*YOUR_DATABASE_USERNAME*/";
    private static String DB_password="/*YOUR_DATABASE_USER_PASSWORD*/";
	
	
	// constructor 
	private DB() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException { 
		Class.forName(driver).newInstance();
		DB_Connection = DriverManager.getConnection(
			       "jdbc:mysql://localhost:3306/"+DB_name, DB_user, DB_password);
	} 
	
	
	public static DB get_DB_Instance() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		if (DB_Connection==null) {
			dbInstace=new DB();
			System.out.println("---------------------");
			System.out.println("first intialization ");
			System.out.println("---------------------");

		}
		
		return dbInstace;
	}
	
	// excute query fucntion 
	public ResultSet executeDbQuery(String query) throws SQLException{
        statement = DB.DB_Connection.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
	
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String databasename="first";
		Connection conn=new DBFactoryConnection(databasename).getConnection();
		String selectQuery="select * from books";
		ResultSet First_Database_table=executeDbQuery(selectQuery,conn);
       	        System.out.println("first table content : ");
                System.out.println("-------------------------------------------");
		while(First_Database_table.next()) {   // Move the cursor to the next row, return false if no more row
		    String title = First_Database_table.getString("title");
		    String    author   = First_Database_table.getString("author");
		    System.out.println("book title : "+title + " - AUTHOR : " + author);		    
       	        }
		String databasename2="second";
		Connection conn2=new DBFactoryConnection(databasename2).getConnection();
		String selectQuery2="select * from books";
		ResultSet Second_Database_table=executeDbQuery(selectQuery2,conn2);
		System.out.println("second table content : ");
	        System.out.println("-------------------------------------------");
		while(Second_Database_table.next()) {   // Move the cursor to the next row, return false if no more row
		    String title = Second_Database_table.getString("title");
		    String    author   = Second_Database_table.getString("author");
		    System.out.println("book title : "+title + " - AUTHOR : " + author);		    
                }
	}
	
	public static ResultSet executeDbQuery(String query,Connection conn) throws SQLException{
		Statement statement = conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
        }
}

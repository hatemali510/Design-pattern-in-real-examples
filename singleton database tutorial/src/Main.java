import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	      try {
		    	  // singleton call
		         String strSelect = "select title, price, qty from books";
		         ResultSet rset = DB.get_DB_Instance().executeDbQuery(strSelect);
		         System.out.println("The records selected are:");
		         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
		            String title = rset.getString("title");
		            double price = rset.getDouble("price");
		            int    qty   = rset.getInt("qty");
		            System.out.println(title + ", " + price + ", " + qty);
		         }
		         String strSelect2 = "select * from books";
		         ResultSet rset2 = DB.get_DB_Instance().executeDbQuery(strSelect2);
		         System.out.println("");
		         System.out.println("The records selected are:");
		         while(rset2.next()) {   
				 // Move the cursor to the next row, return false if no more row
		        	    String title = rset2.getString("title");
			            int    qty   = rset2.getInt("qty");
			            System.out.println(title + " , " + qty);

			     }
			 }
	      } catch(SQLException ex) {
	    	  	 ex.printStackTrace();
	      }
	   }

}

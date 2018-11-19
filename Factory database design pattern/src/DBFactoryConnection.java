import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


public class DBFactoryConnection {
	Map<String,String> dataBaseMaping=new HashMap<String,String>();
	private String databaseName;
	DBFactoryConnection(String databasename){
		this.databaseName=databasename;
		LoadAllDatabaseNames();
	}
	
	public void LoadAllDatabaseNames(){
		// placeholder names for the example 
		// should save all database names in  database with all database names and configurations 
		
		dataBaseMaping.put("first","FirstStoreDatabase");
		dataBaseMaping.put("second","SecondStoreDatabase");
	}
	
	public  Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String SelectedDatabase= (String)dataBaseMaping.get(databaseName);
		if(SelectedDatabase.equals("FirstStoreDatabase")) {
			return new FirstStoreDatabase().getConnection();
		}
		else if(SelectedDatabase.equals("SecondStoreDatabase")){
			return new SecondStoreDatabase().getConnection();
		}
		else{
			System.out.println("no database found ");
			return null;
		}
	}
	
	
}

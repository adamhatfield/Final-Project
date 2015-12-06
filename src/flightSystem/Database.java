package flightSystem;
import java.sql.*;
public class Database { 
	private  String url = "jdbc:mysql://localhost:3306/java";
	
	private String user = "admin";
	private String password = "Arson8629";
	
	public Database(){
		intializeDB();
	}
	
	private void intializeDB (){
		try{
			//Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flightsystem",user,password);
			System.out.println("Connection established");
		}catch(Exception e){
			System.out.println("Error in connecting to Database");
		}
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
			
			Database db = new Database();
		
		
		
		
		
		
		
		
	}

}

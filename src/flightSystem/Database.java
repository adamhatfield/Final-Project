package flightSystem;
import java.sql.*;
public class Database { 
	private  String url = "jdbc:mysql://localhost:3306/java";
	
	private String user = "java";
	private String password = "password";
	
	public Database(){
		intializeDB();
	}
	
	private void intializeDB (){
		try{
			//Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","java","password");
			System.out.println("Connected");
		}catch(Exception e){
			System.out.println("Error in connecting to Database");
		}
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
			
			Database db = new Database();
		
		
		
		
		
		
		
		
	}

}

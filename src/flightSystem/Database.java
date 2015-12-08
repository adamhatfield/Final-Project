package flightSystem;
import java.sql.*;

import javax.swing.JOptionPane;


public interface Database { 
	  
	
	 String user = "admin";
	 String password = "Arson8629";
	 
	
	
	/**Initialize Database connection*/
	default void initializeDB (){
		try{
			//Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FlightSystem",user,password);
			System.out.println("Database Connected");
			
		}catch(Exception e){
			System.out.println("Error in connecting to Database");
		}
	}
	
	/**Add new user into database*/
	default void insertNewUser(String userName, String password, String emailAddress, String firstName, String lastName, String address, String city, String state, 
			String zip, String ssn, String securityQuestion, String answer){
		
		/**Query that adds a user to the Customer table*/
		String query = "INSERT INTO CUSTOMER(CusUserName,CusPassword,CusEmailAddress,CusFirstName,CustLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer) VALUE("+userName+","+password+","+emailAddress+","
				+firstName+","+lastName+","+address+","+city+","+state+","+zip+","+ssn+","+securityQuestion+","+answer+")";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FlightSystem",user,password);
			Statement s = connection.createStatement();
			s.executeQuery(query);
			 
			
		}catch(Exception e){
			
		}
	}
	
	default boolean login(String userName, String password){
		
		String query = "select CusUserName, CusPassword from Customer where Customer.CusUserName = '"+userName+"' and Customer.CusPassword = '"+password+"'";
		
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flightsystem",user,password);
			Statement stmt = connection.createStatement();
			ResultSet login = stmt.executeQuery(query);
			if(login.next()){
				String userNameSQL = login.getString(1);
				String passwordSQL = login.getString(2);
				if(userName == userNameSQL && password == passwordSQL)
					return true;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	


}

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
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",user,password);
			System.out.println("Database Connected");
			
		}catch(Exception e){
			System.out.println("Error in connecting to Database");
		}
	}
	
	/**Add new user into database*/
	default void insertNewUser(int accountNumber,String userName, String password, String emailAddress, String firstName, String lastName, String address, String city, String state, 
			String zip, String ssn, String securityQuestion, String answer){
		
			
		/**Query that adds a user to the Customer table*/
		String query = "INSERT INTO CUSTOMER(CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer) VALUE('"+accountNumber+"','"+userName+"','"+password+"','"+emailAddress+"','"
				+firstName+"','"+lastName+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+ssn+"','"+securityQuestion+"','"+answer+"')";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem","admin","Arson8629");
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**Method that logs user in flight system main menu*/
	default boolean login(String userName, String password){
		/**Query that checks database for username and password based on textfield entry*/
		String query = "select CusUserName, CusPassword from Customer where Customer.CusUserName = '"+userName+"' and Customer.CusPassword = '"+password+"'";
		
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem","admin","Arson8629");
			Statement stmt = connection.createStatement();
			ResultSet login = stmt.executeQuery(query);
			if(login.next()){
				String userNameSQL = login.getString(1);
				String passwordSQL = login.getString(2);
				//System.out.print(userNameSQL+ " " +passwordSQL);
				if(userName.equals(userNameSQL) && password.equals(passwordSQL))
					return true;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	


}

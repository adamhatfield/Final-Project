package flightSystem;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public interface Database { 
	  
	
	 String user = "admin";
	 String password = "Arson8629";
	 String databaseCommit = "COMMIT";
	 
	/**Initialize Database connection*/
	default void initializeDB (){
		try{
			//Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",user,password);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error in connecting to Database");
		}
	}
	
	/**Add new user into database*/
	default void insertNewUser(Customer customer) throws NumberFormatException{
		
			
		/**Query that adds a user to the Customer table*/
		String query = "INSERT INTO CUSTOMER(CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer) VALUE('"+customer.getAccountNumber()+"','"+customer.getUserName()+"','"+customer.getPassword()+"','"
				+customer.getEmailAddress()+"','"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getAddress()+"','"+customer.getCity()+"','"
				+customer.getState()+"','"+customer.getZipCode()+"','"+customer.getSSN()+"','"+customer.getSecurityQuestion()+"','"+customer.getSecurityQuestionAnswer()+"')";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem","admin","Arson8629");
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit); //Automatically makes the database save any changes
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**Method that logs user into flight system main menu*/
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
					//>new add<//
					
					return true;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
		
	}
	

	
	/**Method that loads all user info in to customer object
	 * This gui methods then use this object to perform tasks or access other methods.
	 * If null is returned there is no matching username in the database.
	 * @param userName
	 * @return
	 */
	default Customer getCustomerInfo(String userName) throws Exception{
		Customer c = new Customer();
		///*************UPDATE HERE
		String query = "SELECT CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer,FlightNumber FROM Customer WHERE Customer.CusUserName ='"+userName+"'";
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem","admin","Arson8629");
		Statement stmt = connection.createStatement();
		ResultSet customer = stmt.executeQuery(query);
		while(customer.next()){
			
			int accountNumber = customer.getInt(1);
			String cusUserName = customer.getString(2);
			String cusPassword = customer.getString(3);
			String cusEmail = customer.getString(4);
			String firstName = customer.getString(5);
			String lastName = customer.getString(6);
			String address = customer.getString(7);
			String city = customer.getString(8);
			String state = customer.getString(9);
			int 	zip = customer.getInt(10);
			int ssn = customer.getInt(11);
			String securityQuestion = customer.getString(12);
			String answer = customer.getString(13);
			ArrayList<Integer> flightNum = new ArrayList<>();
			int i = 14;
			while(customer.isLast()){
				flightNum.add(customer.getInt(i));
				i++;
				
			}
			//*************UPDATE THIS constructor needs to get FLIGHTNUMBER
			 c = new Customer(accountNumber, cusUserName, cusPassword, cusEmail, firstName, lastName, address, city, state, zip, ssn, securityQuestion, answer, flightNum);
			 
		}
		return c;
		
	}
	/**
	 * This method changes a users password in the database
	 * @param userName
	 * @param password
	 */
	default void updatePassword(String userName, String password){
		String query = "UPDATE Customer SET CusPassword ='"+password+ "' WHERE Customer.CusUserName = '" +userName+"'";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem","admin","Arson8629");
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit);
			 
			
		}catch(Exception e){
			e.printStackTrace();
		
	}
	}
	//found purpose
	//for quick updates
	default void queryCustomer(String query) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		//if trying to print results of query
		//while(resultSet.next()){
			
		//}
		
	}
	 default void deleteFlightFromCustomer(String username) throws ClassNotFoundException, SQLException{
		String query =("UPDATE Customer SET FlightNumber ="+null+" WHERE CusUserName ="+username);
		queryFlight(query);
	}
	
	//found purpose
	//for quick updates
	  default void queryFlight(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		//if trying to print results of query
		//while(resultSet.next()){
			
		//}
		
	}
	  /**Method that returns a flight object that matches the corresponding departure and destination from search flight view.*/
	  default Flight findFlight(String departure, String destination) throws ClassNotFoundException, SQLException{
		  Flight f = new Flight();
		  String query = ("SELECT FlightNumber, FlightDestination, FlightStartPoint, FlightDuration, FlightDate, FlightTime FlightCost, FlightCapacity, OnFlight"
				+ "FROM Flight WHERE Flight.FlightStartPoint = '"+departure+"' and Flight.FlightDestination = '"+destination+"' ");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()){
		int flightNumber = rs.getInt(1);
		String destin = rs.getString(2);
		String start = rs.getString(3);
		String duration = rs.getString(4);
		String date = rs.getString(5);
		String time = rs.getString(6);
		double cost = rs.getDouble(7);
		int capacity = rs.getInt(8);
		int reserved = rs.getInt(9);
		
		 f = new Flight( flightNumber, capacity, reserved, destin, start, date, duration, time,  cost);
		
		}
		
		
		
		  
		  return f;
		  
	  }
	
	
	
	
	


}

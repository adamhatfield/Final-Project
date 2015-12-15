package flightSystem;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public interface Database { 
	  
	final String USER = "root";
	final String PASSWORD = "adamyouknowit";
	 String databaseCommit = "COMMIT";
	 
	/**Initialize Database connection*/
	default void initializeDB (){
		try{
			//Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,PASSWORD);
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error in connecting to Database");
		}
	}
	
	/**Add new user into database*/
	//method to add customer with flight number takes array index
	static void insertNewUser(Customer customer, int arrayIndex) throws NumberFormatException{
		
			
		/**Query that adds a user to the Customer table*/
		String query = "INSERT INTO CUSTOMER(CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer) VALUE('"+customer.getAccountNumber()+"','"+customer.getUserName()+"','"+customer.getPassword()+"','"
				+customer.getEmailAddress()+"','"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getAddress()+"','"+customer.getCity()+"','"
				+customer.getState()+"','"+customer.getZipCode()+"','"+customer.getSSN()+"','"+customer.getSecurityQuestion()+"','"+customer.getSecurityQuestionAnswer()+"','"+customer.flightNumber.get(arrayIndex)+"')";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,PASSWORD);
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit); //Automatically makes the database save any changes
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	default void insertNewUser(Customer customer) throws NumberFormatException{
		
		
		/**Query that adds a user to the Customer table*/
	/*
		String query = "INSERT INTO CUSTOMER(CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer,FlightNumber) VALUE('"+customer.getAccountNumber()+"','"+customer.getUserName()+"','"+customer.getPassword()+"','"
				+customer.getEmailAddress()+"','"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getAddress()+"','"+customer.getCity()+"','"
				+customer.getState()+"','"+customer.getZipCode()+"','"+customer.getSSN()+"','"+customer.getSecurityQuestion()+"','"+customer.getSecurityQuestionAnswer()+"','"+customer.flightNumber.get(0)+"')";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,PASSWORD);
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit); //Automatically makes the database save any changes
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	*/
	/**Method that logs user into flight system main menu*/
	default boolean login(String userName, String password){
		/**Query that checks database for username and password based on textfield entry*/
		String query = "select CusUserName, CusPassword from Customer where Customer.CusUserName = '"+userName+"' and Customer.CusPassword = '"+password+"'";
		
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,this.PASSWORD);
			Statement stmt = connection.createStatement();
			ResultSet login = stmt.executeQuery(query);
			if(login.next()){
				String userNameSQL = login.getString(1);
				String passwordSQL = login.getString(2);
				//System.out.print(userNameSQL+ " " +passwordSQL);
				if(userName.equals(userNameSQL) && password.equals(passwordSQL)){
					//>new add<//
					Customer.setLogin(userNameSQL);//lets system know someone is logged in
					return true;
				}
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
	static Customer getCustomerInfo(String userName) throws Exception{
	//	Customer c = new Customer();
		///*************UPDATE HERE
		String query = "SELECT CusAccountNumber,CusUserName,CusPassword,CusEmailAddress,CusFirstName,CusLastName,"
				+ "CusAddress,CusCity,CusState,CusZip,CusSSN,CusSecurityQuestion,CusSecurityAnswer,FlightNumber FROM Customer WHERE Customer.CusUserName ='"+userName+"'";
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,PASSWORD);
		Statement stmt = connection.createStatement();
		ResultSet customer = stmt.executeQuery(query);
		int count =0;
		ArrayList<Integer> flightNum =new ArrayList<>();
		int accountNumber = customer.getInt(1);
		
		int zip = 0, ssn=0;
		String securityQuestion = null, answer = null, cusUserName = null,cusPassword = null ,cusEmail = null ,firstName = null ,lastName = null,address = null ,city = null 
		, state=null;
		while(customer.next()){
			if(count==0){
			 accountNumber = customer.getInt(1);
			 cusUserName = customer.getString(2);
			 cusPassword = customer.getString(3);
			 cusEmail = customer.getString(4);
			 firstName = customer.getString(5);
			 lastName = customer.getString(6);
			 address = customer.getString(7);
			 city = customer.getString(8);
			 state = customer.getString(9);
			 	zip = customer.getInt(10);
			 ssn = customer.getInt(11);
			 securityQuestion = customer.getString(12);
			 answer = customer.getString(13);
			}
			flightNum.add(customer.getInt(14));
			
		
			 
		}
		Customer c = new Customer(accountNumber, cusUserName, cusPassword, cusEmail, firstName, lastName, address, city, state, zip, ssn, securityQuestion, answer, flightNum);
		return c;
		
	}
	/**
	 * This method changes a users password in the database
	 * @param userNamedn
	 * @param password
	 */
	default void updatePassword(String userName, String password){
		String query = "UPDATE Customer SET CusPassword ='"+password+ "' WHERE Customer.CusUserName = '" +userName+"'";
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,password);
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit);
			 
			
		}catch(Exception e){
			e.printStackTrace();
		
	}
	}
	//found purpose
	//for quick updates
	static void queryCustomer(String query) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		//if trying to print results of query
		//while(resultSet.next()){
			
		//}
		
	}
	static void queryECustomer(String query) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
		Statement statement = connection.createStatement();
	//	String guery="Select FlightNumber FROM Customer WHERE CusUserNAME ='"+cusUserName"'";
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()){
			
		}
	}
	static void moreFlightsCus(int FlightNumber) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
		Statement statement = connection.createStatement();
	//	ResultSet resultSet = statement.executeQuery(query);
	}//not finshed but tired lol
	
	 default void deleteFlightFromCustomer(String username) throws ClassNotFoundException, SQLException{
		//edit
		String query =("UPDATE Customer SET FlightNumber ="+null+" WHERE CusUserName ="+username);
		queryFlight(query);
	}
	
	//found purpose
	//for quick updates
	  default void queryFlight(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		//if trying to print results of query
		//while(resultSet.next()){
			
		//}
		
	}
	  /**Method that returns a flight object that matches the corresponding departure and destination from search flight view.*/
	  default Flight findFlight(String departure, String destination, String newDate ) throws ClassNotFoundException, SQLException{
		  Flight f = new Flight();
		  String query = ("SELECT FlightNumber, FlightDestination, FlightStartPoint, FlightDuration, FlightDate, FlightTime FlightCost, FlightCapacity, OnFlight"
				+ "FROM Flight WHERE Flight.FlightStartPoint = '"+departure+"' and Flight.FlightDestination = '"+destination+"' and Flight.FlightDate = '"+newDate+"' ");
		  
		try{
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
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
		}catch(Exception e){
		e.printStackTrace();	
		}
		
		
		
		
		  
		  return f;
		  
	  }
	  
	  /**
	   * isAdmin Method
	   * This method returns true is the username used during login matches the username of an admin in the database
	   * @param userName
	   * @return
	   * @throws SQLException
	   */
	  default boolean isAdmin(String userName) throws SQLException{
		  String userNameServer = "";
		  String query = " SELECT ADMUserName FROM ADMIN WHERE Admin.ADMUserName = '"+userName+ "'";
		  Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/flightsystem",USER,PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				 userNameServer = rs.getString(1);
			}
			
			if(userNameServer.equalsIgnoreCase(userName))
				return true;
			else
				return false;
			
			
	  }
	  /**
	   * Method that deletes a flight from the database
	   * @param flightNum
	   * @throws ClassNotFoundException
	   * @throws SQLException
	   */
	  default void deleteFlight(int flightNum) throws ClassNotFoundException, SQLException{
			String query =("DELETE FROM Flight WHERE FlightNumber ="+flightNum);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsystem",USER,PASSWORD);
			Statement s = connection.createStatement();
			s.executeUpdate(query);
			s.executeQuery(databaseCommit);
		}
	
	
	
	


}

package flightSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookFlight implements Database,Editting {
	final static String USER = "root";
	final static String PASSWORD = "adamyouknowit";
	Scanner input = new Scanner(System.in);
	//starting with Book Flight
	///*************START BOOK FLIGHT********************

	public static void bookFlight() throws Exception{
		Scanner input = new Scanner(System.in);
	System.out.println("Book Flight Menu\n");
	System.out.println("From");//must be city
	String from = input.nextLine(); //scans full string
	System.out.println("To");//must be city
	String to = input.nextLine();
	System.out.println("Depart Date(yyyy-mm-dd)");//format yyyy-mm-dd
	String ddate = input.nextLine();
	//need to add return date to database
//	System.out.println("Return Date");
//	String Return = input.nextLine();
	System.out.println("Passengers");//number of tickets being sold
	int passengers = input.nextInt();
	// press ok button

	
	
	//void findFlight(String from, String to, String date, String retur, int passenger){
	
	

	//Load JDBC driver
	Class.forName("com.mysql.jdbc.Driver");
	//Establish connection
	Connection connection = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
			Statement statement = connection.createStatement();
			/*
			 * ResultSet finds planes that fit customer schedule
			 * From here now you only need to display
			 */
			ResultSet resultSet = statement.executeQuery
					("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
							+ "FlightCapacity, OnFlight, FlightDuration"
							+ ", FlightTime, FlightNumber FROM flight "
							+ "WHERE FlightStartPoint ='"+ from+"' AND FlightDestination "
									+ "='"+to+"' AND FlightDate ='"+ddate+"'");
			boolean worked=false; //false if u get a null because no current flight match requirement
			while(resultSet.next()){
			worked=true;//didnt get null
			int c =resultSet.getInt(5);
			int o =resultSet.getInt(6);
			int remain=c-o; //remain how many tickets are left
			//gui button action here subbing it right now with scanner
			//System.out.println("Click on Flight you want");//or enter in flight number
				
			//below prints all flights that match requirement in table-like format
			System.out.println("Flight#\tCost\tSeats Left#\tFlight Time\tFlight Durati"
					+ "on\tFlight Date");
			System.out.println(resultSet.getInt(9)+"\t"+resultSet.getDouble(2)+"\t"
					+ ""+remain+"\t"+resultSet.getTime(8)+"\t"+resultSet.getTime(7)+""
					+ "\t"+resultSet.getDate(4));
			}
			int choose = -1; 
			if(worked==false){
				System.out.println("Sorry no flight is available that matches your requirements");
				} // GOOD SPOT TO GO BACK TO HOME PAGE BUTTON OR MAKE VISIBLE
			else {
			System.out.println("From above list, Enter in flight number you want"); 
			//can be replace with button;
			
			while(Flight.worked(choose)==false){ //loops until valid flightNUm is entered in
				choose =input.nextInt();
				} }
		
			 //may come back and spit this method right HERE ***************** for second method below to work
			// above method would need to return choose 
			//and new passenger count on ticket
			
			//*********METHOD TO CHECK IF ADD TO FLIGHT IS POSSIBLE
			// void tryAddFlight(int choose){
			ResultSet resultSet1=statement.executeQuery("SELECT OnFlight,FlightCapacity from flight WHERE FlightNumber ="+choose);
			while(resultSet1.next())
			if(resultSet1.getInt(1)+passengers<=resultSet1.getInt(2)){		
				int mod=resultSet1.getInt(1)+passengers;
				statement.executeUpdate("UPDATE FLIGHT SET OnFlight ="+mod+" WHERE FlightNumber ="+choose);
					
			}
			else
			{
				System.out.println("Flight is at full capacity"); //Go back to home
			}
			
			
			// if logged in or if logged out after picking flight
			//first if logged if

			//logged in is trait of customer
			if(Customer.loggedInUser!=null){
				//check if customer already booked this flight
					Customer customerInfo = Database.getCustomerInfo(Customer.loggedInUser);
					int i=0; boolean x=true;//true means this is a new flight addition
					while(i<customerInfo.flightNumber.size()){
						if(choose==customerInfo.flightNumber.get(i))
						{
							x=false;
							System.out.println("You have already booked this Flight at a previous time"
									+ "\nThank you");
							break;
						}
						i++;							
					}
					if(x){
						customerInfo.flightNumber.add(choose);
						Database.insertNewUser(customerInfo,customerInfo.flightNumber.size()-1);
						System.out.println("You have been successfully added to the flight");
					}
				
			}
			else {
				//press create a new account or login for now will do scanner
				System.out.println("1.) Create a new account");
				System.out.println("2.) Login");
				int xx= input.nextInt();
				//////both I
				if(xx==1){
				//insert ADAM create new customer method
					
				//then think popup
				Database.queryCustomer("UPDATE Customer Set FlightNumber ="+choose+" WHERE CusUserName ="+Customer.loggedInUser);	
				System.out.println("You have been successfully added to flight");
				}
				if(xx==2){
				//insert Adam login method
					Customer customerInfo = Database.getCustomerInfo(Customer.loggedInUser);
					int i=0; boolean x=true;//true means this is a new flight addition
						while(i<customerInfo.flightNumber.size()){
							if(choose==customerInfo.flightNumber.get(i))
							{
								x=false;
								System.out.println("You have already booked this Flight at a previous time"
										+ "\nThank you");
								break;
							}
							i++;							
						}
						if(x){
							customerInfo.flightNumber.add(choose);
							Database.insertNewUser(customerInfo,customerInfo.flightNumber.size()-1);
							System.out.println("You have been successfully added to the flight");
						}
			}
			}
			}
}

package flightSystem;
import java.util.Scanner;
import java.sql.*;

public class Home implements Database{
	public static void main(String[] args)
			throws SQLException, ClassNotFoundException {
		
		System.out.println("Login");
		System.out.println("Book Flight");
		System.out.println("My Flights");
		System.out.println("Flight Status");
		
		Scanner input = new Scanner(System.in);
		//starting with Book Flight
		///*************START BOOK FLIGHT********************
		System.out.println("You are in the booking flights menu\n");
		System.out.println("From");//must be city
		String from = input.nextLine(); //scans full string
		System.out.println("To");//must be city
		String to = input.nextLine();
		System.out.println("Depart Date");//format yyyy-mm-dd
		String date = input.nextLine();
		//need to add return date to database
	//	System.out.println("Return Date");
	//	String Return = input.nextLine();
		System.out.println("Passengers");
		int passengers = input.nextInt();
		// press ok button
		
		//method find available flight
		
		
		//void findFlight(String from, String to, String date, String retur, int passenger){
		
		
		
			//need to go to database
			//String query = "select FlightStartPoint, FlightDestination, FlightDate"
		String user = "root";
		String password = "adamyouknowit";
		
				//Load JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				//Establish connection
				Connection connection = DriverManager.getConnection
						("jdbc:mysql://127.0.0.1/project",user,password);
				System.out.println("Database Connected");
				
				Statement statement = connection.createStatement();
				/*
				 * ResultSet finds planes that fit customer schedule
				 * From here now you only need to display
				 */
				ResultSet resultSet = statement.executeQuery
						("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, FlightCapacity, OnFlight, FlightDuration"
								+ ", FlightTime, FlightNumber FROM flight "
								+ "WHERE FlightStartPoint ='"+ from+"' AND FlightDestination ='"+to+"' AND FlightDate ='"+date+"'");
				boolean worked=false; //for if get a null because no current flight match requirement
				int choose;
				while(resultSet.next()){
				worked=true;//didnt get null
				int c =resultSet.getInt(5);
				int o =resultSet.getInt(6);
				int remain=c-o;
			//gui button action here subbing it right now with scanner
				//System.out.println("Click on Flight you want");//or enter in flight number
				
				
				System.out.println("Flight#\tCost\tTickets#\tFlight Time\tFlight Duration\tFlight Date");
				System.out.println(resultSet.getInt(9)+"\t"+resultSet.getDouble(2)+"\t"+remain+"\t"+resultSet.getTime(8)+"\t"+resultSet.getTime(7)+""
						+ "\t"+resultSet.getDate(4));
				}
				if(worked==false){
					System.out.println("Sorry not flight is available that meets your requirements");
					} // GOOD SPOT TO GO BACK TO HOME PAGE BUTTON OR MAKE VISIBLE
				else {
				System.out.println("Enter in flight number you want");
				boolean x=true;
				while(x){ //loops into valid flightNUm is entered in
					choose =input.nextInt();
					resultSet=statement.executeQuery("SELECT FlightNumber FROM FLIGHT WHERE FlightNumber ="+choose);
					while(resultSet.next())
					x=false; //only can get here if valid flight number
					
					} }
			
				 //may come back and spit this method right HERE ***************** for second method below to work
				// above method would need to return choose 
				//and new passenger count on ticket
				
				//*********METHOD TO CHECK IF ADD TO FLIGHT IS POSSIBLE
				ResultSet resultSet1=statement.executeQuery("SELECT OnFlight,FlightCapacity from flight WHERE FlightNumber ="+choose);
				while(resultSet1.next())
				if(resultSet1.getInt(1)+passengers<=resultSet1.getInt(2)){
					int mod=resultSet1.getInt(1)+passengers;
					statement.execute("UPDATE FLIGHT SET OnFlight ="+mod+" WHERE FlightNumber ="+choose);
						
				}
				else
				{
					System.out.println("Flight is at full capacity"); //Go back to home
				}
				
				
				//at if logged in or if logged out after picking flight
				//first if logged in
				boolean logged=false; //this code should be at beginning of program
	
				//logged in is trait of customer
				if(logged){
					System.out.println("You have been successfully added to flight");
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
					System.out.println("You have been successfully added to flight");
					}
					if(xx==2){
					//insert Adam login method
					//then think popup
					System.out.println("You have been successfully added to flight");
				}
				}
					//********END  BOOK FLIGHT**************
					 }
					 
}

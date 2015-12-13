package flightSystem;
import java.util.Scanner;
import java.sql.*;

public class Home implements Editting{
	public static void main(String[] args)
			throws SQLException, ClassNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Login");
		System.out.println("Book Flight");
		System.out.println("My Flights");
		System.out.println("Flight Status");
		
		
		///should be hidden or if statement ONLY FOR ADIM
		System.out.println("All Flights"); //Hiddden until logged in as Admin
		System.out.println("All Customers");
		System.out.println("Book Flight");
		System.out.println("My Flights");
		System.out.println("Flight Status");
	
		//if admin clicks all flights
		System.out.println("Here are all the Flights");
		Flight.printFlight();
		
		//to ADD FLIGHT pressed this button
		System.out.println("You are adding a Flight");
		System.out.println("Enter in Flight Number");
		int flightNum=input.nextInt();
		System.out.println("Enter in Flight Capacity");
		int flightCap =input.nextInt();
		System.out.println("How many people are pre-booked on flight");
		int onFl=input.nextInt();
		System.out.println("Enter in Flight Destination");
		String destination = input.nextLine();
		System.out.println("Enter in Flight Start Point");
		String start = input.nextLine();
		System.out.println("Enter in Flight Date in format yyyy/mm/dd");
		String date = input.nextLine();
		System.out.println("Enter in Flight Duration in format hh/mm/ss");
		String duration = input.nextLine();
		System.out.println("Enter in Time of Flight in format hh/mm/ss");
		String time = input.nextLine();
		System.out.println("Enter in Cost of Flight");
		double cost = input.nextDouble();
		
		
		Flight newF =new Flight( flightNum, flightCap, onFl, destination,  start,  date, duration,  time,  cost);
		
		System.out.println("Flight has been succesfully created");
		Flight.printFlight(newF.flightNumber);
		//go back home //create new flight done
		
		//press or enter in what flight you want to edit
		//going to do scan for now
		System.out.println("Enter in Flight Number you want to edit");
		int pick=input.nextInt();
		//then take you here
		/*here you have the option to modify flight
		 * see customers in selected flight
		 */
		Flight f = new Flight(pick); //pull flight from database with the flightNumber requested
		
		Flight.printFlight(f.flightNumber); //prints selected flight
		System.out.println("To edit Press(enter in) one of the below Number type 0 (Zero) to stop \n"  //button if there
				+ "1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9"
				+ "\n To delete flight enter 10"
				+ "\n Enter one at a time");
	// NUMBERS SHOULD MATCH WITH TITLES 1 IS FLIGHT NUMBER ETC("FlightNumber\tFlightCapacity\tOnFlight\tFlightStartPoint\t FlightDestination\tFlightDate\tFlightTime\tFlightDuration\tFlightPrice");
		int i=-1;
		int a;
		boolean delete=false;
		//currently doesnt check if data enter in fits scheme of database. for example could enter
		//cost equal 10000000 but that is too big for database
		while(i!=0){
			switch (i){
			case 1:	System.out.println("What will new FlightNumber be");//has to be unique 
					a =input.nextInt();
					Editting.setFlightNumber(f,a);
					break;
			case 2: System.out.println("What will new FlightCapacity be");
					a =input.nextInt();
					Editting.setFlightCapacity(f,a);
					break;
			case 3: System.out.println("What will new On Flight be");
					a =input.nextInt();
					Editting.setOnFlight(f,a);
					break;
			case 4:	System.out.println("What will be new From Point");
					String aa = new String (input.nextLine());
					Editting.setFlightStartPoint(f,aa);
					break;
			case 5: System.out.println("What will be new Destination");
					aa = new String (input.nextLine());
					Editting.setFlightDestination(f,aa);
					break;
			case 6: System.out.println("What will be new date");
					aa = new String (input.nextLine());
					Editting.setFlightDate(f, aa);
					break;
			case 7: System.out.println("What will be new Time");
					aa = new String (input.nextLine());
					Editting.setFlightTime(f, aa);
					break; 
			case 8: System.out.println("What will be new Duration of flight");
					aa = new String (input.nextLine());
					Editting.setFlightDuration(f, aa);
					break; 
			case 9:	System.out.println("What will be new Cost of flight");
					a = input.nextInt();
					Editting.setFlightCost(f, a);
					break; 
			case 10: Flight.deleteFlight(f.flightNumber);
					delete=true;
					System.out.println("Changes have been commited");
					i=0;
					break;
			
			}
			if(delete==false){
			f.databaseFlight(); //updates database
			System.out.println("Changes have been commited");
			Flight.printFlight(f.flightNumber);//prints whats been changed
			i=input.nextInt();}

		}
	
		// go back to home of adim
		
		//*****************Start of Login
		//instert adam login
		//note will need a second login method for admin because admin is own table
			
		//after admin logs in
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//starting with Book Flight
		///*************START BOOK FLIGHT********************
		System.out.println("You are in the booking flights menu\n");
		System.out.println("From");//must be city
		String from = input.nextLine(); //scans full string
		System.out.println("To");//must be city
		String to = input.nextLine();
		System.out.println("Depart Date");//format yyyy-mm-dd
		String ddate = input.nextLine();
		//need to add return date to database
	//	System.out.println("Return Date");
	//	String Return = input.nextLine();
		System.out.println("Passengers");//number of tickets being sold
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
			//	System.out.println("Database Connected");
				
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
				boolean worked=false; //for if get a null because no current flight match requirement
				int choose = 0;
				while(resultSet.next()){
				worked=true;//didnt get null
				int c =resultSet.getInt(5);
				int o =resultSet.getInt(6);
				int remain=c-o;
			//gui button action here subbing it right now with scanner
			//System.out.println("Click on Flight you want");//or enter in flight number
				
				//below prints all flights that match requirement in table-like format
				System.out.println("Flight#\tCost\tSeats Left#\tFlight Time\tFlight Durati"
						+ "on\tFlight Date");
				System.out.println(resultSet.getInt(9)+"\t"+resultSet.getDouble(2)+"\t"
						+ ""+remain+"\t"+resultSet.getTime(8)+"\t"+resultSet.getTime(7)+""
						+ "\t"+resultSet.getDate(4));
				}
				if(worked==false){
					System.out.println("Sorry no flight is available that meets your requirements");
					} // GOOD SPOT TO GO BACK TO HOME PAGE BUTTON OR MAKE VISIBLE
				else {
				System.out.println("Enter in flight number you want"); 
				//can be replace with button;
				boolean x=true;
				while(x){ //loops until valid flightNUm is entered in
					choose =input.nextInt();
					resultSet=statement.executeQuery("SELECT FlightNumber FROM FLIGHT"
							+ " WHERE FlightNumber ="+choose);
					while(resultSet.next())
					x=false; //only can get here if valid flight number
					
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
					statement.execute("UPDATE FLIGHT SET OnFlight ="+mod+" WHERE FlightNumber ="+choose);
						
				}
				else
				{
					System.out.println("Flight is at full capacity"); //Go back to home
				}
				
				
				// if logged in or if logged out after picking flight
				//first if logged in
				boolean logged=false; //this code should be at beginning of program
	
				//logged in is trait of customer
				if(logged){
					System.out.println("You have been successfully added to flight");
					/*new to add flight number to customer at this point
					 * new customerUserName to identify
					 * example of be Consumer c = new Consumer
					 * c.getUserName
					 * then from here do update statement
					 */
				//	Customer c = new Customer();//shouldnt be here
					//********need to add flightNumber to customer
					
					
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
						
						//********need to add flightNumber to customer
					System.out.println("You have been successfully added to flight");
					}
					if(xx==2){
					//insert Adam login method
					System.out.println("Enter in UserName");
					String usser=input.nextLine();
					System.out.println("Enter in Password");
					String pass=input.nextLine();
					if(Database.login( usser, pass)){
					//then think popup
						//********need to add flightNumber to customer
					String query =("UPDATE Customer SET FlightNumber ="+choose+" WHERE CusUserName = '"+usser+"'");
					Database.queryCustomer(query);
					System.out.println("You have been successfully added to flight");
					}
				}
				}
					//********END  BOOK FLIGHT**************
					 }
					 
}

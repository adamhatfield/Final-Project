package flightSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class Home implements Database{
	public static void main(String[] args){
		
		System.out.println("Login");
		System.out.println("Book Flight");
		System.out.println("My Flights");
		System.out.println("Flight Status");
		
		Scanner input = new Scanner(System.in);
		//starting with Book Flight
		
		System.out.println("You are in the booking flights menu\n");
		System.out.println("From");//must be city
		String From = input.nextLine(); //scans full string
		System.out.println("To");//must be city
		String To = input.nextLine();
		System.out.println("Depart Date");//format mm//dd//year
		String Date = input.nextLine();
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
				ResultSet
		}
		
		
	}
}

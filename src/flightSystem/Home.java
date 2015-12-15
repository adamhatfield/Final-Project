package flightSystem;
import java.util.Scanner;
import java.sql.*;

public class Home implements Database,Editting{
	public static void main(String[] args)
			throws Exception {
		final String USER = "root";
		final String PASSWORD = "adamyouknowit";
		Scanner input = new Scanner(System.in);
		
		//main menu
		System.out.println("Login");
		System.out.println("Book Flight");
		System.out.println("My Flights");
		System.out.println("Flight Status");
		
		AdminView.adminView();//AdminView
		BookFlight.bookFlight();//BooksFlight
					 }
					 
}

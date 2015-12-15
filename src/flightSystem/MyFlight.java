package flightSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyFlight implements Database, Editting{
	final static String USER = "root";
	final static String PASSWORD = "adamyouknowit";
	final static String DNAME = "jdbc:mysql://127.0.0.1/project";
	
	
public static void myFlight() throws Exception{
//will need to login in to view
	//first action press
	//after press
	//if not logged 
	Scanner input = new Scanner (System.in);
	Scanner xxx=new Scanner(System.in);
	if(Customer.loggedInUser==null){
		
		//insert adam login method
		//press create a new account or login for now will do scanner
		System.out.println("1.) Create a new account");
		System.out.println("2.) Login");
		int xx= xxx.nextInt();
		//////both I
		if(xx==1){//if click my flight and need to create an account
			//insert ADAM create new customer method
			//fix double print
			int count=0;
			String fn=Editting.scannerFix("Enter in First Name");
			String ln=Editting.scannerFix("Enter in Last Name");
			System.out.println("Enter in SSN");
			int sss=input.nextInt();
			String ad=Editting.scannerFix("Enter in Address");
			System.out.println("Enter in Zip");
			int zip=input.nextInt();
			String cc=Editting.scannerFix("Enter in City");
			String st=Editting.scannerFix("Enter in Full State Name");
			String us=Editting.scannerFix("Enter in User Name");
			String pass=Editting.scannerFix("Enter in Password");
			String ema=Editting.scannerFix("Enter in Email");
			String ssq=Editting.scannerFix("Enter in Security Question");
			String aw=Editting.scannerFix("Enter in Security Question Answer");
			Customer c = new Customer(us,pass,ema,fn,ln,ad,cc,st,zip,sss,ssq,aw);
			Customer.setLogin(us);//thru that method login should become active
			Database.insertNewUser(c, 0);//0 for new users
			xx=2;
			
			//then think popup
		}
		if(xx==2){
			//insert ADAM login GUI
			//thru that method should active login
		}
		
		}
		Customer c = Database.getCustomerInfo(Customer.loggedInUser);
	
		System.out.println("This is the My Flight Menus \n Below see the flights you have book "+c.getLastName());
		int i =0;
		while(i<c.flightNumber.size()){ //prints flights
		System.out.println("Your number "+ (i+1) +" is "+c.flightNumber.get(i));
		i++;
		}
		System.out.println("Want to view more information on a flight? Enter in Flight Number here");
		int chooseF=input.nextInt();
		Flight.printFlight(chooseF);
		//have a go back button
		
		
		//menu
		//from here
		System.out.println("Press 1 if you want to cancel this flight");
		//System.out.println("Press 2 if you want to check for delays"); // dont feel like doing now so greying it out for now lol
		int chooseC=input.nextInt();
		if(chooseC==1){
		System.out.println("Are you sure you want to cancel (Type y for yes or n for no)");
		String ch="Z";
		while(ch.charAt(0)!='y'||ch.charAt(0)!='n'){
		ch = input.next();
		if(ch.charAt(0)=='y')
			//cancel flight
			if(c.flightNumber.size()>1){
				Database.queryCustomer("UPDATE Customer SET PreviousFlights ="+chooseF+ " WHERE CusUserName ='"+c.getUserName()+"'");
				Database.queryCustomer("DELETE FROM Customer WHERE FlightNumber ="+chooseF);
				System.out.println("That Flight has been deleted from your Account");
			}
		}
		}
		//if(chooseC==2){
		
		//}
		
	
	
	
	
}
}

package flightSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminView implements Database,Editting {

	final static String USER = "root";
	final static String PASSWORD = "adamyouknowit";
	
	
	static void adminView() throws ClassNotFoundException, SQLException{
	Scanner input = new Scanner(System.in);
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
	Flight f = new Flight(pick); //pull flight from database with the flightNumber requested and make object of it
	
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
		//case 1:	System.out.println("What will new FlightNumber be");//has to be unique 
		//		a =input.nextInt();
		//		Editting.setFlightNumber(f,a);
		//		break;
		// cant change foreigne key because its primary and foreign. Changing FlightNumber will currently break Customer class
		// can fix this by doing Cascade 
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
	}
}

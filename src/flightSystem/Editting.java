package flightSystem;

import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.Scanner;

public interface Editting {
	
	Scanner s = new Scanner(System.in);
	default void removeFlight(){
	Flight.numOfFlights--;
	}
	default void setFlightNumber(Flight f,int num){
		f.flightNumber =num;
	}
		default int getFlightNumber(Flight f){
		return f.flightNumber;
	}
		default int getFlightCapacity(Flight f){
		return f.flightCapacity;
	}
	default void setFlightCapcity(Flight f,int num){
		 f.flightCapacity=num;
	}

	default void setFlightCost(Flight f, double num){
		f.flightCost=num;
	}
	default double getFlightCost(Flight f){
		return f.flightCost;
	}
	default void setFlightDuration(Flight f,int hrs, int min){
	//	System.out.println("You are are entering in the duration of flight "+ f.flightNumber+ ""
	//			+ "\n Enter in hours first then mintunes.");
//		int hrs = s.nextInt();
//		int min= s.nextInt();
		f.flightDuration= new Time(hrs, min, 0);
	}
	default Time getFlightDuration(Flight f){
		return f.flightDuration;
	}
	default void setFlightDate(Flight f,int year, int month, int day, int hr, int minute){
		f.flightDate = new GregorianCalendar( year,  month,  day,  hr,  minute);
		
	}//You have nothing for arrival to Destination
	default GregorianCalendar getFlightDate(Flight f){
		return f.flightDate;
	}
	default boolean isBooked(Flight f){
		//return true if booked
		boolean a;
		if(f.flightCapacity<=f.onFlight)
			a=true;
		else
			a=false;
		return a;
	}
	default void setFlightDestination (Flight f, String s){
		f.flightDestination=s;
	}
	default String getFlightDestination (Flight f, String s){
		return f.flightDestination;
	}
	default void setFlightStartPoint (Flight f, String s){
		f.flightStartPoint=s;
	}
	default String getFlightStartPoint(Flight f, String s){
		return f.flightStartPoint;
	}

}

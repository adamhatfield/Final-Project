package flightSystem;

import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.Scanner;

public interface Editting {
	
	Scanner s = new Scanner(System.in);
	default void removeFlight(){
	flight.numOfFlights--;
	}
	default void setFlightNumber(flight f,int num){
		f.flightNumber =num;
	}
		default int getFlightNumber(flight f){
		return f.flightNumber;
	}
		default int getFlightCapacity(flight f){
		return f.flightCapacity;
	}
	default void setFlightCapcity(flight f,int num){
		 f.flightCapacity=num;
	}

	default void setFlightCost(flight f, double num){
		f.flightCost=num;
	}
	default double getFlightCost(flight f){
		return f.flightCost;
	}
	default void setFlightDuration(flight f,int hrs, int min){
	//	System.out.println("You are are entering in the duration of flight "+ f.flightNumber+ ""
	//			+ "\n Enter in hours first then mintunes.");
//		int hrs = s.nextInt();
//		int min= s.nextInt();
		f.flightDuration= new Time(hrs, min, 0);
	}
	default Time getFlightDuration(flight f){
		return f.flightDuration;
	}
	default void setFlightDate(flight f,int year, int month, int day, int hr, int minute){
		f.flightDate = new GregorianCalendar( year,  month,  day,  hr,  minute);
		
	}//You have nothing for arrival to Destination
	default GregorianCalendar getFlightDate(flight f){
		return f.flightDate;
	}
	default boolean isBooked(flight f){
		//return true if booked
		boolean a;
		if(f.flightCapacity<=f.onFlight)
			a=true;
		else
			a=false;
		return a;
	}
	default void setFlightDestination (flight f, String s){
		f.flightDestination=s;
	}
	default String getFlightDestination (flight f, String s){
		return f.flightDestination;
	}
	default void setFlightStartPoint (flight f, String s){
		f.flightStartPoint=s;
	}
	default String getFlightStartPoint(flight f, String s){
		return f.flightStartPoint;
	}

}

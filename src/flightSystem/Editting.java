package flightSystem;

import java.sql.Time;
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
	default void setFlightDuration(Flight f,String n){
	
		f.flightDuration= n;
	}
	default String getFlightDuration(Flight f){
		return f.flightDuration;
	}
	default void setFlightDate(Flight f,String date){
		f.flightDate = date;
		
	}//You have nothing for arrival to Destination
	default String getFlightDate(Flight f){
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

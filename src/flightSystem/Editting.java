package flightSystem;

import java.sql.Time;
import java.util.Scanner;

public interface Editting {
	
	Scanner s = new Scanner(System.in);
	
	
	static String scannerFix(String text){
	System.out.println(text);
	String str;
	str=s.nextLine();
	return str;
	}
	static void removeFlight(){
	Flight.numOfFlights--;
	}
	static void setFlightNumber(Flight f,int num){
		f.flightNumber =num;
	}
		static int getFlightNumber(Flight f){
		return f.flightNumber;
	}
		static int getFlightCapacity(Flight f){
		return f.flightCapacity;
	}
	static void setFlightCapacity(Flight f,int num){
		 f.flightCapacity=num;
	}
	static void setOnFlight(Flight f,int num){
		 f.onFlight=num;
	}
	static int getOnFlight(Flight f){
		 return f.onFlight;
	}


	static void setFlightCost(Flight f, double num){
		f.flightCost=num;
	}
	static double getFlightCost(Flight f){
		return f.flightCost;
	}
	static void setFlightTime(Flight f,String n){
		
		f.flightTime= n;
	}
	
	static String getFlightTime(Flight f){
		return f.flightTime;
	}
	static void setFlightDuration(Flight f,String n){
	
		f.flightDuration= n;
	}
	
	static String getFlightDuration(Flight f){
		return f.flightDuration;
	}
	static void setFlightDate(Flight f,String date){
		f.flightDate = date;
		
	}//You have nothing for arrival to Destination
	static String getFlightDate(Flight f){
		return f.flightDate;
	}
	static boolean isBooked(Flight f){
		//return true if booked
		boolean a;
		if(f.flightCapacity<=f.onFlight)
			a=true;
		else
			a=false;
		return a;
	}
	static void setFlightDestination (Flight f, String s){
		f.flightDestination=s;
	}
	static String getFlightDestination (Flight f, String s){
		return f.flightDestination;
	}
	static void setFlightStartPoint (Flight f, String s){
		f.flightStartPoint=s;
	}
	static String getFlightStartPoint(Flight f, String s){
		return f.flightStartPoint;
	}

}

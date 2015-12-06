package flightSystem;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Flight {
	int flightNumber ;
	int flightCapacity =100;
	int onFlight=0;
	String flightDestination ;
	String flightStartPoint;

	//Calendar flightDate;
	GregorianCalendar flightDate; //thing should go into interface for use by admin
	Time flightDuration;  //same
	double flightCost; //same
	static int numOfFlights=0;
	Flight(){
		numOfFlights++;
		flightNumber=999;
		flightDestination= "NoWhere";
		flightStartPoint="NoStart";
		flightDuration= new Time(1,1,0);
		flightDate= new GregorianCalendar(1,1,1,1,1);
		flightCost=1000.99;
		
	}
	Flight(int flightNum,int flightCap, String destination, String start, GregorianCalendar date, Time duration, double cost){
		numOfFlights++;
		flightNumber=flightNum;
		flightCapacity=flightCap;
		flightDestination=destination;
		flightStartPoint=start;
		flightDate=date;
		flightDuration=duration;
		flightCost=cost;
		
		
	}
	/*int getFlightNumber(){
		return this.flightNumber;
	}
	void setFlightNumber(int num){
		this.flightNumber =num;
	}
	int getFlightCapacity(){
		return this.flightCapacity;
	}
	void setFlightCapcity(int num){
		 this.flightCapacity=num;
		
	}	*/
	

}

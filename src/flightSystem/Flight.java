package flightSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Flight { 
	int flightNumber ;
	int flightCapacity =100;
	int onFlight=0;
	String flightDestination ;
	String flightStartPoint;
	String flightDate;
	String flightDuration;  //same
	String flightTime;
	double flightCost; //same
	static int numOfFlights=0;
	
	Flight(int numOfDateBaseFlight) throws ClassNotFoundException, SQLException{
		//MAKES FLIGHT OUT OF DATABASE STORED FLIGHT
		numOfFlights++;
		getFlight(numOfDateBaseFlight);
		
	}
	Flight(int flightNum,int flightCap, int onFl, String destination, String start, String date, String duration, String time, double cost) throws ClassNotFoundException, SQLException{ //create a flight Not in database
		//creates new flight in database first
		String user = "root";
		String password = "adamyouknowit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT into FLIGHT(FlightNumber, FlightDestination,"
				+ " FlightStartPoint, FlightDuration, FlightDate, Flight TIme,"
				+ " FlightCost, FlightCapacity, OnFlight)VALUES ("+flightNum+",'"+destination+"','"+start+"',"+duration+",'"+date+"'"
						+ ",'"+time+"',"+cost+","+flightCap+","+onFl);
		//creation ended
		//after created can use as normal flight that is in database
		numOfFlights++;
		flightNumber=flightNum;
		flightCapacity=flightCap;
		onFlight=onFl;
		flightDestination=destination;
		flightStartPoint=start;
		flightDate=date;
		flightDuration=duration;
		flightTime=time;
		flightCost=cost;
		
		
	}
	void getFlight(int flightNumber) throws ClassNotFoundException, SQLException{ //flightNumber because is primary key
		String user = "root";
		String password = "adamyouknowit";
		
		//Load JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		//Establish connection
		Connection connection = DriverManager.getConnection
			("jdbc:mysql://127.0.0.1/project",user,password);
				//System.out.println("Database Connected");
				
				Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery
						("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
								+ "FlightCapacity, OnFlight, FlightDuration"
								+ ", FlightTime, FlightNumber FROM FLIGHT "
								+ "WHERE FlightNumber ="+flightNumber);
								
				boolean worked=false; //for if get a null because no current flight match requirement
			
				while(resultSet.next()){
					this.flightNumber=flightNumber;
					flightDestination=resultSet.getString(3);
					flightStartPoint=resultSet.getString(1);
					flightCapacity=resultSet.getInt(5);
					onFlight=resultSet.getInt(6);
					flightDate=resultSet.getString(4);
					flightDuration=resultSet.getString(7);
					flightTime=resultSet.getString(8);
					flightCost=resultSet.getDouble(2);
					worked=true;//didnt get null
				}
				if (worked==false)
					System.out.println("Flight number "+flightNumber+" does not exist");
	}
				
					/*int c =resultSet.getInt(5);
					int o =resultSet.getInt(6);
					int remain=c-o; */
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getFlightCapacity() {
		return flightCapacity;
	}
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	public int getOnFlight() {
		return onFlight;
	}
	public void setOnFlight(int onFlight) {
		this.onFlight = onFlight;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public String getFlightStartPoint() {
		return flightStartPoint;
	}
	public void setFlightStartPoint(String flightStartPoint) {
		this.flightStartPoint = flightStartPoint;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public double getFlightCost() {
		return flightCost;
	}
	public void setFlightCost(double flightCost) {
		this.flightCost = flightCost;
	}
	

}

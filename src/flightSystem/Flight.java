package flightSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
		Scanner s = new Scanner(System.in);
		String user = "root";
		String password = "adamyouknowit";
		if(worked(flightNum)){ //worked true means entry already exist
			System.out.println("A flight by this number already exist");
			while(worked(flightNum)){
				System.out.println("Try entering in a new Flight Number");
				flightNum=s.nextInt();
			}
			
		}
		else {
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
		
	}
	boolean worked (int flightNumber) throws ClassNotFoundException, SQLException{
		boolean worked=false;//didnt get anything
		String user = "root";
		String password = "adamyouknowit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT FlightNumber FROM FLIGHT WHERE"
				+ " FlightNumber ="+flightNumber);
		while(resultSet.next())
			worked=true; //got something
		return worked;
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
				
	void printFlight(int flightNum) throws ClassNotFoundException, SQLException	{
		if(worked(flightNum)==false){ //worked true means entry already exist
			System.out.println("A flight by this number does not exist");
			Scanner s = new Scanner(System.in);
			while(worked(flightNum)==false){
				System.out.println("Reenter a valid Flight Number");
				flightNum=s.nextInt();
			}
		}
		else
		{
	
		String user = "root";
		String password = "adamyouknowit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery
				("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
				+ "FlightCapacity, OnFlight, FlightDuration"
				+ ", FlightTime, FlightNumber FROM FLIGHT "
				+ "WHERE FlightNumber ="+flightNumber);
		while(resultSet.next()){
			System.out.println("FlightNumber\tFlightCapacity\tOnFlight\tFlightStartPoint\t"
					+ "FlightDestination\tFlightDate\tFlightTime\tFlightDuration\tFlightPrice");
			System.out.println(resultSet.getInt(9)+"\t"+resultSet.getInt(5)+"\t"+resultSet.getInt(6)+""
					+ "\t"+resultSet.getString(1)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+""
							+ "\t"+resultSet.getString(8)+"\t"+resultSet.getString(7)+"\t"
									+ ""+resultSet.getDouble(2));
			}
		}
	}
	void printFlight() throws ClassNotFoundException, SQLException	{
		String user = "root";
		String password = "adamyouknowit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery
				("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
				+ "FlightCapacity, OnFlight, FlightDuration"
				+ ", FlightTime, FlightNumber FROM FLIGHT");
		while(resultSet.next()){
			System.out.println("FlightNumber\tFlightCapacity\tOnFlight\tFlightStartPoint\t"
					+ "FlightDestination\tFlightDate\tFlightTime\tFlightDuration\tFlightPrice");
			System.out.println(resultSet.getInt(9)+"\t"+resultSet.getInt(5)+"\t"+resultSet.getInt(6)+""
					+ "\t"+resultSet.getString(1)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+""
							+ "\t"+resultSet.getString(8)+"\t"+resultSet.getString(7)+"\t"
									+ ""+resultSet.getDouble(2));
			}
	}
	//not functional yet lol queryFlight
	void queryFlight(String query) throws ClassNotFoundException, SQLException{
		String user = "root";
		String password = "adamyouknowit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",user,password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		//if trying to print results of query
		while(resultSet.next()){
			
		}
		
	}
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

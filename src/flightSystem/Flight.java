package flightSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
	final static String USER = "Admin";
	final static String PASSWORD = "Arson8629";
	
	Flight(){
		
	}
	
	Flight(int numOfDateBaseFlight) throws ClassNotFoundException, SQLException{
		//MAKES FLIGHT OUT OF DATABASE STORED FLIGHT
		numOfFlights++;
		getFlight(numOfDateBaseFlight);
		
	}
	Flight(int flightNum,int flightCap, int onFl, String destination, String start, String date, String duration, String time, double cost) throws ClassNotFoundException, SQLException{ //create a flight Not in database
		//creates new flight in database first
		Scanner s = new Scanner(System.in);
		/** Checks if entered flightnumber already exists in the database
		 * Prompts user to re-enter a flight number using pop up messages
		 * until a valid NEW flightnumber is entered*/
		if(worked(flightNum)){ //worked true means entry already exist
			String flightNumber = JOptionPane.showInputDialog("That flight number already exists, please re-enter the flight number:");
			flightNum = Integer.parseInt(flightNumber);
			while(worked(flightNum)){
				 flightNumber = JOptionPane.showInputDialog("That flight number already exists, please re-enter the flight number:");
				flightNum = Integer.parseInt(flightNumber);
			}
			
		}
		else {
			flightDate=date;
			flightDuration=duration;
			flightTime=time;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT into FLIGHT(FlightNumber, FlightDestination,"
				+ " FlightStartPoint, FlightDuration, FlightDate, Flight TIme,"
				+ " FlightCost, FlightCapacity, OnFlight)VALUES ("+flightNum+",'"+destination+"','"+start+"',"+this.insertDurationD()+","+this.insertDateD()+""
						+ ","+this.insertTimeD()+","+cost+","+flightCap+","+onFl);
		//creation ended
		//after created can use as normal flight that is in database
		numOfFlights++;
		flightNumber=flightNum;
		flightCapacity=flightCap;
		onFlight=onFl;
		flightDestination=destination;
		flightStartPoint=start;
		//flightDate=date;
		//flightDuration=duration;
		//flightTime=time;
		flightCost=cost;
		}
		
	}
	String insertTimeD(){ //makse sure no code inserts time or date as String into database..wont work
		String time ="";
		time = time +(this.flightTime.substring(0,2));
		time = time +(this.flightTime.substring(3, 5));
		time = time +(this.flightTime.substring(6));
		return time;
	}
	String insertDurationD(){ //makse sure no code inserts time or date as String into database..wont work
		String time= "";
		time = time +(this.flightDuration.substring(0,2));
		time = time +(this.flightDuration.substring(3, 5));
		time = time +(this.flightDuration.substring(6));
		return time;
	}
	String insertDateD(){ //makse sure no code inserts time or date as String into database..wont work
		String time="";
		time = time +(this.flightDate.substring(0,4));
		time = time +(this.flightDate.substring(5, 7));
		time = time +(this.flightDate.substring(8));
		return time;
	}
	
	void databaseFlight() throws ClassNotFoundException, SQLException{
		Scanner s = new Scanner(System.in);
		if(worked(this.flightNumber)){ //worked true means entry already exist
			System.out.println("A flight by this number already exist\n"
					+ "Are you sure you want to OVERWRITE. If so press 1 or press 2 for NO");}
			int yes=s.nextInt();
			if(yes==1){
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("UPDATE FLIGHT SET FlightNumber ="+this.flightNumber+" FlightDestination ='"+this.flightDestination+"'"
						+ " FlightStartPoint = '"+this.flightStartPoint+"' FlightDuration = "+this.insertDurationD()+" "
								+ "FlightDate = "+this.insertDateD()+" FlightTime = "+this.insertTimeD()+" FlightCost = "+this.flightCost+" "
										+ "FlightCapacity = "+this.flightCapacity+" OnFlight ="+this.onFlight+" WHERE FlightNumber"
												+ " = "+this.flightNumber);
				
				
	}
	}
	
	public void deleteFlight(int flightNum) throws ClassNotFoundException, SQLException{
		String query =("DELETE FROM Flight WHERE FlightNumber ="+flightNum);
		queryFlight(query);
	}
	
	public static boolean worked (int flightNumber) throws ClassNotFoundException, SQLException{
		boolean worked=false;//didnt get anything
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT FlightNumber FROM FLIGHT WHERE"
				+ " FlightNumber ="+flightNumber);
		while(resultSet.next())
			worked=true; //got something
		return worked;
	}
	public void getFlight(int flightNumber) throws ClassNotFoundException, SQLException{ //flightNumber because is primary key
		//tested
		Scanner s = new Scanner(System.in);
		//Load JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		//Establish connection
		Connection connection = DriverManager.getConnection
			("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
				//System.out.println("Database Connected");
				
				Statement statement = connection.createStatement();
				
				while(worked(flightNumber)==false){//for if get a null because no current flight match requirement
					System.out.println("Reenter a valid Flight Number");
					flightNumber=s.nextInt();}
				ResultSet resultSet = statement.executeQuery
						("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
								+ "FlightCapacity, OnFlight, FlightDuration"
								+ ", FlightTime, FlightNumber FROM FLIGHT "
								+ "WHERE FlightNumber ="+flightNumber);
								
				//might not want this
				
				//might not want this stop
				//if decide to replace add worked=false back
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
				//	worked=true;//didnt get null
				}
				//if (worked==false)
				//	System.out.println("Flight number "+flightNumber+" does not exist");
	}
				
	 public static void printFlight(int flightNum) throws ClassNotFoundException, SQLException	{
		if(worked(flightNum)==false){ //worked true means entry already exist
			System.out.println("A flight by this number does not exist");
			Scanner s = new Scanner(System.in);
			while(worked(flightNum)==false){
				//String flightNumber = JOptionPane.showMessageDialog(null,"Reenter a valid Flight Number");
				flightNum=s.nextInt();
			}
		}
		else
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery
				("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
				+ "FlightCapacity, OnFlight, FlightDuration"
				+ ", FlightTime, FlightNumber FROM FLIGHT "
				+ "WHERE FlightNumber ="+flightNum);
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
	public void printFlight() throws ClassNotFoundException, SQLException	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery
				("SELECT FlightStartPoint, FlightCost, FlightDestination, FlightDate, "
				+ "FlightCapacity, OnFlight, FlightDuration"
				+ ", FlightTime, FlightNumber FROM FLIGHT");
		int i=0; //just for count
		System.out.println("FlightNumber\tFlightCapacity\tOnFlight\tFlightStartPoint\t"
				+ "FlightDestination\tFlightDate\tFlightTime\tFlightDuration\tFlightPrice");
		while(resultSet.next()){
			System.out.println(++i +").\t"+resultSet.getInt(9)+"\t"+resultSet.getInt(5)+"\t"+resultSet.getInt(6)+""
					+ "\t"+resultSet.getString(1)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+""
							+ "\t"+resultSet.getString(8)+"\t"+resultSet.getString(7)+"\t"
									+ ""+resultSet.getDouble(2));
			}
	}
	//found purpose
	//for quick updates
	 public void queryFlight(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project",USER,PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		//if trying to print results of query
		//while(resultSet.next()){
			
		//}
		
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
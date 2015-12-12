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
		numOfFlights++;
		getFlight(numOfDateBaseFlight);
		
	}
	Flight(int flightNum,int flightCap, String destination, String start, String date, String duration, double cost){
		numOfFlights++;
		flightNumber=flightNum;
		flightCapacity=flightCap;
		flightDestination=destination;
		flightStartPoint=start;
		flightDate=date;
		flightDuration=duration;
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

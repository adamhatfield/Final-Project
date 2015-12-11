package flightSystem;
import java.sql.*;

public class test {
	
	
	  public static void main(String[] args)
		      throws SQLException, ClassNotFoundException {
		    // Load the JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded");
	
		    // Establish a connection
		    Connection connection = DriverManager.getConnection
		      ("jdbc:mysql://Home/project");
		    System.out.println("Database connected");
		
		    // Create a statement
		    Statement statement = connection.createStatement();
		
		    // Execute a statement
		    ResultSet resultSet = statement.executeQuery
		      ("select FlightNumber from flight");
		
		    // Iterate through the result and print the student names
		    while (resultSet.next())
		      System.out.println(resultSet.getString(1));
		
		    // Close the connection
		    connection.close();
		  }
		}





package flightSystem;
/**
 * This class creates a customer constructor for a flight booking system
 * Customers have a first name, last name, ssn, address, state of residence, zip, email ,username, password, and security question and answer
 * Customers can book flights, view flights, and remove flights previously booked
 * @author Adam Hatfield
 *
 */

public class Customer extends Person {
	private String userName;
	private String password;
	private String emailAddress;
	private String securityQuestion;
	private String securityQuestionAnswer;
	private String account;
	
	//Default no-arg Constructor
	public Customer(){
		
	}
	//Creates a customer objects with specified name, address, social security number, username and password
	public Customer(String newFirstName,String newLastName, int newSSN, String newAddress, String newState, int newZipCode, String newUserName,
			String newPassword){
		super.setFirstName(newFirstName);
		super.setLastName(newLastName);
		super.setSSN(newSSN);
		super.setAddress(newAddress);
		super.setZipCode(newZipCode);
		super.setZipCode(newZipCode);
		this.userName = newUserName;
		this.password = newPassword;
		
	}
	//Method that returns username
	public String getUserName(){
		return userName;
	}
	//Method that resets the user name of a customer
	public void setUserName(String newUserName){
		this.userName = newUserName;
	}
	//Method that resets a users password for the account
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	//Method that returns a customers email address
	public String getEmailAddress(){
		return emailAddress;
	}
	//Method that allows a user to change their email address
	public void setEmailAddress(String newEmailAddress){
		
	}
	
	
	

}

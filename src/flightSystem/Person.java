package flightSystem;
/**
 * Abstract class required to create a customer in the customer class. This contains all personal information relevant to a person
 * 
 * @author Arson
 *
 */
public abstract class Person {
	
	private String firstName;
	private String lastName;
	private String address;
	private int zipCode;
	private String state;
	private int ssn;
	//Default Person constructor
	public Person(){
		
	}
	
	public Person(String newFirstName, String newLastName, String newAddress, int newZipCode, String newState, int newSSN){
		firstName = newFirstName;
		lastName = newLastName;
		address = newAddress;
		zipCode = newZipCode;
		state = newState;
		ssn = newSSN;
	}
	//Returns the first name of a person
	public String getFirstName(){
		return firstName;
	}
	//Sets the first name of a person
	public void setFirstName( String newFirstName){
		firstName = newFirstName;
		
	}
	//Returns last name of a person
	public String getLastName(){
		return lastName;
	}
	//Sets the last name of a person
	public void setLastName(String newLastName){
		lastName = newLastName;
	}
	//Returns a persons address
	public String getAddress(){
		return address;
	}
	//Sets a persons address
	public void setAddress(String newAddress){
		address = newAddress;
	}
	//Returns the zipcode of person
	public int getZipCode(){
		return zipCode;
	}
	//Sets the zipcode of a person
	public void setZipCode(int newZipCode){
		zipCode = newZipCode;
	}
	
	public String getState(){
		return state;
	}
	
	public void setState(String newState){
		state = newState;
	}

}

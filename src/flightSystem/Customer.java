
package flightSystem;
/**
 * This class creates a customer constructor for a flight booking system
 * Customers have a first name, last name, ssn, address, state of residence, zip, email ,username, password, and security question and answer
 * Customers can book flights, view flights, and remove flights previously booked
 * @author Adam Hatfield
 *
 */

public class Customer extends Person implements Database {
	private String userName;
	private String password;
	private String emailAddress;
	private String securityQuestion;
	private String securityQuestionAnswer;
	private int accountNumber;
	
	/**Default no-arg Constructor*/
	public Customer(){
		
	}
	/**Creates a customer objects with specified name, address, social security number, username and password
	 * For the new user tab
	 * */
	public Customer(String newUserName,String newPassword,String newEmailAddress,String newFirstName,String newLastName,String newAddress,
			String newCity,String newState, int newZipCode, int newSSN,String newSecurityQuestion,String newSecurityAnswer){
		super.setFirstName(newFirstName);
		super.setLastName(newLastName);
		super.setSSN(newSSN);
		super.setAddress(newAddress);
		super.setZipCode(newZipCode);
		super.setCity(newCity);
		super.setState(newState);
		this.userName = newUserName;
		this.password = newPassword;
		this.emailAddress = newEmailAddress;
		this.accountNumber = (int) (1000 + Math.random() * 9000);

	}
	/**
	 * Creates customer object copy from existing object. 
	 * @param newAccountNumber
	 * @param newUserName
	 * @param newPassword
	 * @param newEmailAddress
	 * @param newFirstName
	 * @param newLastName
	 * @param newAddress
	 * @param newCity
	 * @param newState
	 * @param newZipCode
	 * @param newSSN
	 * @param newSecurityQuestion
	 * @param newSecurityAnswer
	 */
	public Customer(Customer c){ //Whats this? customer that makes customer
		super.setFirstName(c.getFirstName());
		super.setLastName(c.getLastName());
		super.setSSN(c.getSSN());
		super.setAddress(c.getAddress());
		super.setZipCode(c.getZipCode());
		super.setCity(c.getCity());
		super.setState(c.getState());
		this.userName = c.getUserName();
		this.password = c.getPassword();
		this.emailAddress = c.getEmailAddress();
		this.accountNumber = c.getAccountNumber();
		this.securityQuestion = c.getSecurityQuestion();
		this.securityQuestionAnswer = c.getSecurityQuestionAnswer();
		
	}
	//Customer(){}
	
	/**
	 * Creates customer object from outputs of database. System holds this object until the customer logouts.
	 * @param newAccountNumber
	 * @param newUserName
	 * @param newPassword
	 * @param newEmailAddress
	 * @param newFirstName
	 * @param newLastName
	 * @param newAddress
	 * @param newCity
	 * @param newState
	 * @param newZipCode
	 * @param newSSN
	 * @param newSecurityQuestion
	 * @param newSecurityAnswer
	 */
	
	public Customer(int newAccountNumber,String newUserName, String newPassword,String newEmail, String newFirstName, String newLastName, String newAddress, 
			String newCity, String newState, int newZip,int newSSN,String newSecurityQuestion,String newAnswer){
		super.setFirstName(newFirstName);
		super.setLastName(newLastName);
		super.setSSN(newSSN);
		super.setAddress(newAddress);
		super.setZipCode(newZip);
		super.setCity(newCity);
		super.setState(newState);
		this.userName = newUserName;
		this.password = newPassword;
		this.emailAddress = newEmail;
		this.accountNumber = newAccountNumber;
		this.securityQuestion = newSecurityQuestion;
		this.securityQuestionAnswer = newAnswer;
		
	}
	/**Method that returns username*/
	public String getUserName(){
		return userName;
	}
	/**Method that resets the user name of a customer*/
	public void setUserName(String newUserName){
		this.userName = newUserName;
		
	}
	protected String getPassword(){
		return password;
	}
	/**Method that resets a users password for the account*/
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	/**Method that returns a customers email address*/
	public String getEmailAddress(){
		return emailAddress;
	}
	/**Method that allows a user to change their email address*/
	public void setEmailAddress(String newEmailAddress){
		this.emailAddress = newEmailAddress;
	}
	/**Set a new security question*/
	public void setSecurityQuestion(String newSecurityQuestion){
		securityQuestion = newSecurityQuestion;
	}
	/**Getter for security question*/
	public String getSecurityQuestion(){
		return securityQuestion;
	}
	/**Setter for security question answer*/
	public void setSecurityQuestionAnswer(String newSecurityQuestionAnswer){
		this.securityQuestionAnswer = newSecurityQuestionAnswer;
	}
	/**Getter for security question answer*/
	public String getSecurityQuestionAnswer(){
		return securityQuestionAnswer;
	}
	/**Getter for account number*/
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public void customerString( Customer c){
		System.out.println(c.getAccountNumber()+ " \n"+c.getUserName()+" \n"+c.getPassword()+"\n"+c.getEmailAddress()+" \n"+c.getFirstName()+"\n"
				+c.getLastName()+" \n"+c.getAddress()+"\n"+c.getCity()+"\n"+c.getState()+"\n"+c.getSecurityQuestion()+"\n"+c.getSecurityQuestionAnswer()+"\n"+c.getSSN());
	}
	
	
	
	
	

}

package flightSystem;

public class Admin extends Customer implements Editting {
	private String adminUserName;
	private String adminPassword;
	
	
	//Default no arg constructor
	public Admin(){
		
	}
	/**
	 * This constructor creates an admin object
	 * @param adminUserName
	 * @param adminPassword
	 * @param newFirstName
	 * @param newLastName
	 * @param newSSN
	 * @param newAddress
	 * @param newState
	 * @param newZipCode
	 */
	public Admin(String adminUserName, String adminPassword, String newFirstName,String newLastName, int newSSN, String newAddress, String newState, int newZipCode){
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		super.setFirstName(newFirstName);
		super.setLastName(newLastName);
		super.setSSN(newSSN);
		super.setAddress(newAddress);
		super.setState(newState);
		super.setZipCode(newZipCode);
		
	}
	
	

}

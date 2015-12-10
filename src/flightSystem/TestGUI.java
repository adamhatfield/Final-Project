package flightSystem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.sql.*;
import java.text.NumberFormat;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class TestGUI extends JFrame implements Database {
	private JPanel panelLogin;
	private JPanel panelNewUser;
	private JPanel panelUserView;
	private JTextField jtfUserName;
	private JTextField jtfPassword;
	private JTextField jtfFirstName;
	private JTextField jtfLastName;
	private JTextField jtfStreetAddress;
	private JTextField jtfState;
	private JFormattedTextField jtfZipCode;
	private JTextField jtfSsn;
	private JTextField jtfEnterSecurityQuestion;
	private JTextField jtfSecurityQuestionAnswer;
	private JTextField jtfEmailAddress;
	private JTextField jtfCity;
	private JLabel lblZipCode;
	private JLabel lblUserName;
	private JLabel lblPassword_1;
	private JLabel lblEmailAddress_1;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblStreetAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblSsn;
	private JLabel lblSecuritQuestion;
	private JLabel lblAnswer;
	private JButton btnLogout;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panelPasswordReset;
	private JTextField textField_1;
	protected Customer customer = new Customer();
	
	
	public TestGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		/**Login Panel*/
		final JPanel panelLogin = new JPanel();
		getContentPane().add(panelLogin, "Login Window");
		panelLogin.setLayout(null);
		
		/** New User Screen*/
		final JPanel panelNewUser = new JPanel();
		getContentPane().add(panelNewUser, "New User Window");
		panelNewUser.setLayout(null);
		panelNewUser.setVisible(false);
		
		/**Main Menu*/
		final JPanel panelUserView = new JPanel();
		getContentPane().add(panelUserView, "Main Menu");
		panelUserView.setLayout(null);
		
		/**Logout button for main menu, returns user to login window*/
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserView.setVisible(false);
				panelLogin.setVisible(true);
				
			}
		});
		btnLogout.setBounds(390, 19, 117, 29);
		panelUserView.add(btnLogout);
		panelUserView.setVisible(false);
		
		
		/**Email Address text field for login window*/
		JLabel lblEmailAddress = new JLabel("User Name");
		lblEmailAddress.setBounds(27, 50, 113, 16);
		panelLogin.add(lblEmailAddress);
		
		textField = new JTextField();
		textField.setBounds(10, 65, 130, 26);
		panelLogin.add(textField);
		textField.setColumns(10);
		
		/**Password text field for login window*/
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 103, 61, 16);
		panelLogin.add(lblPassword);
		/**Password text field*/
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 120, 130, 26);
		panelLogin.add(passwordField);
		
		/**Ok button and listener*/
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = textField.getText();
				String password = passwordField.getText();
				System.out.println(userName+ " " +password);
				
				if(login(userName,password)){
					panelUserView.setVisible(true);
					panelLogin.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "Check username and password");
				}
				
				
			}
		});
		btnOk.setBounds(10, 158, 117, 29);
		panelLogin.add(btnOk);
		
		
		
		/**New User Label*/
		JLabel lblNewUsers = new JLabel("New Users");
		lblNewUsers.setBounds(395, 50, 78, 16);
		panelLogin.add(lblNewUsers);
		
		/**Create account button, login screen*/
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewUser.setVisible(true);
				panelLogin.setVisible(false);
				
			}
		});
		btnCreateAccount.setBounds(373, 75, 130, 29);
		panelLogin.add(btnCreateAccount);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPasswordReset.setVisible(true);
				panelLogin.setVisible(false);
			}
		});
		btnResetPassword.setBounds(373, 142, 130, 29);
		panelLogin.add(btnResetPassword);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setBounds(383, 125, 108, 16);
		panelLogin.add(lblForgotPassword);
		
		
	
		
		/**Registration page label*/
		JLabel lblUserRegistrationPage = new JLabel("User Registration Page");
		lblUserRegistrationPage.setBounds(181, 6, 141, 16);
		panelNewUser.add(lblUserRegistrationPage);
		
		/**New user info label*/
		JLabel lblNewUserInfo = new JLabel("Please enter the following information");
		lblNewUserInfo.setBounds(27, 33, 260, 16);
		panelNewUser.add(lblNewUserInfo);
		
		/**User name text field*/
		jtfUserName = new JTextField();
		jtfUserName.setBounds(26, 53, 130, 26);
		panelNewUser.add(jtfUserName);
		jtfUserName.setColumns(10);
		/**Password text field*/
		jtfPassword = new JTextField();
		jtfPassword.setBounds(26, 83, 130, 26);
		panelNewUser.add(jtfPassword);
		jtfPassword.setColumns(10);
		/**FirstName text field*/
		jtfFirstName = new JTextField();
		jtfFirstName.setBounds(26, 150, 130, 26);
		panelNewUser.add(jtfFirstName);
		jtfFirstName.setColumns(10);
		/**Last Name Text field*/
		jtfLastName = new JTextField();
		jtfLastName.setBounds(26, 177, 130, 26);
		panelNewUser.add(jtfLastName);
		jtfLastName.setColumns(10);
		/**Street Address Text Field*/
		jtfStreetAddress = new JTextField();
		jtfStreetAddress.setBounds(26, 204, 130, 26);
		panelNewUser.add(jtfStreetAddress);
		jtfStreetAddress.setColumns(10);
		/**City Text Field*/
		jtfCity = new JTextField();
		jtfCity.setBounds(26, 228, 130, 26);
		panelNewUser.add(jtfCity);
		jtfCity.setColumns(10);
		/**State Text Field*/
		jtfState = new JTextField();
		jtfState .setBounds(27, 254, 130, 26);
		panelNewUser.add(jtfState);
		jtfState .setColumns(10);
		/**ZipCode Text Field*/
		jtfZipCode  = new JFormattedTextField();
		jtfZipCode.setBounds(27, 281, 130, 26);
		panelNewUser.add(jtfZipCode);
		jtfZipCode.setColumns(10);
		/**SSN text field*/
		jtfSsn = new JTextField();
		jtfSsn.setBounds(27, 308, 130, 26);
		panelNewUser.add(jtfSsn);
		jtfSsn.setColumns(10);
		/**Security Question Text Field*/
		jtfEnterSecurityQuestion = new JTextField();
		jtfEnterSecurityQuestion.setBounds(27, 336, 348, 26);
		panelNewUser.add(jtfEnterSecurityQuestion);
		jtfEnterSecurityQuestion.setColumns(10);
		/**Security Question Answer TextField*/
		jtfSecurityQuestionAnswer = new JTextField();
		jtfSecurityQuestionAnswer.setBounds(27, 363, 178, 26);
		panelNewUser.add(jtfSecurityQuestionAnswer);
		jtfSecurityQuestionAnswer.setColumns(10);
		/**Email Address Text Field*/
		jtfEmailAddress = new JTextField();
		jtfEmailAddress.setBounds(26, 112, 130, 26);
		panelNewUser.add(jtfEmailAddress);
		jtfEmailAddress.setColumns(10);
		/**
		 * Action Listener for create account button
		 * Takes all text fields and converts value to string
		 * Invokes the insertNewUser method from database interface to add user to database
		 */
		JButton createNewUser = new JButton("Create Account");
		createNewUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int accountNumber =(int) (1000 + Math.random() * 9000);
				String firstName = jtfFirstName.getText();
				String LastName = jtfLastName.getText();
				String userName = jtfUserName.getText();
				String password = jtfPassword.getText();
				String emailAddress = jtfEmailAddress.getText();
				String securityAnswer = jtfSecurityQuestionAnswer.getText();
				String securityQuestion = jtfEnterSecurityQuestion.getText();
				String address = jtfStreetAddress.getText();
				String city = jtfCity.getText();
				String state = jtfState.getText();
				String zip = jtfZipCode.getText();
				String SSN = jtfSsn.getText();
				
				Customer c = new Customer(accountNumber,userName,password,emailAddress,firstName,LastName,address,city,state,zip,SSN,securityQuestion,securityAnswer);
				insertNewUser(c);
				panelNewUser.setVisible(false);
				panelUserView.setVisible(true);
			}
		});
		createNewUser.setBounds(383, 377, 130, 29);
		panelNewUser.add(createNewUser);
		
		lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(160, 286, 61, 16);
		panelNewUser.add(lblZipCode);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(160, 58, 73, 16);
		panelNewUser.add(lblUserName);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(160, 88, 61, 16);
		panelNewUser.add(lblPassword_1);
		
		lblEmailAddress_1 = new JLabel("Email Address");
		lblEmailAddress_1.setBounds(160, 117, 101, 16);
		panelNewUser.add(lblEmailAddress_1);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(160, 155, 73, 16);
		panelNewUser.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(160, 182, 73, 16);
		panelNewUser.add(lblLastName);
		
		lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(160, 209, 91, 16);
		panelNewUser.add(lblStreetAddress);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(160, 233, 61, 16);
		panelNewUser.add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(160, 259, 61, 16);
		panelNewUser.add(lblState);
		
		lblSsn = new JLabel("SSN");
		lblSsn.setBounds(160, 313, 61, 16);
		panelNewUser.add(lblSsn);
		
		lblSecuritQuestion = new JLabel("Security Question");
		lblSecuritQuestion.setBounds(387, 336, 126, 16);
		panelNewUser.add(lblSecuritQuestion);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(215, 368, 61, 16);
		panelNewUser.add(lblAnswer);
		
		/**Back button for new user page, takes back to login window*/
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewUser.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 388, 117, 29);
		panelNewUser.add(btnNewButton);
		
		panelPasswordReset = new JPanel();
		getContentPane().add(panelPasswordReset, "name_19672340689757");
		panelPasswordReset.setLayout(null);
		
		JLabel lblEnterYouPassword = new JLabel("Enter your Username:");
		lblEnterYouPassword.setBounds(38, 87, 168, 16);
		panelPasswordReset.add(lblEnterYouPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(38, 109, 168, 26);
		panelPasswordReset.add(textField_1);
		textField_1.setColumns(10);
		/**
		 * Button and action listerner for reset password.
		 * When user hits view security question a pop window appears with the matching security question to their account
		 * 
		 * If the username does not match any in the database the application prompts the user with a pop window
		 * asking them to check their username
		 * 
		 * If the user does not input the right answer to their security question a pop up window appears asking them to 
		 * check their answer to the question.
		 */
		JButton btnViewSecurityQuestion = new JButton("View Security Question");
		btnViewSecurityQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField_1.getText();
				
					try{
						customer = new Customer(getCustomerInfo(userName));
						if(customer.getUserName().equals(userName)){
							String answer = JOptionPane.showInputDialog( customer.getSecurityQuestion());
							if(customer.getSecurityQuestionAnswer().equals(answer)){
								String updatedPassword = JOptionPane.showInputDialog("Enter a new password:");
								customer.setPassword(updatedPassword);
								updatePassword(customer.getUserName(),updatedPassword );
								JOptionPane.showMessageDialog(null, "Your password has been changed.");
								panelPasswordReset.setVisible(false);
								panelLogin.setVisible(true);
								
								
							}else{
								JOptionPane.showMessageDialog(null, "Check answer to security question,");
							}
						}else{
							JOptionPane.showMessageDialog(null, "No user with that specific username was found.");
						}
						
						
						
						
						
						
						
					}catch(NullPointerException n){
						System.out.println("No user found:");
					}catch(Exception e1){
						e1.printStackTrace();
					}
			}
				
				
			
		});
		btnViewSecurityQuestion.setBounds(38, 147, 168, 29);
		panelPasswordReset.add(btnViewSecurityQuestion);
		
		
	}
}

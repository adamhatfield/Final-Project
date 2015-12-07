package flightSystem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.sql.*;

public class TestGUI extends JFrame implements Database {
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelLogin;
	private JPanel panelNewUser;
	private JPanel panelUserView;
	private JTextField jtfUserName;
	private JTextField jtfPassword;
	private JTextField jtfFirstName;
	private JTextField jtfLastName;
	private JTextField jtfStreetAddress;
	private JTextField jtfState;
	private JTextField jtfZipCode;
	private JTextField jtfSsn;
	private JTextField jtfEnterSecurityQuestion;
	private JTextField jtfSecurityQuestionAnswer;
	private JTextField jtfEmailAddress;
	private JTextField jtfCity;
	
	
	public TestGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		/**Login Panel*/
		final JPanel panelLogin = new JPanel();
		getContentPane().add(panelLogin, "name_25928878208141");
		panelLogin.setLayout(null);
		panelLogin.setVisible(true);
		
		/** New User Screen*/
		final JPanel panelNewUser = new JPanel();
		getContentPane().add(panelNewUser, "name_25947135937202");
		panelNewUser.setLayout(null);
		panelNewUser.setVisible(false);
		
		/**User view*/
		final JPanel panelUserView = new JPanel();
		getContentPane().add(panelUserView, "name_25940417847003");
		
		JMenuItem mntmFlights = new JMenuItem("Search Flights");
		panelUserView.add(mntmFlights);
		
		JMenuItem mntmBookedFlights = new JMenuItem("Booked Flights");
		panelUserView.add(mntmBookedFlights);
		
		JMenuItem mntmMyAccount = new JMenuItem("My Account");
		panelUserView.add(mntmMyAccount);
		panelUserView.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mntmFlights, mntmBookedFlights, mntmMyAccount}));
		panelUserView.setVisible(false);
		
		/**Email Address text field for login window*/
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(27, 50, 113, 16);
		panelLogin.add(lblEmailAddress);
		textField = new JTextField();
		textField.setBounds(25, 65, 130, 26);
		panelLogin.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 103, 61, 16);
		panelLogin.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 131, 130, 26);
		panelLogin.add(textField_1);
		textField_1.setColumns(10);
		/**Ok button and listener*/
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserView.setVisible(true);
				panelLogin.setVisible(false);
				
			}
		});
		btnOk.setBounds(27, 169, 117, 29);
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
	
		
		/**Registration page label*/
		JLabel lblUserRegistrationPage = new JLabel("User Registration Page");
		lblUserRegistrationPage.setBounds(181, 6, 141, 16);
		panelNewUser.add(lblUserRegistrationPage);
		
		/**New user info label*/
		JLabel lblNewUserInfo = new JLabel("Please enter the following information");
		lblNewUserInfo.setBounds(27, 33, 260, 16);
		panelNewUser.add(lblNewUserInfo);
		
		
		jtfUserName = new JTextField();
		jtfUserName.setBounds(26, 53, 130, 26);
		jtfUserName.setText("User Name");
		panelNewUser.add(jtfUserName);
		jtfUserName.setColumns(10);
		
		jtfPassword = new JTextField();
		jtfPassword.setText("Password");
		jtfPassword.setBounds(26, 83, 130, 26);
		panelNewUser.add(jtfPassword);
		jtfPassword.setColumns(10);
		
		jtfFirstName = new JTextField();
		jtfFirstName.setText("First Name");
		jtfFirstName.setBounds(26, 150, 130, 26);
		panelNewUser.add(jtfFirstName);
		jtfFirstName.setColumns(10);
		
		jtfLastName = new JTextField();
		jtfLastName.setText("Last Name");
		jtfLastName.setBounds(26, 177, 130, 26);
		panelNewUser.add(jtfLastName);
		jtfLastName.setColumns(10);
		
		jtfStreetAddress = new JTextField();
		jtfStreetAddress.setText("Street Address");
		jtfStreetAddress.setBounds(26, 204, 130, 26);
		panelNewUser.add(jtfStreetAddress);
		jtfStreetAddress.setColumns(10);
		
		jtfCity = new JTextField();
		jtfCity.setText("City");
		jtfCity.setBounds(26, 228, 130, 26);
		panelNewUser.add(jtfCity);
		jtfCity.setColumns(10);
		
		jtfState = new JTextField();
		jtfState .setText("State");
		jtfState .setBounds(27, 254, 130, 26);
		panelNewUser.add(jtfState);
		jtfState .setColumns(10);
		
		jtfZipCode  = new JTextField();
		jtfZipCode.setText("Zip Code");
		jtfZipCode.setBounds(27, 281, 130, 26);
		panelNewUser.add(jtfZipCode);
		jtfZipCode.setColumns(10);
		
		jtfSsn = new JTextField();
		jtfSsn.setText("SSN");
		jtfSsn.setBounds(27, 308, 130, 26);
		panelNewUser.add(jtfSsn);
		jtfSsn.setColumns(10);
		
		jtfEnterSecurityQuestion = new JTextField();
		jtfEnterSecurityQuestion.setText("Enter Security Question");
		jtfEnterSecurityQuestion.setBounds(27, 336, 348, 26);
		panelNewUser.add(jtfEnterSecurityQuestion);
		jtfEnterSecurityQuestion.setColumns(10);
		
		jtfSecurityQuestionAnswer = new JTextField();
		jtfSecurityQuestionAnswer.setText("Security Question Answer");
		jtfSecurityQuestionAnswer.setBounds(27, 363, 178, 26);
		panelNewUser.add(jtfSecurityQuestionAnswer);
		jtfSecurityQuestionAnswer.setColumns(10);
		
		jtfEmailAddress = new JTextField();
		jtfEmailAddress.setText("Email Address");
		jtfEmailAddress.setBounds(26, 112, 130, 26);
		panelNewUser.add(jtfEmailAddress);
		jtfEmailAddress.setColumns(10);
		
		JButton createNewUser = new JButton("Create Account");
		createNewUser.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent e) {
				
				insertNewUser(firstName,LastName,userName,password,emailAddress,securityAnswer,securityQuestion,address,city,state,zip,SSN);
				
			}
		});
		createNewUser.setBounds(383, 377, 130, 29);
		panelNewUser.add(createNewUser);
		
		JPanel panelUserInfo = new JPanel();
		getContentPane().add(panelUserInfo, "name_33387852169015");
		
		
	}
	
	
}

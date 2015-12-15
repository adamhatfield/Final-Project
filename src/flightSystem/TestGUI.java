package flightSystem;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
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

import java.awt.Component;
import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TestGUI extends JFrame implements Database {
	private JPanel panelLogin;
	private JPanel panelNewUser;
	private JPanel panelUserView;
	private JPanel panelEditFlights;
	private JPanel panelSearchFlight;
	private JPanel panelAddFlight;
	private JPanel panelUserView_1;
	private JTextField jtfUserName;
	private JTextField jtfFirstName;
	private JTextField jtfLastName;
	private JTextField jtfStreetAddress;
	private JTextField jtfState;
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
	private JTextField jtfUserLogin;
	private JPasswordField passwordField;
	private JPanel panelPasswordReset;
	private JTextField textField_1;
	protected Customer customer = new Customer();
	private JButton btnBack;
	private JTextField jtfZipCode;
	private JTextField jtfSSN;
	private JTextField jtfDepartureField;
	private JTextField jtfDestinationField;
	private JPanel panelSearchResults;
	protected Customer c;
	protected Flight f;
	private JPasswordField jtfPassword;
	private JTextField jtfDepartureDate;
	private JButton btnDeleteFlight;
	private JLabel lblPressTheOption;
	private JButton btnBack_1;
	private JTextField jtfAddFlightNumber;
	private JTextField txtFlightCapacity;
	private JButton btnEditFlights;
	private JButton btnBack_2;
	private JTextField txtOnFlight;
	private JTextField txtDestination;
	private JTextField txtDeparture;
	private JTextField txtDate;
	private JTextField txtFlightDuration;
	private JTextField txtFlightTime;
	private JTextField txtFlightCost;
	private JButton btnEditFlight;
	private JButton btnCreateFlight;
	protected ArrayList<Flight> flightArray = new ArrayList<>();
	protected ArrayList<Customer> customerArray = new ArrayList<>();
	private JPanel panelViewFlights;
	private JList list;
	private JTextField textField;
	private JButton btnNewButton_1;
	
	public TestGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		/**Login Panel*/
		 JPanel panelLogin = new JPanel();
		getContentPane().add(panelLogin, "Login Window");
		
		/** New User Screen*/
		 JPanel panelNewUser = new JPanel();
		getContentPane().add(panelNewUser, "New User Window");
		panelNewUser.setVisible(false);
		/*******************************************************************************
		 * panelEditFlights allows an admin to add flights to database, delete flights
		 * and edit flights.
		 * Only appears if an admin is logged in
		 *******************************************************************************/
		 panelEditFlights = new JPanel();
		 panelEditFlights.setVisible(false);
		 getContentPane().add(panelEditFlights, "Edit Flights");
		 GridBagLayout gbl_panelEditFlights = new GridBagLayout();
		 gbl_panelEditFlights.columnWidths = new int[]{127, 114, 218, 117, 0};
		 gbl_panelEditFlights.rowHeights = new int[]{96, 167, 57, 16, 29, 0};
		 gbl_panelEditFlights.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 gbl_panelEditFlights.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panelEditFlights.setLayout(gbl_panelEditFlights);
		 
		 panelAddFlight = new JPanel();
		 panelAddFlight.setBorder(new LineBorder(new Color(0, 0, 0)));
		 panelAddFlight.setVisible(false);
		 
		 JButton btnAddFlight = new JButton("Add Flight");
		 btnAddFlight.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelAddFlight.setVisible(true);
		 		
		 		
		 	}
		 });
		 GridBagConstraints gbc_btnAddFlight = new GridBagConstraints();
		 gbc_btnAddFlight.anchor = GridBagConstraints.SOUTH;
		 gbc_btnAddFlight.insets = new Insets(0, 0, 5, 5);
		 gbc_btnAddFlight.gridx = 0;
		 gbc_btnAddFlight.gridy = 0;
		 panelEditFlights.add(btnAddFlight, gbc_btnAddFlight);
		 
		 btnEditFlight = new JButton("Edit Flight");
		 GridBagConstraints gbc_btnEditFlight = new GridBagConstraints();
		 gbc_btnEditFlight.insets = new Insets(0, 0, 5, 5);
		 gbc_btnEditFlight.gridx = 0;
		 gbc_btnEditFlight.gridy = 1;
		 panelEditFlights.add(btnEditFlight, gbc_btnEditFlight);
		 GridBagConstraints gbc_panelAddFlight = new GridBagConstraints();
		 gbc_panelAddFlight.gridheight = 2;
		 gbc_panelAddFlight.fill = GridBagConstraints.BOTH;
		 gbc_panelAddFlight.insets = new Insets(0, 0, 5, 0);
		 gbc_panelAddFlight.gridwidth = 3;
		 gbc_panelAddFlight.gridx = 1;
		 gbc_panelAddFlight.gridy = 1;
		 panelEditFlights.add(panelAddFlight, gbc_panelAddFlight);
		 GridBagLayout gbl_panelAddFlight = new GridBagLayout();
		 gbl_panelAddFlight.columnWidths = new int[]{130, 0, 226, 15, 0};
		 gbl_panelAddFlight.rowHeights = new int[]{32, 26, 0, 0, 0, 0, 85, 0, 0};
		 gbl_panelAddFlight.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		 gbl_panelAddFlight.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panelAddFlight.setLayout(gbl_panelAddFlight);
		 
		 jtfAddFlightNumber = new JTextField();
		 jtfAddFlightNumber.setText("Flight Number");
		 GridBagConstraints gbc_jtfAddFlightNumber = new GridBagConstraints();
		 gbc_jtfAddFlightNumber.anchor = GridBagConstraints.SOUTHWEST;
		 gbc_jtfAddFlightNumber.insets = new Insets(0, 0, 5, 5);
		 gbc_jtfAddFlightNumber.gridx = 0;
		 gbc_jtfAddFlightNumber.gridy = 0;
		 panelAddFlight.add(jtfAddFlightNumber, gbc_jtfAddFlightNumber);
		 jtfAddFlightNumber.setColumns(10);
		 
		 txtFlightDuration = new JTextField();
		 txtFlightDuration.setText("Duration (0215)");
		 GridBagConstraints gbc_txtFlightDuration = new GridBagConstraints();
		 gbc_txtFlightDuration.insets = new Insets(0, 0, 5, 5);
		 gbc_txtFlightDuration.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtFlightDuration.gridx = 1;
		 gbc_txtFlightDuration.gridy = 0;
		 panelAddFlight.add(txtFlightDuration, gbc_txtFlightDuration);
		 txtFlightDuration.setColumns(10);
		 
		 txtFlightCapacity = new JTextField();
		 txtFlightCapacity.setText("Flight Capacity");
		 GridBagConstraints gbc_txtFlightCapacity = new GridBagConstraints();
		 gbc_txtFlightCapacity.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtFlightCapacity.anchor = GridBagConstraints.NORTH;
		 gbc_txtFlightCapacity.insets = new Insets(0, 0, 5, 5);
		 gbc_txtFlightCapacity.gridx = 0;
		 gbc_txtFlightCapacity.gridy = 1;
		 panelAddFlight.add(txtFlightCapacity, gbc_txtFlightCapacity);
		 txtFlightCapacity.setColumns(10);
		 
		 txtFlightTime = new JTextField();
		 txtFlightTime.setText("66:21:02");
		 GridBagConstraints gbc_txtFlightTime = new GridBagConstraints();
		 gbc_txtFlightTime.insets = new Insets(0, 0, 5, 5);
		 gbc_txtFlightTime.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtFlightTime.gridx = 1;
		 gbc_txtFlightTime.gridy = 1;
		 panelAddFlight.add(txtFlightTime, gbc_txtFlightTime);
		 txtFlightTime.setColumns(10);
		 
		 txtOnFlight = new JTextField();
		 txtOnFlight.setText("On Flight");
		 GridBagConstraints gbc_txtOnFlight = new GridBagConstraints();
		 gbc_txtOnFlight.insets = new Insets(0, 0, 5, 5);
		 gbc_txtOnFlight.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtOnFlight.gridx = 0;
		 gbc_txtOnFlight.gridy = 2;
		 panelAddFlight.add(txtOnFlight, gbc_txtOnFlight);
		 txtOnFlight.setColumns(10);
		 
		 txtFlightCost = new JTextField();
		 txtFlightCost.setText("Flight Cost (0.00)");
		 GridBagConstraints gbc_txtFlightCost = new GridBagConstraints();
		 gbc_txtFlightCost.insets = new Insets(0, 0, 5, 5);
		 gbc_txtFlightCost.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtFlightCost.gridx = 1;
		 gbc_txtFlightCost.gridy = 2;
		 panelAddFlight.add(txtFlightCost, gbc_txtFlightCost);
		 txtFlightCost.setColumns(10);
		 
		 txtDestination = new JTextField();
		 txtDestination.setText("Destination");
		 GridBagConstraints gbc_txtDestination = new GridBagConstraints();
		 gbc_txtDestination.insets = new Insets(0, 0, 5, 5);
		 gbc_txtDestination.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtDestination.gridx = 0;
		 gbc_txtDestination.gridy = 3;
		 panelAddFlight.add(txtDestination, gbc_txtDestination);
		 txtDestination.setColumns(10);
		 
		 txtDate = new JTextField();
		 txtDate.setText("2016-01-10");
		 GridBagConstraints gbc_txtDate = new GridBagConstraints();
		 gbc_txtDate.insets = new Insets(0, 0, 5, 5);
		 gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtDate.gridx = 1;
		 gbc_txtDate.gridy = 3;
		 panelAddFlight.add(txtDate, gbc_txtDate);
		 txtDate.setColumns(10);
		 
		 txtDeparture = new JTextField();
		 txtDeparture.setText("Departure");
		 GridBagConstraints gbc_txtDeparture = new GridBagConstraints();
		 gbc_txtDeparture.insets = new Insets(0, 0, 5, 5);
		 gbc_txtDeparture.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtDeparture.gridx = 0;
		 gbc_txtDeparture.gridy = 4;
		 panelAddFlight.add(txtDeparture, gbc_txtDeparture);
		 txtDeparture.setColumns(10);
		
		 /*****************************************************************
		  * Creates a new flight in the database 
		  * and stores a copy of the flight object in the flight arrayList
		  ****************************************************************/
		 btnCreateFlight = new JButton("Create Flight");
		 btnCreateFlight.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String stringFlightNumber = jtfAddFlightNumber.getText();
		 		String stringFlightCapacity = txtFlightCapacity.getText();
		 		String stringOnFlight = txtOnFlight.getText();
		 		String destination = txtDestination.getText();
		 		String departure = txtDeparture.getText();
		 		String date = txtDate.getText();
		 		String duration = txtFlightDuration.getText();
		 		String time = txtFlightTime.getText();
		 		String stringCost = txtFlightCost.getText();
		 		
		 		try{
		 			int flightNumber = Integer.parseInt(stringFlightNumber);
		 			int flightCapacity = Integer.parseInt(stringFlightCapacity);
		 			int onFlight = Integer.parseInt(stringOnFlight);
		 			double cost = Double.parseDouble(stringCost);
		 			
		 			f = new Flight(flightNumber,flightCapacity,onFlight, destination,departure,date,duration,time,cost);
		 			flightArray.add(f);
		 			
		 			System.out.print(flightArray.isEmpty());
		 			
		 		}catch(ClassNotFoundException c){
		 			c.printStackTrace();
		 		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{//Reset add field for next flight
					JOptionPane.showMessageDialog(null, "The Flight was successfully added.");
					jtfAddFlightNumber.setText("Flight Number ");
					txtFlightCapacity.setText("Flight Capacity(0-100)");
					txtOnFlight.setText("On Flight");
					txtDestination.setText("Destination");
					txtDeparture.setText("Departure");
					txtDate.setText("2016-01-01");
					txtFlightTime.setText("08:00:00");
					txtFlightDuration.setText("00:00:00");
					txtFlightTime.setText("00:00:00");
					txtFlightCost.setText("Flight cost(0.00)");
				}
		 		
		 	}
		 });
		 GridBagConstraints gbc_btnCreateFlight = new GridBagConstraints();
		 gbc_btnCreateFlight.insets = new Insets(0, 0, 5, 5);
		 gbc_btnCreateFlight.gridx = 1;
		 gbc_btnCreateFlight.gridy = 5;
		 panelAddFlight.add(btnCreateFlight, gbc_btnCreateFlight);
		 
		 lblPressTheOption = new JLabel("*Press this option to remove a flight *");
		 GridBagConstraints gbc_lblPressTheOption = new GridBagConstraints();
		 gbc_lblPressTheOption.anchor = GridBagConstraints.NORTH;
		 gbc_lblPressTheOption.fill = GridBagConstraints.HORIZONTAL;
		 gbc_lblPressTheOption.insets = new Insets(0, 0, 5, 5);
		 gbc_lblPressTheOption.gridwidth = 2;
		 gbc_lblPressTheOption.gridx = 0;
		 gbc_lblPressTheOption.gridy = 3;
		 panelEditFlights.add(lblPressTheOption, gbc_lblPressTheOption);
		 
		 /********************************************************************************
		  * Removes flight from database
		  * Pop up window prompts admin to enter flightnumber
		  * Flight is removed from table when ok is pressed.
		  ********************************************************************************/
		 btnDeleteFlight = new JButton("Delete Flight");
		 btnDeleteFlight.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelUserView_1.setVisible(false);
		 			
		 		try {
		 			String number = JOptionPane.showInputDialog(" Enter the Flight Number\n*THIS WILL PERMANENTLY REMOVE THE FLIGHT*");
		 			int flightNum = Integer.parseInt(number);
		 			deleteFlight(flightNum);
		 		} catch (ClassNotFoundException e1) {//Flight number not in system
		 			JOptionPane.showMessageDialog(null, "The specified flight number was not found:");	
		 			
		 		} catch (SQLException e1) {
		 			JOptionPane.showMessageDialog(null, "Database error, check inputs");
		 			
		 		}catch(RuntimeException r){
		 			JOptionPane.showMessageDialog(null, "Flight number cannot be left blank");
		 			
		 		}
		 		
		 		
		 	}
		 });
		
		 GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		 gbc_btnBack_1.anchor = GridBagConstraints.NORTH;
		 gbc_btnBack_1.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnBack_1.gridx = 3;
		 gbc_btnBack_1.gridy = 4;
		 
		 panelUserView_1 = new JPanel();
		 getContentPane().add(panelUserView_1, "Main Menu");
		 panelUserView_1.setVisible(false);
		 GridBagLayout gbl_panelUserView_1 = new GridBagLayout();
		 gbl_panelUserView_1.columnWidths = new int[]{130, 374, 0, 0, 0, 0};
		 gbl_panelUserView_1.rowHeights = new int[]{29, 40, 29, 29, 29, 29, 179, 0};
		 gbl_panelUserView_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		 gbl_panelUserView_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panelUserView_1.setLayout(gbl_panelUserView_1);
		 
		 GridBagConstraints gbc_btnDeleteFlight = new GridBagConstraints();
		 gbc_btnDeleteFlight.anchor = GridBagConstraints.NORTHEAST;
		 gbc_btnDeleteFlight.insets = new Insets(0, 0, 0, 5);
		 gbc_btnDeleteFlight.gridx = 0;
		 gbc_btnDeleteFlight.gridy = 4;
		 panelEditFlights.add(btnDeleteFlight, gbc_btnDeleteFlight);
		 
		 btnBack_2 = new JButton("Back");
		 btnBack_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelUserView_1.setVisible(true);
		 		panelEditFlights.setVisible(false);
		 		panelLogin.setVisible(false);
		 		panelPasswordReset.setVisible(false);
		 		
		 	}
		 });
		 GridBagConstraints gbc_btnBack_2 = new GridBagConstraints();
		 gbc_btnBack_2.gridx = 3;
		 gbc_btnBack_2.gridy = 4;
		 panelEditFlights.add(btnBack_2, gbc_btnBack_2);
		 
		 btnBack_1 = new JButton("Back");
		 btnBack_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelEditFlights.setVisible(false);
		 		panelUserView_1.setVisible(true);
		 	}
		 });
		 
		 JButton btnSearchFlights = new JButton("Search Flights");
		 btnSearchFlights.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelSearchFlight.setVisible(true);
		 	}
		 });
		 
		 /************************************************************
		  * Removes stored customer object from customer arraylist
		  * Resets username and email field for next login
		  ************************************************************/
		 btnLogout = new JButton("Logout");
		 btnLogout.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelUserView_1.setVisible(false);
		 		panelLogin.setVisible(true);
		 		jtfUserLogin.setText("");
		 		passwordField.setText("");
		 		customerArray.clear();
		 		c = null;
		 		
		 	}
		 });
		 GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		 gbc_btnLogout.anchor = GridBagConstraints.NORTHEAST;
		 gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
		 gbc_btnLogout.gridx = 3;
		 gbc_btnLogout.gridy = 0;
		 panelUserView_1.add(btnLogout, gbc_btnLogout);
		 GridBagConstraints gbc_btnSearchFlights = new GridBagConstraints();
		 gbc_btnSearchFlights.anchor = GridBagConstraints.NORTH;
		 gbc_btnSearchFlights.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnSearchFlights.insets = new Insets(0, 0, 5, 5);
		 gbc_btnSearchFlights.gridx = 0;
		 gbc_btnSearchFlights.gridy = 2;
		 panelUserView_1.add(btnSearchFlights, gbc_btnSearchFlights);
		 
			/***********************************************************************************
			 * Search Flight panel
			 * Allows user to search for flights based on date, departure point, and destination
			 * 	
			 ***********************************************************************************/
		 
		 panelSearchFlight = new JPanel();
		 panelSearchFlight.setVisible(false);
		 panelSearchFlight.setBorder(null);
		 GridBagConstraints gbc_panelSearchFlight = new GridBagConstraints();
		 gbc_panelSearchFlight.insets = new Insets(0, 0, 0, 5);
		 gbc_panelSearchFlight.fill = GridBagConstraints.BOTH;
		 gbc_panelSearchFlight.gridheight = 5;
		 gbc_panelSearchFlight.gridx = 1;
		 gbc_panelSearchFlight.gridy = 2;
		 panelUserView_1.add(panelSearchFlight, gbc_panelSearchFlight);
		 GridBagLayout gbl_panelSearchFlight = new GridBagLayout();
		 gbl_panelSearchFlight.columnWidths = new int[]{10, 130, 0};
		 gbl_panelSearchFlight.rowHeights = new int[]{22, 26, 16, 26, 0, 39, 0, 16, 26, 16, 26, 22, 0};
		 gbl_panelSearchFlight.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		 gbl_panelSearchFlight.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panelSearchFlight.setLayout(gbl_panelSearchFlight);
		 
		 panelSearchResults = new JPanel();
		 panelSearchResults.setVisible(false);
		 GridBagConstraints gbc_panelSearchResults = new GridBagConstraints();
		 gbc_panelSearchResults.anchor = GridBagConstraints.NORTHWEST;
		 gbc_panelSearchResults.insets = new Insets(0, 0, 5, 5);
		 gbc_panelSearchResults.gridx = 0;
		 gbc_panelSearchResults.gridy = 0;
		 panelSearchFlight.add(panelSearchResults, gbc_panelSearchResults);
		 
		 JLabel lblEnterTheCity = new JLabel("Departure Point");
		 GridBagConstraints gbc_lblEnterTheCity = new GridBagConstraints();
		 gbc_lblEnterTheCity.anchor = GridBagConstraints.SOUTHWEST;
		 gbc_lblEnterTheCity.insets = new Insets(0, 0, 5, 0);
		 gbc_lblEnterTheCity.gridx = 1;
		 gbc_lblEnterTheCity.gridy = 0;
		 panelSearchFlight.add(lblEnterTheCity, gbc_lblEnterTheCity);
		 
		 jtfDepartureField = new JTextField();
		 GridBagConstraints gbc_jtfDepartureField = new GridBagConstraints();
		 gbc_jtfDepartureField.anchor = GridBagConstraints.NORTHWEST;
		 gbc_jtfDepartureField.insets = new Insets(0, 0, 5, 0);
		 gbc_jtfDepartureField.gridx = 1;
		 gbc_jtfDepartureField.gridy = 1;
		 panelSearchFlight.add(jtfDepartureField, gbc_jtfDepartureField);
		 jtfDepartureField.setColumns(10);
		 
		 JLabel lblDestination = new JLabel("Destination");
		 GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		 gbc_lblDestination.anchor = GridBagConstraints.NORTHWEST;
		 gbc_lblDestination.insets = new Insets(0, 0, 5, 0);
		 gbc_lblDestination.gridx = 1;
		 gbc_lblDestination.gridy = 2;
		 panelSearchFlight.add(lblDestination, gbc_lblDestination);
		 
		 jtfDestinationField = new JTextField();
		 GridBagConstraints gbc_jtfDestinationField = new GridBagConstraints();
		 gbc_jtfDestinationField.anchor = GridBagConstraints.NORTHWEST;
		 gbc_jtfDestinationField.insets = new Insets(0, 0, 5, 0);
		 gbc_jtfDestinationField.gridx = 1;
		 gbc_jtfDestinationField.gridy = 3;
		 panelSearchFlight.add(jtfDestinationField, gbc_jtfDestinationField);
		 jtfDestinationField.setColumns(10);
		 
		 JLabel lblDepartureDate = new JLabel("Departure Date");
		 GridBagConstraints gbc_lblDepartureDate = new GridBagConstraints();
		 gbc_lblDepartureDate.anchor = GridBagConstraints.NORTH;
		 gbc_lblDepartureDate.fill = GridBagConstraints.HORIZONTAL;
		 gbc_lblDepartureDate.insets = new Insets(0, 0, 5, 0);
		 gbc_lblDepartureDate.gridx = 1;
		 gbc_lblDepartureDate.gridy = 4;
		 panelSearchFlight.add(lblDepartureDate, gbc_lblDepartureDate);
		 
		 jtfDepartureDate = new JTextField();
		 GridBagConstraints gbc_jtfDepartureDate = new GridBagConstraints();
		 gbc_jtfDepartureDate.anchor = GridBagConstraints.NORTHWEST;
		 gbc_jtfDepartureDate.insets = new Insets(0, 0, 5, 0);
		 gbc_jtfDepartureDate.gridx = 1;
		 gbc_jtfDepartureDate.gridy = 5;
		 panelSearchFlight.add(jtfDepartureDate, gbc_jtfDepartureDate);
		 jtfDepartureDate.setColumns(10);
		 
		 JButton btnSearchDestination = new JButton("Search");
		 btnSearchDestination.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String departure = jtfDepartureField.getText();
		 		String destination = jtfDestinationField.getText();
		 		String date = jtfDepartureDate.getText();
		 		
		 		try {
		 			Flight f = findFlight(departure,destination, date);
		 			System.out.print(f.getFlightNumber()+ "\n" +f.getFlightDestination()+ " \n" +f.getFlightStartPoint());
		 			
		 		} catch (ClassNotFoundException | SQLException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		 		
		 		
		 	}
		 });
		 GridBagConstraints gbc_btnSearchDestination = new GridBagConstraints();
		 gbc_btnSearchDestination.insets = new Insets(0, 0, 5, 0);
		 gbc_btnSearchDestination.anchor = GridBagConstraints.WEST;
		 gbc_btnSearchDestination.fill = GridBagConstraints.VERTICAL;
		 gbc_btnSearchDestination.gridx = 1;
		 gbc_btnSearchDestination.gridy = 6;
		 panelSearchFlight.add(btnSearchDestination, gbc_btnSearchDestination);
		 
		 JButton btnBookedFlights = new JButton("Booked Flights");
		 GridBagConstraints gbc_btnBookedFlights = new GridBagConstraints();
		 gbc_btnBookedFlights.anchor = GridBagConstraints.NORTH;
		 gbc_btnBookedFlights.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnBookedFlights.insets = new Insets(0, 0, 5, 5);
		 gbc_btnBookedFlights.gridx = 0;
		 gbc_btnBookedFlights.gridy = 3;
		 panelUserView_1.add(btnBookedFlights, gbc_btnBookedFlights);
		 
		 JButton btnViewFlights = new JButton("View Flights");
		 GridBagConstraints gbc_btnViewFlights = new GridBagConstraints();
		 gbc_btnViewFlights.anchor = GridBagConstraints.NORTH;
		 gbc_btnViewFlights.insets = new Insets(0, 0, 5, 5);
		 gbc_btnViewFlights.gridx = 0;
		 gbc_btnViewFlights.gridy = 4;
		 panelUserView_1.add(btnViewFlights, gbc_btnViewFlights);
		 
		 JButton btnAccountInformation = new JButton("Account");
		 btnAccountInformation.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 GridBagConstraints gbc_btnAccountInformation = new GridBagConstraints();
		 gbc_btnAccountInformation.anchor = GridBagConstraints.NORTH;
		 gbc_btnAccountInformation.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnAccountInformation.insets = new Insets(0, 0, 5, 5);
		 gbc_btnAccountInformation.gridx = 0;
		 gbc_btnAccountInformation.gridy = 5;
		 panelUserView_1.add(btnAccountInformation, gbc_btnAccountInformation);
		 btnEditFlights = new JButton("Edit Flights");
		 btnEditFlights.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panelEditFlights.setVisible(true);
		 		panelUserView_1.setVisible(false);
		 		panelUserView_1.setEnabled(false);
		 	}
		 });
		 btnEditFlights.setVisible(false);
		 GridBagConstraints gbc_btnEditFlights = new GridBagConstraints();
		 gbc_btnEditFlights.anchor = GridBagConstraints.NORTH;
		 gbc_btnEditFlights.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnEditFlights.insets = new Insets(0, 0, 0, 5);
		 gbc_btnEditFlights.gridx = 0;
		 gbc_btnEditFlights.gridy = 6;
		 panelUserView_1.add(btnEditFlights, gbc_btnEditFlights);
		
		
		/**Email Address text field for login window*/
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[]{130, 233, 130, 0};
		gbl_panelLogin.rowHeights = new int[]{50, 0, 16, 16, 16, 21, 4, 29, 0};
		gbl_panelLogin.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelLogin.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelLogin.setLayout(gbl_panelLogin);
		JLabel lblEmailAddress = new JLabel("User Name");
		GridBagConstraints gbc_lblEmailAddress = new GridBagConstraints();
		gbc_lblEmailAddress.anchor = GridBagConstraints.NORTH;
		gbc_lblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAddress.gridx = 0;
		gbc_lblEmailAddress.gridy = 1;
		panelLogin.add(lblEmailAddress, gbc_lblEmailAddress);
		JLabel lblNewUsers = new JLabel("New Users");
		GridBagConstraints gbc_lblNewUsers = new GridBagConstraints();
		gbc_lblNewUsers.anchor = GridBagConstraints.NORTH;
		gbc_lblNewUsers.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewUsers.gridx = 2;
		gbc_lblNewUsers.gridy = 1;
		panelLogin.add(lblNewUsers, gbc_lblNewUsers);
		
		jtfUserLogin = new JTextField();
		GridBagConstraints gbc_jtfUserLogin = new GridBagConstraints();
		gbc_jtfUserLogin.anchor = GridBagConstraints.SOUTH;
		gbc_jtfUserLogin.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUserLogin.gridx = 0;
		gbc_jtfUserLogin.gridy = 2;
		panelLogin.add(jtfUserLogin, gbc_jtfUserLogin);
		jtfUserLogin.setColumns(10);
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewUser.setVisible(true);
				panelLogin.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
		gbc_btnCreateAccount.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateAccount.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateAccount.gridx = 2;
		gbc_btnCreateAccount.gridy = 2;
		panelLogin.add(btnCreateAccount, gbc_btnCreateAccount);
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.NORTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		panelLogin.add(lblPassword, gbc_lblPassword);
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 4;
		panelLogin.add(passwordField, gbc_passwordField);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		GridBagConstraints gbc_lblForgotPassword = new GridBagConstraints();
		gbc_lblForgotPassword.anchor = GridBagConstraints.SOUTH;
		gbc_lblForgotPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblForgotPassword.gridx = 2;
		gbc_lblForgotPassword.gridy = 4;
		panelLogin.add(lblForgotPassword, gbc_lblForgotPassword);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPasswordReset.setVisible(true);
				panelLogin.setVisible(false);
			}
		});
		
		/****************************************************************************************
		 * Logs user in after checking if username and password match variable store in database
		 * Creates a customer object and stores in customer arraylist
		 * If admin logs in, the edit flight tab becomes visible and usable
		 ****************************************************************************************/
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = jtfUserLogin.getText();
				String password = passwordField.getText();
				try {
					if(login(userName,password)){
						panelUserView_1.setVisible(true);
						panelLogin.setVisible(false);
						
						if(isAdmin(userName)){
							btnEditFlights.setVisible(true);
						}else{
							Customer c = getCustomerInfo(userName);
							customerArray.add(c);
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Check username and password");
					}
					System.out.print(isAdmin(userName));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 5;
		panelLogin.add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnResetPassword = new GridBagConstraints();
		gbc_btnResetPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetPassword.anchor = GridBagConstraints.NORTH;
		gbc_btnResetPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResetPassword.gridx = 2;
		gbc_btnResetPassword.gridy = 5;
		panelLogin.add(btnResetPassword, gbc_btnResetPassword);
		
	
	

		
		
		
/**New user info label*******************************************************************************************/
		
		/**User name text field*/
		/**FirstName text field*/
		/**Last Name Text field*/
		/**Street Address Text Field*/
		/**City Text Field*/
		/**State Text Field*/
		/**Security Question Text Field*/
		/**Security Question Answer TextField*/
		/**Email Address Text Field*/
		
		/**
		 * Action Listener for create account button
		 * Takes all text fields and converts value to string
		 * Invokes the insertNewUser method from database interface to add user to database
		 */
		
		/**Back button for new user page, takes back to login window*/
		/***********************************************************************************************************/
		
	
		
		/**Registration page label*/
		GridBagLayout gbl_panelNewUser = new GridBagLayout();
		gbl_panelNewUser.columnWidths = new int[]{134, 44, 159, 130, 0};
		gbl_panelNewUser.rowHeights = new int[]{16, 16, 26, 26, 26, 26, 26, 21, 2, 29, 26, 26, 26, 26, 21, 29, 0, 0};
		gbl_panelNewUser.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNewUser.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNewUser.setLayout(gbl_panelNewUser);
		JLabel lblUserRegistrationPage = new JLabel("User Registration Page");
		GridBagConstraints gbc_lblUserRegistrationPage = new GridBagConstraints();
		gbc_lblUserRegistrationPage.anchor = GridBagConstraints.NORTH;
		gbc_lblUserRegistrationPage.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserRegistrationPage.gridwidth = 2;
		gbc_lblUserRegistrationPage.gridx = 1;
		gbc_lblUserRegistrationPage.gridy = 0;
		panelNewUser.add(lblUserRegistrationPage, gbc_lblUserRegistrationPage);
		JLabel lblNewUserInfo = new JLabel("Please enter the following information");
		GridBagConstraints gbc_lblNewUserInfo = new GridBagConstraints();
		gbc_lblNewUserInfo.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewUserInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewUserInfo.gridwidth = 3;
		gbc_lblNewUserInfo.gridx = 0;
		gbc_lblNewUserInfo.gridy = 1;
		panelNewUser.add(lblNewUserInfo, gbc_lblNewUserInfo);
		jtfUserName = new JTextField();
		GridBagConstraints gbc_jtfUserName = new GridBagConstraints();
		gbc_jtfUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUserName.anchor = GridBagConstraints.NORTH;
		gbc_jtfUserName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUserName.gridx = 0;
		gbc_jtfUserName.gridy = 2;
		panelNewUser.add(jtfUserName, gbc_jtfUserName);
		jtfUserName.setColumns(10);
		
		lblUserName = new JLabel("User Name");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.WEST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridwidth = 2;
		gbc_lblUserName.gridx = 1;
		gbc_lblUserName.gridy = 2;
		panelNewUser.add(lblUserName, gbc_lblUserName);
		
		jtfPassword = new JPasswordField();
		GridBagConstraints gbc_jtfPassword = new GridBagConstraints();
		gbc_jtfPassword.anchor = GridBagConstraints.NORTH;
		gbc_jtfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPassword.gridx = 0;
		gbc_jtfPassword.gridy = 3;
		panelNewUser.add(jtfPassword, gbc_jtfPassword);
		
		lblPassword_1 = new JLabel("Password");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.anchor = GridBagConstraints.WEST;
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridwidth = 2;
		gbc_lblPassword_1.gridx = 1;
		gbc_lblPassword_1.gridy = 3;
		panelNewUser.add(lblPassword_1, gbc_lblPassword_1);
		
		jtfEmailAddress = new JTextField();
		GridBagConstraints gbc_jtfEmailAddress = new GridBagConstraints();
		gbc_jtfEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmailAddress.anchor = GridBagConstraints.NORTH;
		gbc_jtfEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmailAddress.gridx = 0;
		gbc_jtfEmailAddress.gridy = 4;
		panelNewUser.add(jtfEmailAddress, gbc_jtfEmailAddress);
		jtfEmailAddress.setColumns(10);
		
		lblEmailAddress_1 = new JLabel("Email Address");
		GridBagConstraints gbc_lblEmailAddress_1 = new GridBagConstraints();
		gbc_lblEmailAddress_1.anchor = GridBagConstraints.WEST;
		gbc_lblEmailAddress_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAddress_1.gridwidth = 2;
		gbc_lblEmailAddress_1.gridx = 1;
		gbc_lblEmailAddress_1.gridy = 4;
		panelNewUser.add(lblEmailAddress_1, gbc_lblEmailAddress_1);
		
		jtfFirstName = new JTextField();
		GridBagConstraints gbc_jtfFirstName = new GridBagConstraints();
		gbc_jtfFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFirstName.anchor = GridBagConstraints.NORTH;
		gbc_jtfFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFirstName.gridx = 0;
		gbc_jtfFirstName.gridy = 5;
		panelNewUser.add(jtfFirstName, gbc_jtfFirstName);
		jtfFirstName.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 2;
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 5;
		panelNewUser.add(lblFirstName, gbc_lblFirstName);
		jtfLastName = new JTextField();
		GridBagConstraints gbc_jtfLastName = new GridBagConstraints();
		gbc_jtfLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLastName.anchor = GridBagConstraints.NORTH;
		gbc_jtfLastName.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLastName.gridx = 0;
		gbc_jtfLastName.gridy = 6;
		panelNewUser.add(jtfLastName, gbc_jtfLastName);
		jtfLastName.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 2;
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 6;
		panelNewUser.add(lblLastName, gbc_lblLastName);
		jtfStreetAddress = new JTextField();
		GridBagConstraints gbc_jtfStreetAddress = new GridBagConstraints();
		gbc_jtfStreetAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfStreetAddress.anchor = GridBagConstraints.SOUTH;
		gbc_jtfStreetAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jtfStreetAddress.gridx = 0;
		gbc_jtfStreetAddress.gridy = 7;
		panelNewUser.add(jtfStreetAddress, gbc_jtfStreetAddress);
		jtfStreetAddress.setColumns(10);
		
		lblStreetAddress = new JLabel("Street Address");
		GridBagConstraints gbc_lblStreetAddress = new GridBagConstraints();
		gbc_lblStreetAddress.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblStreetAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetAddress.gridwidth = 2;
		gbc_lblStreetAddress.gridx = 1;
		gbc_lblStreetAddress.gridy = 7;
		panelNewUser.add(lblStreetAddress, gbc_lblStreetAddress);
		jtfCity = new JTextField();
		GridBagConstraints gbc_jtfCity = new GridBagConstraints();
		gbc_jtfCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCity.anchor = GridBagConstraints.SOUTH;
		gbc_jtfCity.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCity.gridx = 0;
		gbc_jtfCity.gridy = 8;
		panelNewUser.add(jtfCity, gbc_jtfCity);
		jtfCity.setColumns(10);
		
		lblCity = new JLabel("City");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridwidth = 2;
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 8;
		panelNewUser.add(lblCity, gbc_lblCity);
		jtfState = new JTextField();
		GridBagConstraints gbc_jtfState = new GridBagConstraints();
		gbc_jtfState.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfState.anchor = GridBagConstraints.NORTH;
		gbc_jtfState.insets = new Insets(0, 0, 5, 5);
		gbc_jtfState.gridx = 0;
		gbc_jtfState.gridy = 9;
		panelNewUser.add(jtfState, gbc_jtfState);
		jtfState .setColumns(10);
		
		lblState = new JLabel("State");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.WEST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridwidth = 2;
		gbc_lblState.gridx = 1;
		gbc_lblState.gridy = 9;
		panelNewUser.add(lblState, gbc_lblState);
		
		jtfZipCode = new JTextField();
		GridBagConstraints gbc_jtfZipCode = new GridBagConstraints();
		gbc_jtfZipCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfZipCode.anchor = GridBagConstraints.NORTH;
		gbc_jtfZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfZipCode.gridx = 0;
		gbc_jtfZipCode.gridy = 10;
		panelNewUser.add(jtfZipCode, gbc_jtfZipCode);
		jtfZipCode.setColumns(10);
		
		lblZipCode = new JLabel("Zip Code");
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.WEST;
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode.gridwidth = 2;
		gbc_lblZipCode.gridx = 1;
		gbc_lblZipCode.gridy = 10;
		panelNewUser.add(lblZipCode, gbc_lblZipCode);
		
		jtfSSN = new JTextField();
		GridBagConstraints gbc_jtfSSN = new GridBagConstraints();
		gbc_jtfSSN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSSN.anchor = GridBagConstraints.NORTH;
		gbc_jtfSSN.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSSN.gridx = 0;
		gbc_jtfSSN.gridy = 11;
		panelNewUser.add(jtfSSN, gbc_jtfSSN);
		jtfSSN.setColumns(10);
		
		lblSsn = new JLabel("SSN");
		GridBagConstraints gbc_lblSsn = new GridBagConstraints();
		gbc_lblSsn.anchor = GridBagConstraints.WEST;
		gbc_lblSsn.insets = new Insets(0, 0, 5, 5);
		gbc_lblSsn.gridwidth = 2;
		gbc_lblSsn.gridx = 1;
		gbc_lblSsn.gridy = 11;
		panelNewUser.add(lblSsn, gbc_lblSsn);
		jtfEnterSecurityQuestion = new JTextField();
		GridBagConstraints gbc_jtfEnterSecurityQuestion = new GridBagConstraints();
		gbc_jtfEnterSecurityQuestion.anchor = GridBagConstraints.NORTH;
		gbc_jtfEnterSecurityQuestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEnterSecurityQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEnterSecurityQuestion.gridwidth = 3;
		gbc_jtfEnterSecurityQuestion.gridx = 0;
		gbc_jtfEnterSecurityQuestion.gridy = 12;
		panelNewUser.add(jtfEnterSecurityQuestion, gbc_jtfEnterSecurityQuestion);
		jtfEnterSecurityQuestion.setColumns(10);
		
		lblSecuritQuestion = new JLabel("Security Question");
		GridBagConstraints gbc_lblSecuritQuestion = new GridBagConstraints();
		gbc_lblSecuritQuestion.anchor = GridBagConstraints.NORTH;
		gbc_lblSecuritQuestion.insets = new Insets(0, 0, 5, 0);
		gbc_lblSecuritQuestion.gridx = 3;
		gbc_lblSecuritQuestion.gridy = 12;
		panelNewUser.add(lblSecuritQuestion, gbc_lblSecuritQuestion);
		jtfSecurityQuestionAnswer = new JTextField();
		GridBagConstraints gbc_jtfSecurityQuestionAnswer = new GridBagConstraints();
		gbc_jtfSecurityQuestionAnswer.anchor = GridBagConstraints.NORTH;
		gbc_jtfSecurityQuestionAnswer.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSecurityQuestionAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSecurityQuestionAnswer.gridwidth = 2;
		gbc_jtfSecurityQuestionAnswer.gridx = 0;
		gbc_jtfSecurityQuestionAnswer.gridy = 13;
		panelNewUser.add(jtfSecurityQuestionAnswer, gbc_jtfSecurityQuestionAnswer);
		jtfSecurityQuestionAnswer.setColumns(10);
		
		lblAnswer = new JLabel("Answer");
		GridBagConstraints gbc_lblAnswer = new GridBagConstraints();
		gbc_lblAnswer.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer.gridx = 2;
		gbc_lblAnswer.gridy = 13;
		panelNewUser.add(lblAnswer, gbc_lblAnswer);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewUser.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 15;
		panelNewUser.add(btnNewButton, gbc_btnNewButton);
		JButton createNewUser = new JButton("Create Account");
		createNewUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
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
				String zipCode = jtfZipCode.getText();
				String SSNConvert = jtfSSN.getText();
				
				if(zipCode.equals(null) || SSNConvert.equals(null) || userName.equals(null) || emailAddress.equals(null) || securityQuestion.equals(null) || securityAnswer.equals(null)){
					JOptionPane.showMessageDialog(null, "One or more of the required fields was left blank:");
				}else{
				try{
					int zip = Integer.parseInt(zipCode);
					int SSN = Integer.parseInt(SSNConvert);
				Customer c = new Customer(userName,password,emailAddress,firstName,LastName,address,city,state,zip,SSN,securityQuestion,securityAnswer);
				insertNewUser(c);
				panelNewUser.setVisible(false);
				panelUserView_1.setVisible(true);
				}catch(Exception n){
					JOptionPane.showMessageDialog(null, "One or more of the required fields was left blank:");
				}
			}
			}
		});
		GridBagConstraints gbc_createNewUser = new GridBagConstraints();
		gbc_createNewUser.insets = new Insets(0, 0, 5, 0);
		gbc_createNewUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_createNewUser.gridx = 3;
		gbc_createNewUser.gridy = 15;
		panelNewUser.add(createNewUser, gbc_createNewUser);
		
		
		
		/*******************************************************************************************
		 * Reset password panel
		 * Contains text field and action listener that prompts the user to enter their username 
		 * then asks them to answer there security question.
		 * Pop windows appears if answer is wrong or null asking user to recheck what they typed in
		 ********************************************************************************************/
		panelPasswordReset = new JPanel();
		getContentPane().add(panelPasswordReset, "Reset Password");
		GridBagLayout gbl_panelPasswordReset = new GridBagLayout();
		gbl_panelPasswordReset.columnWidths = new int[]{38, 168, 0};
		gbl_panelPasswordReset.rowHeights = new int[]{87, 16, 26, 29, 29, 0};
		gbl_panelPasswordReset.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPasswordReset.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPasswordReset.setLayout(gbl_panelPasswordReset);
		
		JLabel lblEnterYouPassword = new JLabel("Enter your Username:");
		GridBagConstraints gbc_lblEnterYouPassword = new GridBagConstraints();
		gbc_lblEnterYouPassword.anchor = GridBagConstraints.NORTH;
		gbc_lblEnterYouPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnterYouPassword.gridx = 1;
		gbc_lblEnterYouPassword.gridy = 1;
		panelPasswordReset.add(lblEnterYouPassword, gbc_lblEnterYouPassword);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panelPasswordReset.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		JButton btnViewSecurityQuestion = new JButton("View Security Question");
		btnViewSecurityQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = textField_1.getText();
				
					try{
						customer = getCustomerInfo(userName);
						if(customer.getUserName().equals(userName)){
							String answer = JOptionPane.showInputDialog( customer.getSecurityQuestion());
							if(customer.getSecurityQuestionAnswer().equals(answer)){
								try{
								String updatedPassword = JOptionPane.showInputDialog("Enter a new password:");
								customer.setPassword(updatedPassword);
								updatePassword(customer.getUserName(),updatedPassword );
								JOptionPane.showMessageDialog(null, "Your password has been changed.");
								panelPasswordReset.setVisible(false);
								panelLogin.setVisible(true);
								}catch(NullPointerException p){
									String updatedPassword = JOptionPane.showInputDialog("Password cannot be blank, re-enter the password:");
									while(updatedPassword.equals(" "))
										   updatedPassword = JOptionPane.showInputDialog("Password cannot be blank, re-enter the password:");

								}
								
							}else{
								JOptionPane.showMessageDialog(null, "Check answer to security question,");
							}
						}else{
							JOptionPane.showMessageDialog(null, "No user with that specific username was found.");
						}
						
						
					}catch(NullPointerException n){
						JOptionPane.showMessageDialog(null, "Please enter a valid username.");
					}catch(SQLException s){
						JOptionPane.showMessageDialog(null, "The admin password can only be reset by a database administrator.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
				
				
			
		});
		GridBagConstraints gbc_btnViewSecurityQuestion = new GridBagConstraints();
		gbc_btnViewSecurityQuestion.anchor = GridBagConstraints.NORTH;
		gbc_btnViewSecurityQuestion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewSecurityQuestion.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewSecurityQuestion.gridx = 1;
		gbc_btnViewSecurityQuestion.gridy = 3;
		panelPasswordReset.add(btnViewSecurityQuestion, gbc_btnViewSecurityQuestion);
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
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPasswordReset.setVisible(false);
				panelLogin.setVisible(true);
				textField_1.setText("");
				
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.NORTH;
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 4;
		panelPasswordReset.add(btnBack, gbc_btnBack);
		
		panelViewFlights = new JPanel();
		getContentPane().add(panelViewFlights, "name_42262285748290");
		GridBagLayout gbl_panelViewFlights = new GridBagLayout();
		gbl_panelViewFlights.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelViewFlights.rowHeights = new int[]{0, 0, 0, 0, 0, 30, 0};
		gbl_panelViewFlights.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelViewFlights.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelViewFlights.setLayout(gbl_panelViewFlights);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 11;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		panelViewFlights.add(list, gbc_list);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		panelViewFlights.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Book Flight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		panelViewFlights.add(btnNewButton_1, gbc_btnNewButton_1);


		
		
	}



	
}

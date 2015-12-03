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

public class TestGUI extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelLogin;
	private JPanel panelNewUser;
	private JPanel panelUserView;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtStreetAddress;
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
		panelUserView.setVisible(false);
		
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
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserView.setVisible(true);
				panelLogin.setVisible(false);
				Database db = new Database();
			}
		});
		btnOk.setBounds(27, 169, 117, 29);
		panelLogin.add(btnOk);
		/**New User Panel*/
		JLabel lblNewUsers = new JLabel("New Users");
		lblNewUsers.setBounds(395, 50, 78, 16);
		panelLogin.add(lblNewUsers);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewUser.setVisible(true);
				panelLogin.setVisible(false);
			}
		});
		btnCreateAccount.setBounds(373, 75, 130, 29);
		panelLogin.add(btnCreateAccount);
		
	
		
		
		
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(26, 53, 130, 26);
		txtFirstName.setText("User Name");
		panelNewUser.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblUserRegistrationPage = new JLabel("User Registration Page");
		lblUserRegistrationPage.setBounds(181, 6, 141, 16);
		panelNewUser.add(lblUserRegistrationPage);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the following information");
		lblPleaseEnterThe.setBounds(27, 33, 260, 16);
		panelNewUser.add(lblPleaseEnterThe);
		
		txtLastName = new JTextField();
		txtLastName.setText("Password");
		txtLastName.setBounds(26, 83, 130, 26);
		panelNewUser.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setText("Re-enter Password");
		txtStreetAddress.setBounds(26, 114, 130, 26);
		panelNewUser.add(txtStreetAddress);
		txtStreetAddress.setColumns(10);
	}
	
	public static void main(String[] args){
		JFrame frame = new TestGUI();
		
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

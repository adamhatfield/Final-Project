package flightSystem;

import java.awt.Image;
import java.awt.SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.awt.CardLayout;

public class Startup extends TestGUI implements Database {
	
	SplashScreen screen;
	
	public Startup(){
		getContentPane().setLayout(new CardLayout(0, 0));
		JFrame frame = new TestGUI();
		frame.setSize(700,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		splashScreen();
		TestGUI main = new TestGUI();
		
	}
	
	public void splashScreen(){
		initializeDB();
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		Startup main = new Startup();
	}
}

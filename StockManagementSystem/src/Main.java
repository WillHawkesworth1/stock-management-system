/**
 * 
 */

/**
 * 
 * @author Scoutshot
 * Title: Gwent Grails Stock Management System
 *
 */

import java.awt.*;
import javax.swing.*;

public class Main {
	
	private static JFrame mainWindow;
	private static JPanel loginPage;

	public static void main(String[] args) {
		
		createWindow();

	}
	
	//A method to create the window and display it to the user
	private static void createWindow() {		

		loginPage = new JPanel();
		
		mainWindow = new JFrame("Gwent Grails Stock Mananagement System");
		mainWindow.setSize(800, 600);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainWindow.add(loginPage);
		
		loginPage.setLayout((null));
		
		JLabel titleLabel = new JLabel("Login Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		loginPage.add(titleLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(300, 100, 200, 80);
		usernameLabel.setFont (usernameLabel.getFont ().deriveFont (30.0f));
		loginPage.add(usernameLabel);
		
		JTextField usernameText = new JTextField();
		usernameText.setBounds(300, 180, 150, 25);
		loginPage.add(usernameText);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(300, 220, 200, 80);
		passwordLabel.setFont (passwordLabel.getFont ().deriveFont (30.0f));
		loginPage.add(passwordLabel);
		
		JTextField passwordText = new JTextField();
		passwordText.setBounds(300, 300, 150, 25);
		loginPage.add(passwordText);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(335, 340, 80, 25);
		loginPage.add(loginButton);
		
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		loginPage.add(gwentGrailsLogo);
		
		mainWindow.setVisible(true);
	}
	
}

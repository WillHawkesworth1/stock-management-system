/**
 * 
 */

/**
 * 
 * @author WIlliam Hawkesworth
 * Title: Gwent Grails Stock Management System
 *
 */

import java.awt.*;
import javax.swing.*;

public class Main {
	
	private static JFrame mainWindow;
	private static JPanel loginPage, salesPage;
	private static JMenuBar navigationBar;
	private static JMenu navigationMenu, loginMenu;
	private static JMenuItem overviewItem, stockItem, investmentsItem, costsItem, soldItem, weeklyReviewItem, monthlyReviewItem, usersItem, signOutItem;


	public static void main(String[] args) {
		
		createWindow();
		createMenuBar();
		//createLoginPage();
		createSalesPage();	
	}
	
	//A method to create the window and display it to the user as well as creating instances of all the pages.
	private static void createWindow() {		

		//Creates instances of all the page panels.
		loginPage = new JPanel();
		salesPage = new JPanel();
		
		//Creates the window, setting the size and to close on exit.
		mainWindow = new JFrame("Gwent Grails Stock Mananagement System");
		mainWindow.setSize(800, 600);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adds the panels to the window.
		mainWindow.add(loginPage);
		mainWindow.add(salesPage);
		
		mainWindow.setVisible(true);
	}
	
	private static void createLoginPage() {
		
		loginPage.setLayout((null));
		
		//Creates all the of the content, setting boundaries and information for each one.
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
		
		
		//Makes the login page visible or not on launch.
		loginPage.setVisible(true);
	}
	
	private static void createSalesPage() {
		
		salesPage.setLayout((null));
		
		//Creates all the of the content, setting boundaries and information for each one.
		JLabel titleLabel = new JLabel("Stock Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		salesPage.add(titleLabel);
		
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		salesPage.add(gwentGrailsLogo);
		
		//Makes the login page visible or not on launch.
		salesPage.setVisible(true);
	}
	
	private static void createMenuBar() {
navigationBar = new JMenuBar();
		
		navigationMenu = new JMenu("Navigation");
		navigationBar.add(navigationMenu);
		
		loginMenu = new JMenu("Sign Out");
		navigationBar.add(loginMenu);
		
		overviewItem = new JMenuItem("Overview");
		navigationMenu.add(overviewItem);

		stockItem = new JMenuItem("Stock");
		navigationMenu.add(stockItem);
		
		investmentsItem = new JMenuItem("Investments");
		navigationMenu.add(investmentsItem);
		
		costsItem = new JMenuItem("Costs");
		navigationMenu.add(costsItem);
		
		soldItem = new JMenuItem("Sold");
		navigationMenu.add(soldItem);
		
		weeklyReviewItem = new JMenuItem("Weekly Review");
		navigationMenu.add(weeklyReviewItem);
		
		monthlyReviewItem = new JMenuItem("Monthly Review");
		navigationMenu.add(monthlyReviewItem);
		
		usersItem = new JMenuItem("Users");
		navigationMenu.add(usersItem);
		
		signOutItem = new JMenuItem("Sign Out");
		loginMenu.add(signOutItem);
		
		mainWindow.setJMenuBar(navigationBar);
	}
	
}

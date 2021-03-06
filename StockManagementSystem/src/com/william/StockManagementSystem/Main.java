
package com.william.StockManagementSystem;
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
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.william.stockApi.API;

public class Main implements ActionListener {
	
	private static JFrame mainWindow;
	private static JPanel loginPage, salesPage, containerPanel, overviewPage, investmentsPage, costsPage, soldPage, weeklyReviewPage, monthlyReviewPage, usersPage;
	private static JButton deleteUser, addUser, addCost, deleteCost, editCost, deleteSold, editSold, addInvestment, editInvestment, deleteInvestment, addStock, addStock2, addShoe, editShoe, deleteShoe, moveShoe, moveInvestment, loginButton, sortCostButton, filterSalesButton;
	private static JTable usersTable, costsTable, soldTable, investmentTable, shoeTable, weeklySoldTable, weeklyCostTable, weeklyShoeTable, weeklyInvestmentTable, monthlySoldTable, monthlyCostTable, monthlyShoeTable, monthlyInvestmentTable, costFilteredTable, salesFilterTable, investmentsFilterTable, soldFilterTable;
	private static JMenuBar navigationBar;
	private static JMenu navigationMenu, loginMenu;
	private static JMenuItem overviewItem, stockItem, investmentsItem, costsItem, soldItem, weeklyReviewItem, monthlyReviewItem, usersItem, signOutItem;
	private static JTextField usernameText, passwordText;
	private static JScrollPane usersPane, costsPane, soldPane, investmentPane, shoePane, weeklySoldPane, weeklyCostPane, weeklyShoePane, weeklyInvestmentPane, monthlySoldPane, monthlyCostPane, monthlyShoePane, monthlyInvestmentPane;
	private static JLabel usernameLabel, passwordLabel, salesCurrentValueLabel, salesPredictedProfitLabel, salesPredictedValueLabel, currentShoeValueLabel, predictedShoeValueLabel, predictedShoeProfitLabel, currentInvestmentValueLabel, predictedInvestmentValueLabel, predictedInvestmentProfitLabel, currentSoldValueLabel, actualSoldValueLabel, actualSoldProfitLabel, soldActualValueLabel, soldActualProfitLabel, soldCurrentValueLabel, investmentCurrentValueLabel, investmentPredictedValueLabel, investmentPredictedProfitLabel, totalReturnLabel, totalEquipmentLabel, totalPostageLabel, totalBotLabel, totalOtherLabel;
	private static CardLayout cl;
	private static JComboBox<String> sortCostList, salesCategoryList, salesSelectCategory;
	private static int costFilterRowID, salesFilterRowID, soldFilterRowID, investmentFilterRowID, adminCheck, userCheck;
	
	private static Color mainWindowBackground = new Color(183, 232, 225);
	private static Color textColour = new Color(63, 89, 86);
	private static Color backgroundColour = new Color(195, 235, 229);
	private static Color foregroundColour = new Color(40, 59, 57);
	private static Color borderColour = new Color(207, 250, 244);

	private static String[] stockCategories = {"Brand", "Size", "Colour", "Condition"};
	private static String[] costCategories = {"Bot", "Equipment", "Postage", "Returns",  "Other" };
	private static String[] brandCategories = {"Adidas", "Nike", "Jordan", "Yeezy", "Other" };
	private static String[] conditionCategories = {"Dead Stock", "Used", "Other" };
	private static String[] sizeCategories = {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
	private static String[] colourCategories = {"Black", "Blue", "Purple", "White", "Other"};
	private static String[] filterCostCategories = {"All", "Bot", "Equipment", "Postage", "Returns",  "Other" };
	private static String[] filterBrandCategories = {"All", "Adidas", "Nike", "Jordan", "Yeezy", "Other" };
	private static String[] filterConditionCategories = {"All", "Dead Stock", "Used", "Other" };
	private static String[] filterSizeCategories = {"All", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
	private static String[] filterColourCategories = {"All", "Black", "Blue", "Purple", "White", "Other"};

	public static void main(String[] args) {
		new Main().constructor();

	}
	
	
	public void constructor() {
		createWindow();
		createMenuBar();
		createContainerPanel();
		createLoginPage();
		createSalesPage();
		createOverviewPage();
		createInvestmentsPage();
		createCostsPage();
		createSoldPage();
		createWeeklyReviewPage();
		createMonthlyReviewPage();
		createUserPage();
		revalidateMainWindow();
	}
	
	//A method to create the window and display it to the user as well as creating instances of all the pages.
	
	private static void createWindow() {		
		

		//Creates instances of all the page panels.
		containerPanel = new JPanel();
		containerPanel.setBackground(mainWindowBackground);
		loginPage = new JPanel();
		loginPage.setBackground(mainWindowBackground);
		salesPage = new JPanel();
		salesPage.setBackground(mainWindowBackground);
		overviewPage = new JPanel();
		overviewPage.setBackground(mainWindowBackground);
		investmentsPage = new JPanel();
		investmentsPage.setBackground(mainWindowBackground);
		costsPage = new JPanel();
		costsPage.setBackground(mainWindowBackground);
		soldPage = new JPanel();
		soldPage.setBackground(mainWindowBackground);
		weeklyReviewPage = new JPanel();
		weeklyReviewPage.setBackground(mainWindowBackground);
		monthlyReviewPage = new JPanel();
		monthlyReviewPage.setBackground(mainWindowBackground);
		usersPage = new JPanel();
		usersPage.setBackground(mainWindowBackground);
		
		
		
		//Creates the window, setting the size and to close on exit.

		
		mainWindow = new JFrame("Gwent Grails Stock Mananagement System");
		mainWindow.setBackground(mainWindowBackground);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Adds the container panel to the window.
		mainWindow.add(containerPanel);
		mainWindow.setVisible(true);
		
	}
	
	
	private static void revalidateMainWindow() {
		
		
		mainWindow.invalidate();
		mainWindow.setPreferredSize(new Dimension(1200, 1000));
		mainWindow.pack();
		mainWindow.validate();
		mainWindow.repaint();
		
	}
	
	
	private static void createContainerPanel() {
		cl = new CardLayout();
		containerPanel.setLayout(cl);
		
		containerPanel.add(loginPage, "1");
		containerPanel.add(salesPage, "2");
		containerPanel.add(overviewPage, "3");
		containerPanel.add(investmentsPage, "4");
		containerPanel.add(costsPage, "5");
		containerPanel.add(soldPage, "6");
		containerPanel.add(weeklyReviewPage, "7");
		containerPanel.add(monthlyReviewPage, "8");
		containerPanel.add(usersPage, "9");
		
		cl.show(containerPanel,  "1");
	}
	
	
	private void createLoginPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBorder(new EmptyBorder(0,0,200,0));
		loginPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Login Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		titleLabel.setBorder(new EmptyBorder(0,350,200,450));
		titleLabel.setForeground(textColour);
		loginPage.add(titleLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont (usernameLabel.getFont ().deriveFont (30.0f));
		usernameLabel.setBorder(new EmptyBorder(50,500,0,500));
		usernameLabel.setForeground(textColour);
		loginPage.add(usernameLabel);
		
		usernameText = new JTextField("Username");
		usernameText.setFont (usernameText.getFont ().deriveFont (20.0f));
		usernameText.setBorder(new LineBorder(borderColour));
		usernameText.setForeground(foregroundColour);
		usernameText.setBackground(backgroundColour);
		loginPage.add(usernameText);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont (passwordLabel.getFont ().deriveFont (30.0f));
		passwordLabel.setBorder(new EmptyBorder(50,500,0,500));
		passwordLabel.setForeground(textColour);
		loginPage.add(passwordLabel);
		
		passwordText = new JTextField("Password");
		passwordText.setFont (passwordText.getFont ().deriveFont (20.0f));
		passwordText.setBorder(new LineBorder(borderColour));
		passwordText.setForeground(foregroundColour);
		passwordText.setBackground(backgroundColour);
		loginPage.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.setFont (loginButton.getFont ().deriveFont (20.0f));
		loginButton.setBorder(new LineBorder(borderColour));
		loginButton.setForeground(foregroundColour);
		loginButton.setBackground(backgroundColour);
		loginButton.addActionListener(this);
		loginPage.add(loginButton);
	}
	
	
	private void createSalesPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
		salesPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Current Stock Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		titleLabel.setBorder(new EmptyBorder(0,300,100,300));
		titleLabel.setForeground(textColour);
		salesPage.add(titleLabel);
		
		salesCurrentValueLabel = new JLabel("Current Value: ?" + caculateTotalShoeValue());
		salesCurrentValueLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesCurrentValueLabel.setBorder(new EmptyBorder(0,25,10,30));
		salesCurrentValueLabel.setForeground(textColour);
		salesPage.add(salesCurrentValueLabel);
		
		salesPredictedValueLabel = new JLabel("Predicted Sale Value: ?" + caculatePredictedShoeValue());
		salesPredictedValueLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPredictedValueLabel.setBorder(new EmptyBorder(0,25,19,30));
		salesPredictedValueLabel.setForeground(textColour);
		salesPage.add(salesPredictedValueLabel);
		
		salesPredictedProfitLabel = new JLabel("Predicted Profit Value: ?" + caculatePredictedShoeProfit());
		salesPredictedProfitLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPredictedProfitLabel.setBorder(new EmptyBorder(0,25,10, 25));
		salesPredictedProfitLabel.setForeground(textColour);
		salesPage.add(salesPredictedProfitLabel);
		
		addShoe = new JButton("Add Stock");
		addShoe.setFont (addShoe.getFont ().deriveFont (20.0f));
		addShoe.setBorder(new LineBorder(borderColour));
		addShoe.setForeground(foregroundColour);
		addShoe.setBackground(backgroundColour);
		addShoe.addActionListener(this);
		salesPage.add(addShoe);
		
		addStock2 = new JButton("New Stock Type");
		addStock2.setFont (addShoe.getFont ().deriveFont (20.0f));
		addStock2.setBorder(new LineBorder(borderColour));
		addStock2.setForeground(foregroundColour);
		addStock2.setBackground(backgroundColour);
		addStock2.addActionListener(this);
		salesPage.add(addStock2);
		
		editShoe = new JButton("Edit Stock");
		editShoe.setFont (addShoe.getFont ().deriveFont (20.0f));
		editShoe.setBorder(new LineBorder(borderColour));
		editShoe.setForeground(foregroundColour);
		editShoe.setBackground(backgroundColour);
		editShoe.addActionListener(this);
		salesPage.add(editShoe);
		
		deleteShoe = new JButton("Delete Stock");
		deleteShoe.setFont (addShoe.getFont ().deriveFont (20.0f));
		deleteShoe.setBorder(new LineBorder(borderColour));
		deleteShoe.setForeground(foregroundColour);
		deleteShoe.setBackground(backgroundColour);
		deleteShoe.addActionListener(this);
		salesPage.add(deleteShoe);
		
		moveShoe = new JButton("Mark as Sold");
		moveShoe.setFont (addShoe.getFont ().deriveFont (20.0f));
		moveShoe.setBorder(new LineBorder(borderColour));
		moveShoe.setForeground(foregroundColour);
		moveShoe.setBackground(backgroundColour);
		moveShoe.addActionListener(this);
		salesPage.add(moveShoe);
		
		salesSelectCategory = new JComboBox<String>(stockCategories);
		salesSelectCategory.setFont (addShoe.getFont ().deriveFont (20.0f));
		salesSelectCategory.setBorder(new LineBorder(borderColour));
		salesSelectCategory.setForeground(foregroundColour);
		salesSelectCategory.setBackground(backgroundColour);
		salesSelectCategory.addActionListener(this);
		salesPage.add(salesSelectCategory);
		
		salesCategoryList = new JComboBox<String>(filterBrandCategories);
		salesCategoryList.setFont (addShoe.getFont ().deriveFont (20.0f));
		salesCategoryList.setBorder(new LineBorder(borderColour));
		salesCategoryList.setForeground(foregroundColour);
		salesCategoryList.setBackground(backgroundColour);
		salesPage.add(salesCategoryList);
		
		filterSalesButton = new JButton("Filter Stock");
		filterSalesButton.setFont (addShoe.getFont ().deriveFont (20.0f));
		filterSalesButton.setBorder(new LineBorder(borderColour));
		filterSalesButton.setForeground(foregroundColour);
		filterSalesButton.setBackground(backgroundColour);
		filterSalesButton.addActionListener(this);
		salesPage.add(filterSalesButton);
		
		shoePane = new JScrollPane();
		createShoeTable();
		shoePane.getViewport().add(shoeTable);
		shoePane.setBorder(new LineBorder(mainWindowBackground));
		shoePane.setForeground(foregroundColour);
		salesPage.add(shoePane);
		
	}
		
	
	private void createOverviewPage() {
			
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
		overviewPage.add(gwentGrailsLogo);	
		
		JLabel titleLabel = new JLabel("Overview Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		titleLabel.setBorder(new EmptyBorder(0,300,100,300));
		titleLabel.setForeground(textColour);
		overviewPage.add(titleLabel);
		
		currentShoeValueLabel = new JLabel("Current Stock Value: ?" + caculateTotalShoeValue());
		currentShoeValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		currentShoeValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		currentShoeValueLabel.setForeground(textColour);
		overviewPage.add(currentShoeValueLabel);
		
		predictedShoeValueLabel = new JLabel("Predicted Stock Value: ?" + caculatePredictedShoeValue());
		predictedShoeValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		predictedShoeValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		predictedShoeValueLabel.setForeground(textColour);
		overviewPage.add(predictedShoeValueLabel);
		
		predictedShoeProfitLabel = new JLabel("Predicted Profit Value: ?" + caculatePredictedShoeProfit());
		predictedShoeProfitLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		predictedShoeProfitLabel.setBorder(new EmptyBorder(0,500,3,500));
		predictedShoeProfitLabel.setForeground(textColour);
		overviewPage.add(predictedShoeProfitLabel);
			
		currentInvestmentValueLabel = new JLabel("Current Investment Value: ?" + caculateTotalInvestmentValue());
		currentInvestmentValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		currentInvestmentValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		currentInvestmentValueLabel.setForeground(textColour);
		overviewPage.add(currentInvestmentValueLabel);
		
		predictedInvestmentValueLabel = new JLabel("Predicted Investment Value: ?" + caculatePredictedInvestmentValue());
		predictedInvestmentValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		predictedInvestmentValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		predictedInvestmentValueLabel.setForeground(textColour);
		overviewPage.add(predictedInvestmentValueLabel);
		
		predictedInvestmentProfitLabel = new JLabel("Predicted Investment Profit: ?" + caculatePredictedInvestmentProfit());
		predictedInvestmentProfitLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		predictedInvestmentProfitLabel.setBorder(new EmptyBorder(0,500,3,500));
		predictedInvestmentProfitLabel.setForeground(textColour);
		overviewPage.add(predictedInvestmentProfitLabel);
		
		currentSoldValueLabel = new JLabel("Total Shoe's Bought Value: ?" + caculateTotalSoldValue());
		currentSoldValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		currentSoldValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		currentSoldValueLabel.setForeground(textColour);
		overviewPage.add(currentSoldValueLabel);
		
		actualSoldValueLabel = new JLabel("Total Shoe's Sold Value: ?" + caculateActualSoldValue());
		actualSoldValueLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		actualSoldValueLabel.setBorder(new EmptyBorder(0,500,3,500));
		actualSoldValueLabel.setForeground(textColour);
		overviewPage.add(actualSoldValueLabel);
		
		actualSoldProfitLabel = new JLabel("Total Profit Value: ?" + caculateActualSoldProfit());
		actualSoldProfitLabel.setFont (currentShoeValueLabel.getFont ().deriveFont (30.0f));
		actualSoldProfitLabel.setBorder(new EmptyBorder(0,500,3,500));
		actualSoldProfitLabel.setForeground(textColour);
		overviewPage.add(actualSoldProfitLabel);
		
		
	}

	
	private void createInvestmentsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
				investmentsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Investments Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				titleLabel.setBorder(new EmptyBorder(0,300,100,300));
				titleLabel.setForeground(textColour);
				investmentsPage.add(titleLabel);
				
				investmentCurrentValueLabel = new JLabel("Current Value: ?" + caculateTotalInvestmentValue());
				investmentCurrentValueLabel.setFont (investmentCurrentValueLabel.getFont ().deriveFont (24.0f));
				investmentCurrentValueLabel.setBorder(new EmptyBorder(0,25,10,30));
				investmentCurrentValueLabel.setForeground(textColour);
				investmentsPage.add(investmentCurrentValueLabel);
				
				investmentPredictedValueLabel = new JLabel("Predicted Sale Value: ?" + caculatePredictedInvestmentValue());
				investmentPredictedValueLabel.setFont (investmentCurrentValueLabel.getFont ().deriveFont (24.0f));
				investmentPredictedValueLabel.setBorder(new EmptyBorder(0,25,10,30));
				investmentPredictedValueLabel.setForeground(textColour);
				investmentsPage.add(investmentPredictedValueLabel);
				
				investmentPredictedProfitLabel = new JLabel("Predicted Profit Value: ?" + caculatePredictedInvestmentProfit());
				investmentPredictedProfitLabel.setFont (investmentCurrentValueLabel.getFont ().deriveFont (24.0f));
				investmentPredictedProfitLabel.setBorder(new EmptyBorder(0,25,10,30));
				investmentPredictedProfitLabel.setForeground(textColour);
				investmentsPage.add(investmentPredictedProfitLabel);
				
				addInvestment = new JButton("Add Investment");
				addInvestment.setFont (addInvestment.getFont ().deriveFont (20.0f));
				addInvestment.setBorder(new LineBorder(borderColour));
				addInvestment.setForeground(foregroundColour);
				addInvestment.setBackground(backgroundColour);
				addInvestment.addActionListener(this);
				investmentsPage.add(addInvestment);
				
				addStock = new JButton("New Stock Type");
				addStock.setFont (investmentCurrentValueLabel.getFont ().deriveFont (20.0f));
				addStock.setBorder(new LineBorder(borderColour));
				addStock.setForeground(foregroundColour);
				addStock.setBackground(backgroundColour);
				addStock.addActionListener(this);
				investmentsPage.add(addStock);
				
				editInvestment = new JButton("Edit Investment");
				editInvestment.setFont (investmentCurrentValueLabel.getFont ().deriveFont (20.0f));
				editInvestment.setBorder(new LineBorder(borderColour));
				editInvestment.setForeground(foregroundColour);
				editInvestment.setBackground(backgroundColour);
				editInvestment.addActionListener(this);
				investmentsPage.add(editInvestment);
				
				deleteInvestment = new JButton("Delete Investment");
				deleteInvestment.setFont (investmentCurrentValueLabel.getFont ().deriveFont (20.0f));
				deleteInvestment.setBorder(new LineBorder(borderColour));
				deleteInvestment.setForeground(foregroundColour);
				deleteInvestment.setBackground(backgroundColour);
				deleteInvestment.addActionListener(this);
				investmentsPage.add(deleteInvestment);
				
				moveInvestment = new JButton("Mark as Sold");
				moveInvestment.setFont (investmentCurrentValueLabel.getFont ().deriveFont (20.0f));
				moveInvestment.setBorder(new LineBorder(borderColour));
				moveInvestment.setForeground(foregroundColour);
				moveInvestment.setBackground(backgroundColour);
				moveInvestment.addActionListener(this);
				investmentsPage.add(moveInvestment);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				sortStockList.setFont (sortStockList.getFont ().deriveFont (20.0f));
				sortStockList.setBorder(new LineBorder(borderColour));
				sortStockList.setForeground(foregroundColour);
				sortStockList.setBackground(backgroundColour);
				investmentsPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Investments");
				sortStockButton.setFont (investmentCurrentValueLabel.getFont ().deriveFont (20.0f));
				sortStockButton.setBorder(new LineBorder(borderColour));
				sortStockButton.setForeground(foregroundColour);
				sortStockButton.setBackground(backgroundColour);
				investmentsPage.add(sortStockButton);
				
				investmentPane = new JScrollPane();
				createInvestmentTable();
				investmentPane.getViewport().add(investmentTable);
				investmentPane.setBorder(new LineBorder(mainWindowBackground));
				investmentPane.setForeground(foregroundColour);
				investmentsPage.add(investmentPane);
		
	}
	
	
	private void createSoldPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
				soldPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Sold Stock Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				titleLabel.setBorder(new EmptyBorder(0,300,100,300));
				titleLabel.setForeground(textColour);
				soldPage.add(titleLabel);
				
				soldCurrentValueLabel = new JLabel("Total Bought Value: ?" + caculateTotalSoldValue());
				soldCurrentValueLabel.setFont (soldCurrentValueLabel.getFont ().deriveFont (24.0f));
				soldCurrentValueLabel.setBorder(new EmptyBorder(0,25,0,30));
				soldCurrentValueLabel.setForeground(textColour);
				soldPage.add(soldCurrentValueLabel);
				
				soldActualValueLabel = new JLabel("Total Sold Value: ?" + caculateActualSoldValue());
				soldActualValueLabel.setFont (soldActualValueLabel.getFont ().deriveFont (24.0f));
				soldActualValueLabel.setBorder(new EmptyBorder(0,25,0,30));
				soldActualValueLabel.setForeground(textColour);
				soldPage.add(soldActualValueLabel);
				
				soldActualProfitLabel = new JLabel("Total Profit Value: ?" + caculateActualSoldProfit());
				soldActualProfitLabel.setFont (soldActualProfitLabel.getFont ().deriveFont (24.0f));
				soldActualProfitLabel.setBorder(new EmptyBorder(0,25,0,50));
				soldActualProfitLabel.setForeground(textColour);
				soldPage.add(soldActualProfitLabel);
			
				deleteSold = new JButton("Delete Stock");
				deleteSold.setFont (deleteSold.getFont ().deriveFont (20.0f));
				deleteSold.setBorder(new LineBorder(borderColour));
				deleteSold.setBorder(new EmptyBorder(0,60,0,60));
				deleteSold.setForeground(foregroundColour);
				deleteSold.setBackground(backgroundColour);
				deleteSold.addActionListener(this);
				soldPage.add(deleteSold);
				
				editSold = new JButton("Edit Stock");
				editSold.setFont (editSold.getFont ().deriveFont (20.0f));
				editSold.setBorder(new LineBorder(borderColour));
				editSold.setBorder(new EmptyBorder(0,60,0,60));
				editSold.setForeground(foregroundColour);
				editSold.setBackground(backgroundColour);
				editSold.addActionListener(this);
				soldPage.add(editSold);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				sortStockList.setFont (sortStockList.getFont ().deriveFont (20.0f));
				sortStockList.setBorder(new LineBorder(borderColour));
				sortStockList.setForeground(foregroundColour);
				sortStockList.setBackground(backgroundColour);
				soldPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Stock");
				sortStockButton.setFont (sortStockButton.getFont ().deriveFont (20.0f));
				sortStockButton.setBorder(new LineBorder(borderColour));
				sortStockButton.setBorder(new EmptyBorder(0,60,0,60));
				sortStockButton.setForeground(foregroundColour);
				sortStockButton.setBackground(backgroundColour);
				soldPage.add(sortStockButton);
				
				soldPane = new JScrollPane();
				createSoldTable();
				soldPane.getViewport().add(soldTable);
				soldPane.setBorder(new LineBorder(mainWindowBackground));
				soldPane.setForeground(foregroundColour);
				soldPane.getViewport().add(soldTable);
				soldPage.add(soldPane);
				
				JLabel filler = new JLabel();
				filler.setFont (filler.getFont ().deriveFont (24.0f));
				filler.setBorder(new EmptyBorder(0,25,0,300));
				filler.setForeground(textColour);
				soldPage.add(filler);
		
	}
	

	
	private void createCostsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
				costsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Company Costs Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				titleLabel.setBorder(new EmptyBorder(0,280,100,280));
				titleLabel.setForeground(textColour);
				costsPage.add(titleLabel);
				
				totalReturnLabel = new JLabel("Total Returns Cost: ?" + caculateTotalReturnsValue());
				totalReturnLabel.setFont (totalReturnLabel.getFont ().deriveFont (24.0f));
				totalReturnLabel.setBorder(new EmptyBorder(0,25,0,30));
				totalReturnLabel.setForeground(textColour);
				costsPage.add(totalReturnLabel);
				
				totalEquipmentLabel = new JLabel("Total Equipment Cost: ?" + caculateTotalEquipmentValue());
				totalEquipmentLabel.setFont (totalEquipmentLabel.getFont ().deriveFont (24.0f));
				totalEquipmentLabel.setBorder(new EmptyBorder(0,25,0,30));
				totalEquipmentLabel.setForeground(textColour);
				costsPage.add(totalEquipmentLabel);
				
				totalPostageLabel = new JLabel("Total Postage Cost Value: ?" + caculateTotalPostageValue());
				totalPostageLabel.setFont (totalPostageLabel.getFont ().deriveFont (24.0f));
				totalPostageLabel.setBorder(new EmptyBorder(0,25,0,30));
				totalPostageLabel.setForeground(textColour);
				costsPage.add(totalPostageLabel);
				
				totalBotLabel = new JLabel("Total Bot Cost Value: ?" + caculateTotalBotValue());
				totalBotLabel.setFont (totalBotLabel.getFont ().deriveFont (24.0f));
				totalBotLabel.setBorder(new EmptyBorder(0,25,0,30));
				totalBotLabel.setForeground(textColour);
				costsPage.add(totalBotLabel);
				
				totalOtherLabel = new JLabel("Total Other Cost Value: ?" + caculateTotalOtherValue());
				totalOtherLabel.setFont (totalOtherLabel.getFont ().deriveFont (24.0f));
				totalOtherLabel.setBorder(new EmptyBorder(0,25,0,30));
				totalOtherLabel.setForeground(textColour);
				costsPage.add(totalOtherLabel);
				
				addCost = new JButton("Add Cost");
				addCost.setFont (addCost.getFont ().deriveFont (20.0f));
				addCost.setBorder(new LineBorder(borderColour));
				addCost.setForeground(foregroundColour);
				addCost.setBackground(backgroundColour);
				addCost.addActionListener(this);
				costsPage.add(addCost);
				
				editCost = new JButton("Edit Cost");
				editCost.setFont (editCost.getFont ().deriveFont (20.0f));
				editCost.setBorder(new LineBorder(borderColour));
				editCost.setForeground(foregroundColour);
				editCost.setBackground(backgroundColour);
				editCost.addActionListener(this);
				costsPage.add(editCost);
				
				deleteCost = new JButton("Delete Cost");
				deleteCost.setFont (deleteCost.getFont ().deriveFont (20.0f));
				deleteCost.setBorder(new LineBorder(borderColour));
				deleteCost.setForeground(foregroundColour);
				deleteCost.setBackground(backgroundColour);
				deleteCost.addActionListener(this);
				costsPage.add(deleteCost);
				
				sortCostList = new JComboBox<String>(filterCostCategories);
				sortCostList.setFont (sortCostList.getFont ().deriveFont (20.0f));
				sortCostList.setBorder(new LineBorder(borderColour));
				sortCostList.setForeground(foregroundColour);
				sortCostList.setBackground(backgroundColour);
				costsPage.add(sortCostList);
				
				sortCostButton = new JButton("Filter Cost");
				sortCostButton.setFont (sortCostButton.getFont ().deriveFont (20.0f));
				sortCostButton.setBorder(new LineBorder(borderColour));
				sortCostButton.setForeground(foregroundColour);
				sortCostButton.setBackground(backgroundColour);
				sortCostButton.addActionListener(this);
				costsPage.add(sortCostButton);

				costsPane = new JScrollPane();
				createCostTable();
				costsPane.setBorder(new LineBorder(mainWindowBackground));
				costsPane.setForeground(foregroundColour);
				costsPane.getViewport().add(costsTable);
				costsPage.add(costsPane);
		
	}
	
	
	private void createWeeklyReviewPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		weeklyReviewPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Weekly Review Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		weeklyReviewPage.add(titleLabel);
		
		JLabel totalCost = new JLabel("Total Cost This Week: N/A");
		weeklyReviewPage.add(totalCost);
		
		JLabel totalSales = new JLabel("Total Sales This Week: N/A");
		weeklyReviewPage.add(totalSales);
		
		JLabel totalProfit = new JLabel("Total Profit This Week: N/A");
		weeklyReviewPage.add(totalProfit);
		
		JComboBox<String> selectWeekList = new JComboBox<String>(stockCategories);
		weeklyReviewPage.add(selectWeekList);
		
		JButton changeWeek = new JButton("Change Week");
		weeklyReviewPage.add(changeWeek);
		
		weeklySoldPane = new JScrollPane();
		weeklyShoePane = new JScrollPane();
		weeklyCostPane = new JScrollPane();
		weeklyInvestmentPane = new JScrollPane();
		createWeeklyReviewTables();
		weeklySoldPane.getViewport().add(weeklySoldTable);
		weeklyShoePane.getViewport().add(weeklyShoeTable);
		weeklyInvestmentPane.getViewport().add(weeklyInvestmentTable);
		weeklyCostPane.getViewport().add(weeklyCostTable);
		weeklyReviewPage.add(weeklyShoePane);
		weeklyReviewPage.add(weeklyInvestmentPane);
		weeklyReviewPage.add(weeklyCostPane);
		weeklyReviewPage.add(weeklySoldPane);
	}
	
	
	private void createMonthlyReviewPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
			ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
			JLabel gwentGrailsLogo = new JLabel(ggLogo);
			gwentGrailsLogo.setBounds(0, 0, 100, 100);
			monthlyReviewPage.add(gwentGrailsLogo);
			
			JLabel titleLabel = new JLabel("Monthly Review Page");
			titleLabel.setBounds(250, 20, 500, 80);
			titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
			monthlyReviewPage.add(titleLabel);
			
			JLabel totalCost = new JLabel("Total Cost This Month: N/A");
			monthlyReviewPage.add(totalCost);
			
			JLabel totalSales = new JLabel("Total Sales This Month: N/A");
			monthlyReviewPage.add(totalSales);
			
			JLabel totalProfit = new JLabel("Total Profit This Month: N/A");
			monthlyReviewPage.add(totalProfit);
			
			JComboBox<String> selectMonthList = new JComboBox<String>(stockCategories);
			monthlyReviewPage.add(selectMonthList);
			
			JButton changeMonth = new JButton("Change Month");
			monthlyReviewPage.add(changeMonth);
			
			monthlySoldPane = new JScrollPane();
			monthlyShoePane = new JScrollPane();
			monthlyCostPane = new JScrollPane();
			monthlyInvestmentPane = new JScrollPane();
			createMonthlyReviewTables();
			monthlySoldPane.getViewport().add(monthlySoldTable);
			monthlyShoePane.getViewport().add(monthlyShoeTable);
			monthlyInvestmentPane.getViewport().add(monthlyInvestmentTable);
			monthlyCostPane.getViewport().add(monthlyCostTable);
			monthlyReviewPage.add(monthlyShoePane);
			monthlyReviewPage.add(monthlyInvestmentPane);
			monthlyReviewPage.add(monthlyCostPane);
			monthlyReviewPage.add(monthlySoldPane);
	}
	
	
	private void createUserPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBorder(new EmptyBorder(0,0,100,0));
		usersPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("User Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		titleLabel.setBorder(new EmptyBorder(0,280,100,280));
		titleLabel.setForeground(textColour);
		usersPage.add(titleLabel);
		
		JLabel filler2 = new JLabel(".");
		filler2.setFont (titleLabel.getFont ().deriveFont (0.5f));
		filler2.setBorder(new EmptyBorder(0,280,30,0));
		filler2.setForeground(textColour);
		usersPage.add(filler2);
		
		addUser = new JButton("Add User");
		addUser.setFont (addUser.getFont ().deriveFont (20.0f));
		addUser.setBorder(new LineBorder(borderColour));
		addUser.setBorder(new EmptyBorder(0,60,30,60));
		addUser.setForeground(foregroundColour);
		addUser.setBackground(backgroundColour);
		addUser.addActionListener(this);
		usersPage.add(addUser);
		
		deleteUser = new JButton("Delete User");
		deleteUser.setFont (deleteUser.getFont ().deriveFont (20.0f));
		deleteUser.setBorder(new LineBorder(borderColour));
		deleteUser.setBorder(new EmptyBorder(0,60,30,60));
		deleteUser.setForeground(foregroundColour);
		deleteUser.setBackground(backgroundColour);
		deleteUser.addActionListener(this);
		usersPage.add(deleteUser);
		
		JLabel filler = new JLabel(".");
		filler.setFont (titleLabel.getFont ().deriveFont (0.5f));
		filler.setBorder(new EmptyBorder(0,60,30,280));
		filler.setForeground(textColour);
		usersPage.add(filler);
		
		usersPane = new JScrollPane();
		createUserTable();
		usersPane.getViewport().add(usersTable);
		usersPane.setBorder(new LineBorder(mainWindowBackground));
		usersPane.setForeground(foregroundColour);
		usersPage.add(usersPane);
	}
	
	
	private void createUserTable() {
		String[][] usersTableData = API.getUsers();
		String[] usersTableColumns = {"ID", "Username"};

									
		usersTable = new JTable(usersTableData, usersTableColumns) {

			public boolean isCellEditable(int data, int columns) {
					
				return false;
					
			}
				
		};
		usersTable.setPreferredScrollableViewportSize(new Dimension(600,300));
		usersTable.setFillsViewportHeight(true);
		usersTable.setFont (usersTable.getFont ().deriveFont (12.0f));
		usersTable.setBorder(new LineBorder(mainWindowBackground));
		usersTable.setForeground(foregroundColour);
		
		JTableHeader header = usersTable.getTableHeader();
		header.setBackground(backgroundColour);
		header.setForeground(foregroundColour);
		usersTable.setBackground(mainWindowBackground);
	}
	
	
	private void createCostTable() {
		String[][] costsTableData = API.getCosts();
		String[] costsTableColumns = {"ID", "Name", "Category", "Price", "Date"};

									
		costsTable = new JTable(costsTableData, costsTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		costsTable.setPreferredScrollableViewportSize(new Dimension(600,300));
		costsTable.setFillsViewportHeight(true);
		costsTable.setFont (costsTable.getFont ().deriveFont (12.0f));
		costsTable.setBorder(new LineBorder(mainWindowBackground));
		costsTable.setForeground(foregroundColour);
		
		JTableHeader header = costsTable.getTableHeader();
		header.setBackground(backgroundColour);
		header.setForeground(foregroundColour);
		costsTable.setBackground(mainWindowBackground);
	}
	
	
	private void createSoldTable() {
		String[] soldTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Sold", "Condition", "Date Bought", "Date Sold"};
		String[][] soldTableData = API.getSold();
									
		soldTable = new JTable(soldTableData, soldTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		soldTable.setPreferredScrollableViewportSize(new Dimension(600,300));
		soldTable.setFillsViewportHeight(true);
		soldTable.setFont (soldTable.getFont ().deriveFont (12.0f));
		soldTable.setBorder(new LineBorder(mainWindowBackground));
		soldTable.setForeground(foregroundColour);
		
		JTableHeader header = soldTable.getTableHeader();
		header.setBackground(backgroundColour);
		header.setForeground(foregroundColour);
		soldTable.setBackground(mainWindowBackground);
	}
	
	
	private void createWeeklyReviewTables() {
		String[] soldTableColumns = {"ID", "Name", "Sold", "Date Sold"};
		String[][] soldTableData = API.getSold();
		String[][] weeklySoldTableData = new String[soldTableData.length][4];
		
		
		for (int i = 0; i < soldTableData.length; i++) {
			String soldDataID = soldTableData[i][0];
			String soldDataName = soldTableData[i][1];
			String soldDataSold = soldTableData[i][7];
			String soldDataDateSell = soldTableData[i][10];
			
			weeklySoldTableData[i][0] = soldDataID;
			weeklySoldTableData[i][1] = soldDataName;
			weeklySoldTableData[i][2] = soldDataSold;
			weeklySoldTableData[i][3] = soldDataDateSell;
		}
		
		String[] costTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] costTableData = API.getCosts();
		String[][] weeklyCostTableData = new String[costTableData.length][4];
		
		for (int i = 0; i < costTableData.length; i++) {
			String costDataID = costTableData[i][0];
			String costDataName = costTableData[i][1];
			String costDataPrice = costTableData[i][2];
			String costDataDateSell = costTableData[i][4];
			
			weeklyCostTableData[i][0] = costDataID;
			weeklyCostTableData[i][1] = costDataName;
			weeklyCostTableData[i][2] = costDataPrice;
			weeklyCostTableData[i][3] = costDataDateSell;
		}
		
		String[] shoeTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] shoeTableData = API.getShoe();
		String[][] weeklyShoeTableData = new String[shoeTableData.length][4];
		
		for (int i = 0; i < shoeTableData.length; i++) {
			String shoeDataID = shoeTableData[i][0];
			String shoeDataName = shoeTableData[i][1];
			String shoeDataPrice = shoeTableData[i][4];
			String shoeDataDateSell = shoeTableData[i][8];
			
			weeklyShoeTableData[i][0] = shoeDataID;
			weeklyShoeTableData[i][1] = shoeDataName;
			weeklyShoeTableData[i][2] = shoeDataPrice;
			weeklyShoeTableData[i][3] = shoeDataDateSell;
		}
		
		String[] investmentTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] investmentTableData = API.getInvestment();
		String[][] weeklyInvestmentTableData = new String[investmentTableData.length][4];
		
		for (int i = 0; i < investmentTableData.length; i++) {
			String investmentDataID = investmentTableData[i][0];
			String investmentDataName = investmentTableData[i][1];
			String investmentDataPrice = investmentTableData[i][5];
			String investmentDataDateSell = investmentTableData[i][8];
			
			weeklyInvestmentTableData[i][0] = investmentDataID;
			weeklyInvestmentTableData[i][1] = investmentDataName;
			weeklyInvestmentTableData[i][2] = investmentDataPrice;
			weeklyInvestmentTableData[i][3] = investmentDataDateSell;
		}
		
									
		weeklySoldTable = new JTable(weeklySoldTableData, soldTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		weeklyCostTable = new JTable(weeklyCostTableData, costTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		weeklyShoeTable = new JTable(weeklyShoeTableData, shoeTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		weeklyInvestmentTable = new JTable(weeklyInvestmentTableData, investmentTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
	}
	
	
	private void createMonthlyReviewTables() {
		String[] soldTableColumns = {"ID", "Name", "Sold", "Date Sold"};
		String[][] soldTableData = API.getSold();
		String[][] monthlySoldTableData = new String[soldTableData.length][4];
		
		
		for (int i = 0; i < soldTableData.length; i++) {
			String soldDataID = soldTableData[i][0];
			String soldDataName = soldTableData[i][1];
			String soldDataSold = soldTableData[i][7];
			String soldDataDateSell = soldTableData[i][10];
			
			monthlySoldTableData[i][0] = soldDataID;
			monthlySoldTableData[i][1] = soldDataName;
			monthlySoldTableData[i][2] = soldDataSold;
			monthlySoldTableData[i][3] = soldDataDateSell;
		}
		
		String[] costTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] costTableData = API.getCosts();
		String[][] monthlyCostTableData = new String[costTableData.length][4];
		
		for (int i = 0; i < costTableData.length; i++) {
			String costDataID = costTableData[i][0];
			String costDataName = costTableData[i][1];
			String costDataPrice = costTableData[i][2];
			String costDataDateSell = costTableData[i][4];
			
			monthlyCostTableData[i][0] = costDataID;
			monthlyCostTableData[i][1] = costDataName;
			monthlyCostTableData[i][2] = costDataPrice;
			monthlyCostTableData[i][3] = costDataDateSell;
		}
		
		String[] shoeTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] shoeTableData = API.getShoe();
		String[][] monthlyShoeTableData = new String[shoeTableData.length][4];
		
		for (int i = 0; i < shoeTableData.length; i++) {
			String shoeDataID = shoeTableData[i][0];
			String shoeDataName = shoeTableData[i][1];
			String shoeDataPrice = shoeTableData[i][4];
			String shoeDataDateSell = shoeTableData[i][8];
			
			monthlyShoeTableData[i][0] = shoeDataID;
			monthlyShoeTableData[i][1] = shoeDataName;
			monthlyShoeTableData[i][2] = shoeDataPrice;
			monthlyShoeTableData[i][3] = shoeDataDateSell;
		}
		
		String[] investmentTableColumns = {"ID", "Name", "Price", "Date"};
		String[][] investmentTableData = API.getInvestment();
		String[][] monthlyInvestmentTableData = new String[investmentTableData.length][4];
		
		for (int i = 0; i < investmentTableData.length; i++) {
			String investmentDataID = investmentTableData[i][0];
			String investmentDataName = investmentTableData[i][1];
			String investmentDataPrice = investmentTableData[i][5];
			String investmentDataDateSell = investmentTableData[i][8];
			
			monthlyInvestmentTableData[i][0] = investmentDataID;
			monthlyInvestmentTableData[i][1] = investmentDataName;
			monthlyInvestmentTableData[i][2] = investmentDataPrice;
			monthlyInvestmentTableData[i][3] = investmentDataDateSell;
		}
		
									
		monthlySoldTable = new JTable(monthlySoldTableData, soldTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		monthlyCostTable = new JTable(monthlyCostTableData, costTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		monthlyShoeTable = new JTable(monthlyShoeTableData, shoeTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		monthlyInvestmentTable = new JTable(monthlyInvestmentTableData, investmentTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
	}
	
	
	private void createInvestmentTable() {
		String[] investmentsTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Condition", "Date Bought", "Date to Sell"};
		String[][] investmentsTableData = API.getInvestment();
									
		investmentTable = new JTable(investmentsTableData, investmentsTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		investmentTable.setPreferredScrollableViewportSize(new Dimension(600,300));
		investmentTable.setFillsViewportHeight(true);
		investmentTable.setFont (investmentTable.getFont ().deriveFont (12.0f));
		investmentTable.setBorder(new LineBorder(mainWindowBackground));
		investmentTable.setForeground(foregroundColour);
		
		JTableHeader header = investmentTable.getTableHeader();
		header.setBackground(backgroundColour);
		header.setForeground(foregroundColour);
		investmentTable.setBackground(mainWindowBackground);
		
	}
	
	
	private void createShoeTable() {
		String[] shoeTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Condition", "Date Bought"};
		String[][] shoeTableData = API.getShoe();
		shoeTable = new JTable(shoeTableData, shoeTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		shoeTable.setPreferredScrollableViewportSize(new Dimension(600,300));
		shoeTable.setFillsViewportHeight(true);
		shoeTable.setFont (shoeTable.getFont ().deriveFont (12.0f));
		shoeTable.setBorder(new LineBorder(mainWindowBackground));
		shoeTable.setForeground(foregroundColour);
		
		JTableHeader header = shoeTable.getTableHeader();
		header.setBackground(backgroundColour);
		header.setForeground(foregroundColour);
		shoeTable.setBackground(mainWindowBackground);
	}
	
	
	private void createMenuBar() {
		
		//Creates instances of the menu bar and it's items ready for navigation and sign out to be implemented.
		navigationBar = new JMenuBar();
		
		navigationMenu = new JMenu("Navigation");
		navigationBar.add(navigationMenu);
		
		loginMenu = new JMenu("Sign Out");
		navigationBar.add(loginMenu);
		
		overviewItem = new JMenuItem("Overview");
		overviewItem.addActionListener(this);
		navigationMenu.add(overviewItem);

		stockItem = new JMenuItem("Stock");
		stockItem.addActionListener(this);
		navigationMenu.add(stockItem);
		
		investmentsItem = new JMenuItem("Investments");
		investmentsItem.addActionListener(this);
		navigationMenu.add(investmentsItem);
		
		costsItem = new JMenuItem("Costs");
		costsItem.addActionListener(this);
		navigationMenu.add(costsItem);
		
		soldItem = new JMenuItem("Sold");
		soldItem.addActionListener(this);
		navigationMenu.add(soldItem);
		
		weeklyReviewItem = new JMenuItem("Weekly Review");
		weeklyReviewItem.addActionListener(this);
		navigationMenu.add(weeklyReviewItem);
		
		monthlyReviewItem = new JMenuItem("Monthly Review");
		monthlyReviewItem.addActionListener(this);
		navigationMenu.add(monthlyReviewItem);
		
		usersItem = new JMenuItem("Users");
		usersItem.addActionListener(this);
		navigationMenu.add(usersItem);
		
		signOutItem = new JMenuItem("Sign Out");
		signOutItem.addActionListener(this);
		loginMenu.add(signOutItem);
		
		navigationBar.setVisible(false);
		mainWindow.setJMenuBar(navigationBar);
	}

	private String caculateTotalShoeValue() {
		double totalShoeValue = 0;
		String[][] shoeTableData = API.getShoe();
		
		for (int i = 0; i < shoeTableData.length; i++) {
			totalShoeValue = totalShoeValue + Double.parseDouble(shoeTableData[i][5]);
		}
		
		String totalShoeValueString = String.format("%.2f", totalShoeValue);
		
		return totalShoeValueString;
		
	}
	
	private String caculatePredictedShoeValue() {
		double predictedShoeValue = 0;
		String[][] shoeTableData = API.getShoe();
		
		for (int i = 0; i < shoeTableData.length; i++) {
			predictedShoeValue = predictedShoeValue + Double.parseDouble(shoeTableData[i][6]);
		}
		
		String predictedShoeValueString = String.format("%.2f", predictedShoeValue);
		
		return predictedShoeValueString;
		
	}
	
	private String caculatePredictedShoeProfit() {
		double totalCost = Double.parseDouble(caculateTotalShoeValue());
		double totalSale = Double.parseDouble(caculatePredictedShoeValue());
		BigDecimal cost = BigDecimal.valueOf(totalCost);
		BigDecimal sale = BigDecimal.valueOf(totalSale);
		BigDecimal profit = sale.subtract(cost);
		
		String predictedProfit = profit.toString();
		return predictedProfit;
	}
	
	private String caculateTotalInvestmentValue() {
		double totalInvestmentValue = 0;
		String[][] investmentTableData = API.getInvestment();
		
		for (int i = 0; i < investmentTableData.length; i++) {
			totalInvestmentValue = totalInvestmentValue + Double.parseDouble(investmentTableData[i][5]);
		}
		
		String totalInvestmentValueString = String.format("%.2f", totalInvestmentValue);
		
		return totalInvestmentValueString;
		
	}
	
	private String caculatePredictedInvestmentValue() {
		double predictedInvestmentValue = 0;
		String[][] investmentTableData = API.getInvestment();
		
		for (int i = 0; i < investmentTableData.length; i++) {
			predictedInvestmentValue = predictedInvestmentValue + Double.parseDouble(investmentTableData[i][6]);
		}
		
		String predictedShoeValueString = String.format("%.2f", predictedInvestmentValue);
		
		return predictedShoeValueString;
		
	}
	
	private String caculatePredictedInvestmentProfit() {
		double totalCost = Double.parseDouble(caculateTotalInvestmentValue());
		double totalSale = Double.parseDouble(caculatePredictedInvestmentValue());
		BigDecimal cost = BigDecimal.valueOf(totalCost);
		BigDecimal sale = BigDecimal.valueOf(totalSale);
		BigDecimal profit = sale.subtract(cost);
		
		String predictedProfit = profit.toString();
		return predictedProfit;
	}
	
	private String caculateTotalReturnsValue() {

		double totalCategoryValue = 0;
		String categoryName = "a";
		String[][] costTableData = API.getCosts();
		
		for (int i = 0; i < costTableData.length; i++) {
			categoryName = costTableData[i][2];
			if (categoryName.equals("Returns")) {
				totalCategoryValue = totalCategoryValue + Double.parseDouble(costTableData[i][3]);
			}
		}
			
		String totalCategoryValueString = String.format("%.2f", totalCategoryValue);
			
		return totalCategoryValueString;
			

	}
	
	private String caculateTotalEquipmentValue() {

		double totalCategoryValue = 0;
		String categoryName = "a";
		String[][] costTableData = API.getCosts();
		
		for (int i = 0; i < costTableData.length; i++) {
			categoryName = costTableData[i][2];
			if (categoryName.equals("Equipment")) {
				totalCategoryValue = totalCategoryValue + Double.parseDouble(costTableData[i][3]);
			}
		}
			
		String totalCategoryValueString = String.format("%.2f", totalCategoryValue);
			
		return totalCategoryValueString;
			

	}
	
	private String caculateTotalPostageValue() {

		double totalCategoryValue = 0;
		String categoryName = "a";
		String[][] costTableData = API.getCosts();
		
		for (int i = 0; i < costTableData.length; i++) {
			categoryName = costTableData[i][2];
			if (categoryName.equals("Postage")) {
				totalCategoryValue = totalCategoryValue + Double.parseDouble(costTableData[i][3]);
			}
		}
			
		String totalCategoryValueString = String.format("%.2f", totalCategoryValue);
			
		return totalCategoryValueString;
			

	}
	
	private String caculateTotalBotValue() {

		double totalCategoryValue = 0;
		String categoryName = "a";
		String[][] costTableData = API.getCosts();
		
		for (int i = 0; i < costTableData.length; i++) {
			categoryName = costTableData[i][2];
			if (categoryName.equals("Bot")) {
				totalCategoryValue = totalCategoryValue + Double.parseDouble(costTableData[i][3]);
			}
		}
			
		String totalCategoryValueString = String.format("%.2f", totalCategoryValue);
			
		return totalCategoryValueString;
			

	}
	
	private String caculateTotalOtherValue() {

		double totalCategoryValue = 0;
		String categoryName = "a";
		String[][] costTableData = API.getCosts();
		
		for (int i = 0; i < costTableData.length; i++) {
			categoryName = costTableData[i][2];
			if (categoryName.equals("Other")) {
				totalCategoryValue = totalCategoryValue + Double.parseDouble(costTableData[i][3]);
			}
		}
			
		String totalCategoryValueString = String.format("%.2f", totalCategoryValue);
			
		return totalCategoryValueString;
			

	}
	
	private String caculateTotalSoldValue() {
		double totalSoldValue = 0;
		String[][] soldTableData = API.getSold();
		
		for (int i = 0; i < soldTableData.length; i++) {
			totalSoldValue = totalSoldValue + Double.parseDouble(soldTableData[i][5]);
		}
		
		String totalSoldValueString = String.format("%.2f", totalSoldValue);
		
		return totalSoldValueString;
		
	}
	
	private String caculateActualSoldValue() {
		double actualSoldValue = 0;
		String[][] soldTableData = API.getSold();
		
		for (int i = 0; i < soldTableData.length; i++) {
			actualSoldValue = actualSoldValue + Double.parseDouble(soldTableData[i][7]);
		}
		
		String actualSoldValueString = String.format("%.2f", actualSoldValue);
		
		return actualSoldValueString;
		
	}
	
	private String caculateActualSoldProfit() {
		double totalCost = Double.parseDouble(caculateTotalSoldValue());
		double totalSale = Double.parseDouble(caculateActualSoldValue());
		BigDecimal cost = BigDecimal.valueOf(totalCost);
		BigDecimal sale = BigDecimal.valueOf(totalSale);
		BigDecimal profit = sale.subtract(cost);
		
		String actualProfit = profit.toString();
		return actualProfit;
	}
	
	private String getDate() {
		Date dateToday = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
		String dateString = formatter.format(dateToday);
		System.out.println(dateString);
		
		return dateString;
		
	}

	private void updateLabels() {
		
		currentShoeValueLabel.setText("Current Stock Value: ?" + caculateTotalShoeValue());
		predictedShoeValueLabel.setText("Predicted Stock Value: ?" + caculatePredictedShoeValue());
		predictedShoeProfitLabel.setText("Predicted Profit Value: ?" + caculatePredictedShoeProfit());
		currentInvestmentValueLabel.setText("Current Investment Value: ?" + caculateTotalInvestmentValue());
		predictedInvestmentValueLabel.setText("Predicted Investment Value: ?" + caculatePredictedInvestmentValue());
		predictedInvestmentProfitLabel.setText("Predicted Investment Profit: ?" + caculatePredictedInvestmentProfit());
		currentSoldValueLabel.setText("Total Shoe's Bought Value: ?" + caculateTotalSoldValue());
		actualSoldValueLabel.setText("Total Shoe's Sold Value: ?" + caculateActualSoldValue());
		actualSoldProfitLabel.setText("Total Profit Value: ?" + caculateActualSoldProfit());
		
		salesCurrentValueLabel.setText("Current Value: ?" + caculateTotalShoeValue());	
		salesPredictedValueLabel.setText("Predicted Sale Value: ?" + caculatePredictedShoeValue());	
		salesPredictedProfitLabel.setText("Predicted Profit Value: ?" + caculatePredictedShoeProfit());
		
		investmentCurrentValueLabel.setText("Current Value: ?" + caculateTotalInvestmentValue());
		investmentPredictedValueLabel.setText("Predicted Sale Value: ?" + caculatePredictedInvestmentValue());
		investmentPredictedProfitLabel.setText("Predicted Profit Value: ?" + caculatePredictedInvestmentProfit());

		soldCurrentValueLabel = new JLabel("Total Bought Value: ?" + caculateTotalSoldValue());
		soldActualValueLabel = new JLabel("Total Sold Value: ?" + caculateActualSoldValue());
		soldActualProfitLabel = new JLabel("Total Profit Value: ?" + caculateActualSoldProfit());
		
		totalReturnLabel.setText("Total Returns Cost: ?" + caculateTotalReturnsValue());
		totalEquipmentLabel.setText("Total Equipment Cost: ?" + caculateTotalEquipmentValue());
		totalPostageLabel.setText("Total Postage Cost Value: ?" + caculateTotalPostageValue());
		totalBotLabel.setText("Total Bot Cost Value: ?" + caculateTotalBotValue());
		totalOtherLabel.setText("Total Other Cost Value: ?" + caculateTotalOtherValue());

	}
	
	private void revalidatePages() {
		
		//loginPage.revalidate();
		loginPage.repaint();
		
		//salesPage.revalidate();
		salesPage.repaint();
		
		//overviewPage.revalidate();
		overviewPage.repaint();
		
		//investmentsPage.revalidate();
		investmentsPage.repaint();
		
		//costsPage.revalidate();
		costsPage.repaint();
		
		//soldPage.revalidate();
		soldPage.repaint();
		
		//weeklyReviewPage.revalidate();
		weeklyReviewPage.repaint();
		
		//monthlyReviewPage.revalidate();
		monthlyReviewPage.repaint();
		
		//usersPage.revalidate();
		usersPage.repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == overviewItem) {
			System.out.println("Overview Test");
			cl.show(containerPanel,  "3");
			
		}
		
		if (e.getSource() == stockItem) {
			System.out.println("Stock Test");
			cl.show(containerPanel,  "2");
		}
		
		if (e.getSource() == investmentsItem) {
			System.out.println("Investments Test");
			cl.show(containerPanel,  "4");
		}
		
		if (e.getSource() == soldItem) {
			System.out.println("Sold Test");
			cl.show(containerPanel,  "6");
		}
		
		if (e.getSource() == costsItem) {
			System.out.println("Costs Test");
			cl.show(containerPanel,  "5");
		}
		
		if (e.getSource() == weeklyReviewItem) {
			System.out.println("Weekly Review Test");
			cl.show(containerPanel,  "7");
		}
		
		if (e.getSource() == monthlyReviewItem) {
			System.out.println("Monthly Review Test");
			cl.show(containerPanel,  "8");
		}
		
		if (e.getSource() == usersItem) {
			System.out.println("Users Test");
			cl.show(containerPanel,  "9");
		}
		
		if (e.getSource() == signOutItem) {
			System.out.println("Sign Out Test");
			navigationBar.setVisible(false);
			overviewItem.setVisible(true);
			soldItem.setVisible(true);
			monthlyReviewItem.setVisible(true);
			usersItem.setVisible(true);
			cl.show(containerPanel,  "1");
		}
		
		if (e.getSource() == deleteUser) {
			System.out.println("Delete User Test");
			String[][] usersTableData = API.getUsers();
			int rowID = usersTable.getSelectedRow();
			String deleteID = usersTableData[rowID][0];
			API.deleteUser(deleteID);
			createUserTable();
			usersPane.getViewport().remove(usersTable);
			usersPane.getViewport().add(usersTable);
			updateLabels();
			revalidatePages();
		
		}
		
		if (e.getSource() == addUser) {
			JPanel addUserPanel = new JPanel();
			JTextField username = new JTextField("Admin");
			JTextField password = new JTextField("Password");
			FlowLayout fl = new FlowLayout();
			addUserPanel.setLayout(fl);
			addUserPanel.add(username);
			addUserPanel.add(password);
	
			int result = JOptionPane.showConfirmDialog(mainWindow, addUserPanel, "Enter User Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String usernameValue = username.getText();
			    String passwordValue = password.getText();
			    API.addUser(usernameValue, passwordValue);
			    createUserTable();
				usersPane.getViewport().remove(usersTable);
				usersPane.getViewport().add(usersTable);
				updateLabels();
				revalidatePages();
			}
			
			
		}
		
		if (e.getSource() == deleteCost) {
			System.out.println("Delete Cost Test");
			String[][] costsTableData = API.getCosts();
			int rowID = costsTable.getSelectedRow();
			String deleteID = costsTableData[rowID][0];
			API.deleteCost(deleteID);
			createCostTable();
			costsPane.getViewport().remove(costsTable);
			costsPane.getViewport().remove(costFilteredTable);
			costsPane.getViewport().add(costsTable);
			updateLabels();
			revalidatePages();
		
		}
		
		if (e.getSource() == addCost) {			
			JPanel addCostPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JComboBox<String> category = new JComboBox<String>(costCategories);
			JTextField price = new JTextField("Price");
			FlowLayout fl = new FlowLayout();
			addCostPanel.setLayout(fl);
			addCostPanel.add(name);
			addCostPanel.add(category);
			addCostPanel.add(price);

			int result = JOptionPane.showConfirmDialog(mainWindow, addCostPanel, "Enter Cost Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{

			    String nameValue = name.getText();
			    String categoryValue = (String) category.getSelectedItem();
			    String priceValue = price.getText();
			    String dateValue = getDate();
			    
			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);
			    
			    	API.addCost(nameValue, categoryValue, priceValue, dateValue);
				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    createCostTable();
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().remove(costFilteredTable);
				costsPane.getViewport().add(costsTable);
				updateLabels();
				revalidatePages();
			    
			}
			
			
		}
		
		if (e.getSource() == editCost) {
			String[][] costTableData = API.getCosts();
			int rowID = costsTable.getSelectedRow();
			String editID = costTableData[rowID][0];
			String editName = costTableData[rowID][1];
			String editPrice = costTableData[rowID][3];
			String editDate = costTableData[rowID][4];

			
			JPanel editCostPanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JComboBox<String> ediCategory = new JComboBox<String>(stockCategories);
			JTextField ediPrice = new JTextField(editPrice);

			FlowLayout fl = new FlowLayout();
			editCostPanel.setLayout(fl);
			editCostPanel.add(ediName);
			editCostPanel.add(ediCategory);
			editCostPanel.add(ediPrice);

			
			int result = JOptionPane.showConfirmDialog(mainWindow, editCostPanel, "Enter Cost Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				String nameValue = ediName.getText();
			    String categoryValue = (String) ediCategory.getSelectedItem();
			    String priceValue = ediPrice.getText();
			    String dateValue = editDate;

			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);

			    	API.updateCost(editID, nameValue, categoryValue, priceValue, dateValue);

					
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    createCostTable();
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().remove(costFilteredTable);
				costsPane.getViewport().add(costsTable);
				updateLabels();
				revalidatePages();

			}
			
		}
		
		if (e.getSource() == deleteSold) {
			System.out.println("Delete Sold Test");
			String[][] soldTableData = API.getSold();
			int rowID = soldTable.getSelectedRow();
			String deleteID = soldTableData[rowID][0];
			API.deleteSold(deleteID);
			createSoldTable();
			soldPane.getViewport().remove(soldTable);
			soldPane.getViewport().add(soldTable);
			updateLabels();
			revalidatePages();
		
		}
		
		if (e.getSource() == editSold) {
			String[][] soldTableData = API.getSold();
			int rowID = soldTable.getSelectedRow();
			String editID = soldTableData[rowID][0];
			String editName = soldTableData[rowID][1];
			//String editBrand = soldTableData[rowID][2];
			//String editSize = soldTableData[rowID][3];
			//String editColour = soldTableData[rowID][4];
			String editPrice = soldTableData[rowID][5];
			String editSale = soldTableData[rowID][6];
			String editSold = soldTableData[rowID][7];
			//String editCondition = soldTableData[rowID][8];
			String editDateBought = soldTableData[rowID][9];
			String editDateSell = soldTableData[rowID][10];
			
			JPanel editSoldPanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JComboBox<String> ediBrand = new JComboBox<String>(brandCategories);
			JComboBox<String> ediSize = new JComboBox<String>(sizeCategories);
			JComboBox<String> ediColour = new JComboBox<String>(colourCategories);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JTextField ediSold = new JTextField(editSold);
			JComboBox<String> ediCondition = new JComboBox<String>(conditionCategories);

			FlowLayout fl = new FlowLayout();
			editSoldPanel.setLayout(fl);
			editSoldPanel.add(ediName);
			editSoldPanel.add(ediBrand);
			editSoldPanel.add(ediSize);
			editSoldPanel.add(ediColour);
			editSoldPanel.add(ediPrice);
			editSoldPanel.add(ediSale);
			editSoldPanel.add(ediSold);
			editSoldPanel.add(ediCondition);

			
			int result = JOptionPane.showConfirmDialog(mainWindow, editSoldPanel, "Enter Sold Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = (String) ediBrand.getSelectedItem();
			    String sizeValue = (String) ediSize.getSelectedItem();
			    String colourValue = (String) ediColour.getSelectedItem();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String soldValue = ediSold.getText();
			    String conditionValue = (String) ediCondition.getSelectedItem();
			    String dateBoughtValue = editDateBought;
			    String dateSellValue = editDateSell;
			    
			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);
			    	Double checkSale = Double.valueOf(saleValue);
			    	Double checkSold = Double.valueOf(soldValue);

				    API.updateSold(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, soldValue, conditionValue, dateBoughtValue, dateSellValue);
				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				updateLabels();
				revalidatePages();
			}
			
		}
		
		if (e.getSource() == deleteInvestment) {
			System.out.println("Delete Investment Test");
			String[][] investmentTableData = API.getInvestment();
			int rowID = investmentTable.getSelectedRow();
			String deleteID = investmentTableData[rowID][0];
			API.deleteInvestment(deleteID);
			createInvestmentTable();
			investmentPane.getViewport().remove(investmentTable);
			investmentPane.getViewport().add(investmentTable);
			updateLabels();
			revalidatePages();
		
		}
		
		if (e.getSource() == addInvestment) {			
			JPanel addInvestPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JComboBox<String> brand = new JComboBox<String>(brandCategories);
			JComboBox<String> size = new JComboBox<String>(sizeCategories);
			JComboBox<String> colour = new JComboBox<String>(colourCategories);
			JTextField price = new JTextField("Price");
			JTextField sale = new JTextField("Sale");
			JComboBox<String> condition = new JComboBox<String>(conditionCategories);
			JTextField dateSell = new JTextField("Date to Sell");
			
			FlowLayout fl = new FlowLayout();
			addInvestPanel.setLayout(fl);
			addInvestPanel.add(name);
			addInvestPanel.add(brand);
			addInvestPanel.add(size);
			addInvestPanel.add(colour);
			addInvestPanel.add(price);
			addInvestPanel.add(sale);
			addInvestPanel.add(condition);
			addInvestPanel.add(dateSell);

			int result = JOptionPane.showConfirmDialog(mainWindow, addInvestPanel, "Enter Investment Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = (String) brand.getSelectedItem();
			    String sizeValue = (String) size.getSelectedItem();
			    String colourValue = (String) colour.getSelectedItem();
			    String priceValue = price.getText();
			    String saleValue = sale.getText();
			    String conditionValue = (String) condition.getSelectedItem();
			    String dateBoughtValue = getDate();
			    String dateSellValue = dateSell.getText();
			    
			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);
			    	Double checkSale = Double.valueOf(saleValue);
			    	Double checkDateSell = Double.valueOf(dateSellValue);
				    
				    API.addInvestment(nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue, dateSellValue);

				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);
				updateLabels();
				revalidatePages();

			}
			
			
		}
		
		if (e.getSource() == editInvestment) {
			String[][] investmentTableData = API.getInvestment();
			int rowID = investmentTable.getSelectedRow();
			String editID = investmentTableData[rowID][0];
			String editName = investmentTableData[rowID][1];
			String editBrand = investmentTableData[rowID][2];
			String editSize = investmentTableData[rowID][3];
			String editColour = investmentTableData[rowID][4];
			String editPrice = investmentTableData[rowID][5];
			String editSale = investmentTableData[rowID][6];
			String editCondition = investmentTableData[rowID][7];
			String editDateBought = investmentTableData[rowID][8];
			String editDateSell = investmentTableData[rowID][9];
			
			JPanel editInvestmentPanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JComboBox<String> ediBrand = new JComboBox<String>(brandCategories);
			JComboBox<String> ediSize = new JComboBox<String>(sizeCategories);
			JComboBox<String> ediColour = new JComboBox<String>(colourCategories);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JComboBox<String> ediCondition = new JComboBox<String>(conditionCategories);
			JTextField ediDateSell = new JTextField(editDateSell);
			FlowLayout fl = new FlowLayout();
			editInvestmentPanel.setLayout(fl);
			editInvestmentPanel.add(ediName);
			editInvestmentPanel.add(ediBrand);
			editInvestmentPanel.add(ediSize);
			editInvestmentPanel.add(ediColour);
			editInvestmentPanel.add(ediPrice);
			editInvestmentPanel.add(ediSale);
			editInvestmentPanel.add(ediCondition);
			editInvestmentPanel.add(ediDateSell);
			
			int result = JOptionPane.showConfirmDialog(mainWindow, editInvestmentPanel, "Enter Investment Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = (String) ediBrand.getSelectedItem();
			    String sizeValue = (String) ediSize.getSelectedItem();
			    String colourValue = (String) ediColour.getSelectedItem();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String conditionValue = (String) ediCondition.getSelectedItem();
			    String dateBoughtValue = editDateBought;
			    String dateSellValue = ediDateSell.getText();
			    
			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);
			    	Double checkSale = Double.valueOf(saleValue);
			    	Double checkDateSell = Double.valueOf(dateSellValue);
				    
				    API.updateInvestment(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue, dateSellValue);

				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);
				updateLabels();
				revalidatePages();

			}
			
		}
		if (e.getSource() == addStock || e.getSource() == addStock2) {
			JPanel addStockPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JComboBox<String> brand = new JComboBox<String>(brandCategories);
			FlowLayout fl = new FlowLayout();
			addStockPanel.setLayout(fl);
			addStockPanel.add(name);
			addStockPanel.add(brand);

			int result = JOptionPane.showConfirmDialog(mainWindow, addStockPanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = (String) brand.getSelectedItem();
			    API.addStock(nameValue, brandValue);

			}
		}
		
		if (e.getSource() == addShoe) {			
			JPanel addShoePanel = new JPanel();
			JTextField name = new JTextField("Name");
			JComboBox<String> brand = new JComboBox<String>(brandCategories);
			JComboBox<String> size = new JComboBox<String>(sizeCategories);
			JComboBox<String> colour = new JComboBox<String>(colourCategories);
			JTextField price = new JTextField("Price");
			JTextField sale = new JTextField("Sale");
			JComboBox<String> condition = new JComboBox<String>(conditionCategories);

			FlowLayout fl = new FlowLayout();
			
			addShoePanel.setLayout(fl);
			addShoePanel.add(name);
			addShoePanel.add(brand);
			addShoePanel.add(size);
			addShoePanel.add(colour);
			addShoePanel.add(price);
			addShoePanel.add(sale);
			addShoePanel.add(condition);


			int result = JOptionPane.showConfirmDialog(mainWindow, addShoePanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = (String) brand.getSelectedItem();
			    String sizeValue = (String) size.getSelectedItem();
			    String colourValue = (String) colour.getSelectedItem();
			    String priceValue = price.getText();
			    String saleValue = sale.getText();
			    String conditionValue = (String) condition.getSelectedItem();
			    String dateBoughtValue = getDate();
			    
			    try  {
			    	Double checkAddShoePrice = Double.valueOf(priceValue);
			    	Double checkAddShoeSale = Double.valueOf(saleValue);
			    	
			    
			    
			    	API.addShoe(nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue);

				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel addShoeErrorPanel = new JPanel();
					JLabel addShoeError = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					addShoeErrorPanel.add(addShoeError);
					JOptionPane.showMessageDialog(mainWindow, addShoeErrorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
				   
			    createShoeTable();
			    shoePane.getViewport().remove(shoeTable);
			    shoePane.getViewport().add(shoeTable);
				updateLabels();
				revalidatePages();
			}
			
			
		}
		
		if (e.getSource() == editShoe) {
			String[][] shoeTableData = API.getShoe();
			int rowID = shoeTable.getSelectedRow();
			String editID = shoeTableData[rowID][0];
			String editName = shoeTableData[rowID][1];
			String editBrand = shoeTableData[rowID][2];
			String editSize = shoeTableData[rowID][3];
			String editColour = shoeTableData[rowID][4];
			String editPrice = shoeTableData[rowID][5];
			String editSale = shoeTableData[rowID][6];
			String editCondition = shoeTableData[rowID][7];
			String editDateBought = shoeTableData[rowID][8];
			
			JPanel editShoePanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JComboBox<String> ediBrand = new JComboBox<String>(brandCategories);
			JComboBox<String> ediSize = new JComboBox<String>(sizeCategories);
			JComboBox<String> ediColour = new JComboBox<String>(colourCategories);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JComboBox<String> ediCondition = new JComboBox<String>(conditionCategories);


			FlowLayout fl = new FlowLayout();
			
			editShoePanel.setLayout(fl);
			editShoePanel.add(ediName);
			editShoePanel.add(ediBrand);
			editShoePanel.add(ediSize);
			editShoePanel.add(ediColour);
			editShoePanel.add(ediPrice);
			editShoePanel.add(ediSale);
			editShoePanel.add(ediCondition);


			
			int result = JOptionPane.showConfirmDialog(mainWindow, editShoePanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = (String) ediBrand.getSelectedItem();
			    String sizeValue = (String) ediSize.getSelectedItem();
			    String colourValue = (String) ediColour.getSelectedItem();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String conditionValue = (String) ediCondition.getSelectedItem();
			    String dateBoughtValue = editDateBought;
			    
			    try  {
			    	Double checkPrice = Double.valueOf(priceValue);
			    	Double checkSale = Double.valueOf(saleValue);
				       
				    API.updateShoe(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue);

				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
		    	
			    createShoeTable();
				shoePane.getViewport().remove(shoeTable);
				shoePane.getViewport().add(shoeTable);
				
				updateLabels();
				revalidatePages();

			   
			}
			
		}
		
		if (e.getSource() == deleteShoe) {
			System.out.println("Delete Shoe Test");
			String[][] shoeTableData = API.getShoe();
			int rowID = shoeTable.getSelectedRow();
			String deleteID = shoeTableData[rowID][0];
			API.deleteShoe(deleteID);
			
			createShoeTable();
			shoePane.getViewport().remove(shoeTable);
			shoePane.getViewport().add(shoeTable);
			updateLabels();
			revalidatePages();
		
		}

		if (e.getSource() == moveShoe) {
			System.out.println("Move Shoe To Sold Test");
			String[][] shoeTableData = API.getShoe();
			int rowID = shoeTable.getSelectedRow();
			String soldName = shoeTableData[rowID][1];
			String soldBrand = shoeTableData[rowID][2];
			String soldSize = shoeTableData[rowID][3];
			String soldColour = shoeTableData[rowID][4];
			String soldPrice = shoeTableData[rowID][5];
			String soldSale = shoeTableData[rowID][6];
			String soldCondition = shoeTableData[rowID][7];
			String soldDateBought = shoeTableData[rowID][8];
			String soldDateSell = getDate();
			
			JPanel moveShoePanel = new JPanel();
			JTextField getAmount = new JTextField("Sold Amount");
			FlowLayout fl = new FlowLayout();
			moveShoePanel.setLayout(fl);
			moveShoePanel.add(getAmount);
			
			int result = JOptionPane.showConfirmDialog(mainWindow, moveShoePanel, "Enter Sold Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String soldAmount = getAmount.getText();
			    
			    try  {
			    	Double checkSold = Double.valueOf(soldAmount);
				       
				    API.addSold(soldName, soldBrand, soldSize, soldColour, soldPrice, soldSale, soldAmount, soldCondition, soldDateBought, soldDateSell);


				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
				
			    System.out.println("Delete Shoe Test");
				String deleteID = shoeTableData[rowID][0];
				API.deleteShoe(deleteID);
				
				createShoeTable();
				shoePane.getViewport().remove(shoeTable);
				shoePane.getViewport().add(shoeTable);

			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				
				updateLabels();
				revalidatePages();
				
			}
		}
		
		if (e.getSource() == moveInvestment) {
			System.out.println("Move Investment To Sold Test");
			String[][] investmentTableData = API.getInvestment();
			int rowID = investmentTable.getSelectedRow();
			String soldName = investmentTableData[rowID][1];
			String soldBrand = investmentTableData[rowID][2];
			String soldSize = investmentTableData[rowID][3];
			String soldColour = investmentTableData[rowID][4];
			String soldPrice = investmentTableData[rowID][5];
			String soldSale = investmentTableData[rowID][6];
			String soldCondition = investmentTableData[rowID][7];
			String soldDateBought = investmentTableData[rowID][8];
			String soldDateSell = getDate();
			
			JPanel moveInvestmentPanel = new JPanel();
			JTextField getAmount = new JTextField("Sold Amount");
			FlowLayout fl = new FlowLayout();
			moveInvestmentPanel.setLayout(fl);
			moveInvestmentPanel.add(getAmount);
			
			int result = JOptionPane.showConfirmDialog(mainWindow, moveInvestmentPanel, "Enter Sold Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String soldAmount = getAmount.getText();

			    try  {
			    	Double checkSold = Double.valueOf(soldAmount);
				       
				    API.addSold(soldName, soldBrand, soldSize, soldColour, soldPrice, soldSale, soldAmount, soldCondition, soldDateBought, soldDateSell);


				
			    } catch (java.lang.NumberFormatException e1) {
			    	
			    	JPanel errorPanel = new JPanel();
					JLabel errorCheck = new JLabel("Incorrect data formats have been entered. Please check your data and try again.");
					errorPanel.add(errorCheck);
					JOptionPane.showMessageDialog(mainWindow, errorPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			    	
			    }
			    
			    System.out.println("Delete Investment Test");
				String deleteID = investmentTableData[rowID][0];
				API.deleteInvestment(deleteID);
				
				createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);

			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				
				updateLabels();
				revalidatePages();

			}
		}
		
		if (e.getSource() == loginButton) {

			String userField = usernameText.getText();
			String passwordField = passwordText.getText();
			adminCheck = 0;
			userCheck = 0;
			
			String[][] userTableData = API.getUsers();
			String[] userTableDataSelect;
			
			for (int i = 0; i < userTableData.length; i++) {
				String userData = userTableData[i][1];
				String passwordData = userTableData[i][2];
				
				System.out.println("adminCheck = " + adminCheck);
				System.out.println("userCheck = " + adminCheck);
				System.out.println("userField = " + userField);
				System.out.println("passwordField = " + passwordField);
				System.out.println("userData = " + userData);
				System.out.println("passwordData = " + passwordData);
				
				if (userField.equals("Admin") & passwordField.equals("Password")) {
					adminCheck = adminCheck + 1;
				} else if (userField.equals(userData) & passwordField.equals(passwordData)) {
					userCheck = userCheck + 1;
				}
			}
			
			/*if (userCheck.equals("Admin") && passwordCheck.equals("Password")) {*/
			if (adminCheck >= 1) {
				cl.show(containerPanel,  "3");
				navigationBar.setVisible(true);
				usernameText.setText("Username");
				passwordText.setText("Password");
				loginPage.revalidate();
				loginPage.repaint();
			} else if (userCheck >= 1) {
				cl.show(containerPanel,  "2");
				overviewItem.setVisible(false);
				soldItem.setVisible(false);
				monthlyReviewItem.setVisible(false);
				usersItem.setVisible(false);
				navigationBar.setVisible(true);
				usernameText.setText("Username");
				passwordText.setText("Password");
				loginPage.revalidate();
				loginPage.repaint();
			} else {

				JPanel loginPanel = new JPanel();
				JLabel loginError = new JLabel("Incorrect details have been entered. Check your details and try again.");
				loginPanel.add(loginError);
				JOptionPane.showMessageDialog(mainWindow, loginPanel, "Incorrect Information", JOptionPane.OK_OPTION);
			}
			
		}
		
		if (e.getSource() == sortCostButton) {
			
			String filterBy = (String) sortCostList.getSelectedItem();
			String[][] costsTableData = API.getCosts();
			String[] costsTableColumns = {"ID", "Name", "Category", "Price", "Date"};
			costFilteredTable = new JTable(costsTableData, costsTableColumns);
			costFilteredTable.setFont (costFilteredTable.getFont ().deriveFont (12.0f));
			costFilteredTable.setBorder(new LineBorder(mainWindowBackground));
			costFilteredTable.setForeground(foregroundColour);
			
			JTableHeader header = costFilteredTable.getTableHeader();
			header.setBackground(backgroundColour);
			header.setForeground(foregroundColour);
			
			if (filterBy.equals("All")) {
				
				createCostTable();
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().remove(costFilteredTable);
				costsPane.getViewport().add(costsTable);
				revalidatePages();
				
			} else {
							
				String[][] costFilteredTableData = new String[costsTableData.length][5];
				
				costFilterRowID = 0;
				
				for (int i = 0; i < costsTableData.length; i++) {
					String filteredDataID = costsTableData[i][0];
					String filteredDataName = costsTableData[i][1];
					String filteredDataCategory = costsTableData[i][2];
					String filteredDataPrice = costsTableData[i][3];
					String filteredDataData = costsTableData[i][4];
					
					if (filteredDataCategory.equals(filterBy)) {
						costFilteredTableData[costFilterRowID][0] = filteredDataID;
						costFilteredTableData[costFilterRowID][1] = filteredDataName;
						costFilteredTableData[costFilterRowID][2] = filteredDataCategory;
						costFilteredTableData[costFilterRowID][3] = filteredDataPrice;
						costFilteredTableData[costFilterRowID][4] = filteredDataData;
						
						costFilterRowID = costFilterRowID + 1;
					}
				}
											
				costFilteredTable = new JTable(costFilteredTableData, costsTableColumns) {
				
					public boolean isCellEditable(int data, int columns) {
						
						return false;
						
					}
					
				};
				
				costFilteredTable.setPreferredScrollableViewportSize(new Dimension(600,300));
				costFilteredTable.setFillsViewportHeight(true);
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().remove(costFilteredTable);
				costsPane.getViewport().add(costFilteredTable);
				
				revalidatePages();
			}
			
		}
		
		if (e.getSource() == salesSelectCategory) {
			String filterBy = (String) salesSelectCategory.getSelectedItem();
			
			if (filterBy.equals("Brand")) {
				DefaultComboBoxModel<String> brandModel = new DefaultComboBoxModel<>(filterBrandCategories);
				salesCategoryList.setModel(brandModel);
				revalidatePages();
			} else if (filterBy.equals("Condition")){
				DefaultComboBoxModel<String> conditionModel = new DefaultComboBoxModel<>(filterConditionCategories);
				salesCategoryList.setModel(conditionModel);
				revalidatePages();
			}else if (filterBy.equals("Size")){
				DefaultComboBoxModel<String> sizeModel = new DefaultComboBoxModel<>(filterSizeCategories);
				salesCategoryList.setModel(sizeModel);
				revalidatePages();
			}else if (filterBy.equals("Colour")){
				DefaultComboBoxModel<String> colourModel = new DefaultComboBoxModel<>(filterColourCategories);
				salesCategoryList.setModel(colourModel);
				revalidatePages();
			}
			
		}
		
			if (e.getSource() == filterSalesButton) {
			
				String filterBy = (String) salesCategoryList.getSelectedItem();
				String categoryBy = (String) salesCategoryList.getSelectedItem();
				
				String[][] shoeTableData = API.getShoe();
				String[] shoeTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Condition", "Date Bought"};
				salesFilterTable = new JTable(shoeTableData, shoeTableColumns);
				salesFilterTable.setFont (salesFilterTable.getFont ().deriveFont (12.0f));
				salesFilterTable.setBorder(new LineBorder(mainWindowBackground));
				salesFilterTable.setForeground(foregroundColour);
				
				
				if (filterBy.equals("All")) {
					
					createShoeTable();
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(shoeTable);
					revalidatePages();
					
				} else if (filterBy.equals("Adidas")) {
								
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					salesFilterTable.setPreferredScrollableViewportSize(new Dimension(600,300));
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if (filterBy.equals("Nike")) {
					
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					salesFilterTable.setPreferredScrollableViewportSize(new Dimension(600,300));
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if (filterBy.equals("Jordan")) {
					
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if (filterBy.equals("Yeezy")) {
					
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if (filterBy.equals("Other")) {
					
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if ((filterBy.equals("Other")) & (categoryBy.equals("Brand"))) {
					
					String[][] salesFilteredTableData = new String[shoeTableData.length][10];
					
					salesFilterRowID = 0;
					
					for (int i = 0; i < shoeTableData.length; i++) {
						String filteredDataID = shoeTableData[i][0];
						String filteredDataName = shoeTableData[i][1];
						String filteredDataBrand = shoeTableData[i][2];
						String filteredDataSize = shoeTableData[i][3];
						String filteredDataColour = shoeTableData[i][4];
						String filteredDataPrice = shoeTableData[i][5];
						String filteredDataSale = shoeTableData[i][6];
						String filteredDataCondition = shoeTableData[i][7];
						String filteredDataDateBought = shoeTableData[i][8];
						
						if (filteredDataBrand.equals(filterBy)) {
							salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
							salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
							salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
							salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
							salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
							salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
							salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
							salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
							salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
							
							salesFilterRowID = salesFilterRowID + 1;
						}
					}
												
					salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
					
						public boolean isCellEditable(int data, int columns) {
							
							return false;
							
						}
						
					};
					
					
					salesFilterTable.setFillsViewportHeight(true);
					shoePane.getViewport().remove(shoeTable);
					shoePane.getViewport().remove(salesFilterTable);
					shoePane.getViewport().add(salesFilterTable);
					
					revalidatePages();
				} else if (filterBy.equals("3")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("4")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("5")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("6")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("7")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("8")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("9")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("10")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("11")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("12")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("13")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("14")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataSize.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("White")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataColour.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					}  else if (filterBy.equals("Blue")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataColour.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					}  else if (filterBy.equals("Purple")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataColour.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("Black")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataColour.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("Other") & categoryBy.equals("Colour")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataColour.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("Dead Stock")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataCondition.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("Used")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataCondition.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					} else if (filterBy.equals("Other") & categoryBy.equals("Condition")) {
						
						String[][] salesFilteredTableData = new String[shoeTableData.length][10];
						
						salesFilterRowID = 0;
						
						for (int i = 0; i < shoeTableData.length; i++) {
							String filteredDataID = shoeTableData[i][0];
							String filteredDataName = shoeTableData[i][1];
							String filteredDataBrand = shoeTableData[i][2];
							String filteredDataSize = shoeTableData[i][3];
							String filteredDataColour = shoeTableData[i][4];
							String filteredDataPrice = shoeTableData[i][5];
							String filteredDataSale = shoeTableData[i][6];
							String filteredDataCondition = shoeTableData[i][7];
							String filteredDataDateBought = shoeTableData[i][8];
							
							if (filteredDataCondition.equals(filterBy)) {
								salesFilteredTableData[salesFilterRowID][0] = filteredDataID;
								salesFilteredTableData[salesFilterRowID][1] = filteredDataName;
								salesFilteredTableData[salesFilterRowID][2] = filteredDataBrand;
								salesFilteredTableData[salesFilterRowID][3] = filteredDataSize;
								salesFilteredTableData[salesFilterRowID][4] = filteredDataColour;
								salesFilteredTableData[salesFilterRowID][5] = filteredDataPrice;
								salesFilteredTableData[salesFilterRowID][6] = filteredDataSale;
								salesFilteredTableData[salesFilterRowID][7] = filteredDataCondition;
								salesFilteredTableData[salesFilterRowID][8] = filteredDataDateBought;
								
								salesFilterRowID = salesFilterRowID + 1;
							}
						}
													
						salesFilterTable = new JTable(salesFilteredTableData, shoeTableColumns) {
						
							public boolean isCellEditable(int data, int columns) {
								
								return false;
								
							}
							
						};
						
						
						salesFilterTable.setFillsViewportHeight(true);
						shoePane.getViewport().remove(shoeTable);
						shoePane.getViewport().remove(salesFilterTable);
						shoePane.getViewport().add(salesFilterTable);
						
						revalidatePages();
					}
			
		}
	}
}

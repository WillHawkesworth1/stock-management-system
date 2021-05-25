
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
import javax.swing.table.DefaultTableModel;

import com.william.stockApi.API;

public class Main implements ActionListener {
	
	private static JFrame mainWindow;
	private static JPanel loginPage, salesPage, containerPanel, overviewPage, investmentsPage, costsPage, soldPage, weeklyReviewPage, monthlyReviewPage, usersPage;
	private static JButton deleteUser, addUser, addCost, deleteCost, editCost, deleteSold, editSold, addInvestment, editInvestment, deleteInvestment, addStock, addStock2, addShoe, editShoe, deleteShoe, moveShoe, moveInvestment, loginButton;
	private static JTable usersTable, costsTable, soldTable, investmentTable, shoeTable, weeklySoldTable, weeklyCostTable, weeklyShoeTable, weeklyInvestmentTable, monthlySoldTable, monthlyCostTable, monthlyShoeTable, monthlyInvestmentTable;
	private static JMenuBar navigationBar;
	private static JMenu navigationMenu, loginMenu;
	private static JMenuItem overviewItem, stockItem, investmentsItem, costsItem, soldItem, weeklyReviewItem, monthlyReviewItem, usersItem, signOutItem;
	private static JTextField usernameText, passwordText;
	private static JScrollPane usersPane, costsPane, soldPane, investmentPane, shoePane, weeklySoldPane, weeklyCostPane, weeklyShoePane, weeklyInvestmentPane, monthlySoldPane, monthlyCostPane, monthlyShoePane, monthlyInvestmentPane;
	private static JLabel usernameLabel, passwordLabel;
	private static CardLayout cl;
	
	private static String[] stockCategories = {"Category 1", "Category 2", "Category 3" };

	
	

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
		loginPage = new JPanel();
		salesPage = new JPanel();
		overviewPage = new JPanel();
		investmentsPage = new JPanel();
		costsPage = new JPanel();
		soldPage = new JPanel();
		weeklyReviewPage = new JPanel();
		monthlyReviewPage = new JPanel();
		usersPage = new JPanel();
		
		
		
		//Creates the window, setting the size and to close on exit.
		
		mainWindow = new JFrame("Gwent Grails Stock Mananagement System");
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
		loginPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Login Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		loginPage.add(titleLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont (usernameLabel.getFont ().deriveFont (30.0f));
		loginPage.add(usernameLabel);
		
		usernameText = new JTextField("Username");
		loginPage.add(usernameText);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont (passwordLabel.getFont ().deriveFont (30.0f));
		loginPage.add(passwordLabel);
		
		passwordText = new JTextField("Password");
		loginPage.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginPage.add(loginButton);
	}
	
	private void createSalesPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		salesPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Current Stock Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		salesPage.add(titleLabel);
		
		JLabel currentValueLabel = new JLabel("Current Value: £" + caculateTotalShoeValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(currentValueLabel);
		
		JLabel predictedValueLabel = new JLabel("Predicted Sale Value: £" + caculatePredictedShoeValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(predictedValueLabel);
		
		JLabel predictedProfitLabel = new JLabel("Predicted Profit Value: £" + caculatePredictedShoeProfit());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(predictedProfitLabel);
		
		addShoe = new JButton("Add Stock");
		addShoe.addActionListener(this);
		salesPage.add(addShoe);
		
		addStock2 = new JButton("New Stock Type");
		addStock2.addActionListener(this);
		salesPage.add(addStock2);
		
		editShoe = new JButton("Edit Stock");
		editShoe.addActionListener(this);
		salesPage.add(editShoe);
		
		deleteShoe = new JButton("Delete Stock");
		deleteShoe.addActionListener(this);
		salesPage.add(deleteShoe);
		
		moveShoe = new JButton("Mark as Sold");
		moveShoe.addActionListener(this);
		salesPage.add(moveShoe);
		
		JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
		salesPage.add(sortStockList);
		
		JButton sortStockButton = new JButton("Sort Stock");
		salesPage.add(sortStockButton);
		
		shoePane = new JScrollPane();
		createShoeTable();
		shoePane.getViewport().add(shoeTable);
		salesPage.add(shoePane);
		
	}
		
	private void createOverviewPage() {
			
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		overviewPage.add(gwentGrailsLogo);	
		
		JLabel titleLabel = new JLabel("Overview Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		overviewPage.add(titleLabel);
		
		JLabel currentShoeValueLabel = new JLabel("Current Stock Value: £" + caculateTotalShoeValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(currentShoeValueLabel);
		
		JLabel predictedShoeValueLabel = new JLabel("Predicted Stock Value: £" + caculatePredictedShoeValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(predictedShoeValueLabel);
		
		JLabel predictedShoeProfitLabel = new JLabel("Predicted Profit Value: £" + caculatePredictedShoeProfit());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(predictedShoeProfitLabel);
			
		JLabel currentInvestmentValueLabel = new JLabel("Current Investment Value: £" + caculateTotalInvestmentValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(currentInvestmentValueLabel);
		
		JLabel predictedInvestmentValueLabel = new JLabel("Predicted Investment Value: £" + caculatePredictedInvestmentValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(predictedInvestmentValueLabel);
		
		JLabel predictedInvestmentProfitLabel = new JLabel("Predicted Investment Profit: £" + caculatePredictedInvestmentProfit());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(predictedInvestmentProfitLabel);
		
		JLabel currentSoldValueLabel = new JLabel("Total Shoe's Bought Value: £" + caculateTotalSoldValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(currentSoldValueLabel);
		
		JLabel actualSoldValueLabel = new JLabel("Total Shoe's Sold Value: £" + caculateActualSoldValue());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(actualSoldValueLabel);
		
		JLabel actualSoldProfitLabel = new JLabel("Total Profit Value: £" + caculateActualSoldProfit());
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		overviewPage.add(actualSoldProfitLabel);
		
		
	}

	private void createInvestmentsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				investmentsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Investments Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				investmentsPage.add(titleLabel);
				
				JLabel currentValueLabel = new JLabel("Current Value: £" + caculateTotalInvestmentValue());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(currentValueLabel);
				
				JLabel predictedValueLabel = new JLabel("Predicted Sale Value: £" + caculatePredictedInvestmentValue());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(predictedValueLabel);
				
				JLabel predictedProfitLabel = new JLabel("Predicted Profit Value: £" + caculatePredictedInvestmentProfit());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(predictedProfitLabel);
				
				addInvestment = new JButton("Add Investment");
				addInvestment.addActionListener(this);
				investmentsPage.add(addInvestment);
				
				addStock = new JButton("New Stock Type");
				addStock.addActionListener(this);
				investmentsPage.add(addStock);
				
				editInvestment = new JButton("Edit Investment");
				editInvestment.addActionListener(this);
				investmentsPage.add(editInvestment);
				
				deleteInvestment = new JButton("Delete Investment");
				deleteInvestment.addActionListener(this);
				investmentsPage.add(deleteInvestment);
				
				moveInvestment = new JButton("Mark as Sold");
				moveInvestment.addActionListener(this);
				investmentsPage.add(moveInvestment);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				investmentsPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Investments");
				investmentsPage.add(sortStockButton);
				
				investmentPane = new JScrollPane();
				createInvestmentTable();
				investmentPane.getViewport().add(investmentTable);
				investmentsPage.add(investmentPane);
		
	}
	
	private void createSoldPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				soldPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Sold Stock Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				soldPage.add(titleLabel);
				
				JLabel currentValueLabel = new JLabel("Total Bought Value: £" + caculateTotalSoldValue());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(currentValueLabel);
				
				JLabel predictedValueLabel = new JLabel("Total Sold Value: £" + caculateActualSoldValue());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(predictedValueLabel);
				
				JLabel predictedProfitLabel = new JLabel("Total Profit Value: £" + caculateActualSoldProfit());
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(predictedProfitLabel);
			
				deleteSold = new JButton("Delete Stock");
				deleteSold.addActionListener(this);
				soldPage.add(deleteSold);
				
				editSold = new JButton("Edit Stock");
				editSold.addActionListener(this);
				soldPage.add(editSold);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				soldPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Stock");
				soldPage.add(sortStockButton);
				
				soldPane = new JScrollPane();
				createSoldTable();
				soldPane.getViewport().add(soldTable);
				soldPage.add(soldPane);
		
	}
	
	private void createCostsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				costsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Company Costs Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (27.0f));
				costsPage.add(titleLabel);
				
				JLabel totalReturnLabel = new JLabel("Total Returns Cost: £" + caculateTotalReturnsValue());
				totalReturnLabel.setFont (totalReturnLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalReturnLabel);
				
				JLabel totalEquipmentLabel = new JLabel("Total Equipment Cost: £" + caculateTotalEquipmentValue());
				totalEquipmentLabel.setFont (totalEquipmentLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalEquipmentLabel);
				
				JLabel totalPostageLabel = new JLabel("Total Postage Cost Value: £" + caculateTotalPostageValue());
				totalPostageLabel.setFont (totalPostageLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalPostageLabel);
				
				JLabel totalBotLabel = new JLabel("Total Bot Cost Value: £" + caculateTotalBotValue());
				totalBotLabel.setFont (totalBotLabel.getFont ().deriveFont (17.0f));
				costsPage.add(totalBotLabel);
				
				JLabel totalOtherLabel = new JLabel("Total Other Cost Value: £" + caculateTotalOtherValue());
				totalOtherLabel.setFont (totalOtherLabel.getFont ().deriveFont (17.0f));
				costsPage.add(totalOtherLabel);
				
				addCost = new JButton("Add Cost");
				addCost.addActionListener(this);
				costsPage.add(addCost);
				
				editCost = new JButton("Edit Cost");
				editCost.addActionListener(this);
				costsPage.add(editCost);
				
				deleteCost = new JButton("Delete Cost");
				deleteCost.addActionListener(this);
				costsPage.add(deleteCost);
				
				JComboBox<String> sortCostList = new JComboBox<String>(stockCategories);
				costsPage.add(sortCostList);
				
				JButton sortCostButton = new JButton("Sort Cost");
				costsPage.add(sortCostButton);
				
				
				costsPane = new JScrollPane();
				createCostTable();
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
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		usersPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("User Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		usersPage.add(titleLabel);
		
		addUser = new JButton("Add User");
		addUser.addActionListener(this);
		usersPage.add(addUser);
		
		deleteUser = new JButton("Delete User");
		deleteUser.addActionListener(this);
		usersPage.add(deleteUser);
		
		usersPane = new JScrollPane();
		createUserTable();
		//usersTable.addActionListener(this);
		usersPane.getViewport().add(usersTable);
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
		usersTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		usersTable.setFillsViewportHeight(true);
	}
	
	private void createCostTable() {
		String[][] costsTableData = API.getCosts();
		String[] costsTableColumns = {"ID", "Category", "Name", "Price", "Date"};

									
		costsTable = new JTable(costsTableData, costsTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		costsTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		costsTable.setFillsViewportHeight(true);
	}
	
	private void createSoldTable() {
		String[] soldTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Sold", "Condition", "Date Bought", "Date Sold"};
		String[][] soldTableData = API.getSold();
									
		soldTable = new JTable(soldTableData, soldTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		soldTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		soldTable.setFillsViewportHeight(true);
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
		
		investmentTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		investmentTable.setFillsViewportHeight(true);
		
	}
	
	private void createShoeTable() {
		String[] shoeTableColumns = {"ID", "Name", "Brand", "Size", "Colour", "Price", "Sale", "Condition", "Date Bought"};
		String[][] shoeTableData = API.getShoe();
		shoeTable = new JTable(shoeTableData, shoeTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		shoeTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		shoeTable.setFillsViewportHeight(true);
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
		double totalCost = Double.parseDouble(caculateTotalInvestmentValue());
		double totalSale = Double.parseDouble(caculatePredictedInvestmentValue());
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
			usersPage.revalidate();
			usersPage.repaint();
		
		}
		
		if (e.getSource() == addUser) {
			JPanel addUserPanel = new JPanel();
			JTextField username = new JTextField("Admin");
			JTextField password = new JTextField("Password");
			FlowLayout fl = new FlowLayout();
			addUserPanel.setLayout(fl);
			addUserPanel.add(username);
			addUserPanel.add(password);
			Object[] userInfo = {
					"Username:", username,
					"Password:", password
			};
			int result = JOptionPane.showConfirmDialog(mainWindow, addUserPanel, "Enter User Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String usernameValue = username.getText();
			    String passwordValue = password.getText();
			    API.addUser(usernameValue, passwordValue);
			    createUserTable();
				usersPane.getViewport().remove(usersTable);
				usersPane.getViewport().add(usersTable);
				usersPage.revalidate();
				usersPage.repaint();
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
			costsPane.getViewport().add(costsTable);
			costsPage.revalidate();
			costsPage.repaint();
		
		}
		
		if (e.getSource() == addCost) {			
			JPanel addCostPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JTextField category = new JTextField("Category");
			JTextField price = new JTextField("Price");
			JTextField date = new JTextField("Date");
			FlowLayout fl = new FlowLayout();
			addCostPanel.setLayout(fl);
			addCostPanel.add(name);
			addCostPanel.add(category);
			addCostPanel.add(price);
			addCostPanel.add(date);
			Object[] costInfo = {
					"Name:", name,
					"Password:", category,
					"Price:", price,
					"Date", date
			};
			int result = JOptionPane.showConfirmDialog(mainWindow, addCostPanel, "Enter Cost Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String categoryValue = category.getText();
			    String priceValue = price.getText();
			    String dateValue = date.getText();
			    API.addCost(nameValue, categoryValue, priceValue, dateValue);
			    createCostTable();
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().add(costsTable);
				costsPage.revalidate();
				costsPage.repaint();
			}
			
			
		}
		
		if (e.getSource() == editCost) {
			String[][] costTableData = API.getCosts();
			int rowID = costsTable.getSelectedRow();
			String editID = costTableData[rowID][0];
			String editName = costTableData[rowID][1];
			String editCategory = costTableData[rowID][2];
			String editPrice = costTableData[rowID][3];
			String editDate = costTableData[rowID][4];

			
			JPanel editCostPanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JTextField ediCategory = new JTextField(editCategory);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediDate = new JTextField(editDate);

			FlowLayout fl = new FlowLayout();
			editCostPanel.setLayout(fl);
			editCostPanel.add(ediName);
			editCostPanel.add(ediCategory);
			editCostPanel.add(ediPrice);
			editCostPanel.add(ediDate);

			
			int result = JOptionPane.showConfirmDialog(mainWindow, editCostPanel, "Enter Cost Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String categoryValue = ediCategory.getText();
			    String priceValue = ediPrice.getText();
			    String dateValue = ediDate.getText();

			    API.updateCost(editID, nameValue, categoryValue, priceValue, dateValue);
			    createCostTable();
				costsPane.getViewport().remove(costsTable);
				costsPane.getViewport().add(costsTable);
				costsPage.revalidate();
				costsPage.repaint();
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
			soldPage.revalidate();
			soldPage.repaint();
		
		}
		
		if (e.getSource() == editSold) {
			String[][] soldTableData = API.getSold();
			int rowID = soldTable.getSelectedRow();
			String editID = soldTableData[rowID][0];
			String editName = soldTableData[rowID][1];
			String editBrand = soldTableData[rowID][2];
			String editSize = soldTableData[rowID][3];
			String editColour = soldTableData[rowID][4];
			String editPrice = soldTableData[rowID][5];
			String editSale = soldTableData[rowID][6];
			String editSold = soldTableData[rowID][7];
			String editCondition = soldTableData[rowID][8];
			String editDateBought = soldTableData[rowID][9];
			String editDateSell = soldTableData[rowID][10];
			
			JPanel editSoldPanel = new JPanel();
			JTextField ediName = new JTextField(editName);
			JTextField ediBrand = new JTextField(editBrand);
			JTextField ediSize = new JTextField(editSize);
			JTextField ediColour = new JTextField(editColour);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JTextField ediSold = new JTextField(editSold);
			JTextField ediCondition = new JTextField(editCondition);
			JTextField ediDateBought = new JTextField(editDateBought);
			JTextField ediDateSell = new JTextField(editDateSell);
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
			editSoldPanel.add(ediDateBought);
			editSoldPanel.add(ediDateSell);
			
			int result = JOptionPane.showConfirmDialog(mainWindow, editSoldPanel, "Enter Sold Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = ediBrand.getText();
			    String sizeValue = ediSize.getText();
			    String colourValue = ediColour.getText();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String soldValue = ediSold.getText();
			    String conditionValue = ediCondition.getText();
			    String dateBoughtValue = ediDateBought.getText();
			    String dateSellValue = ediDateSell.getText();
			    API.updateSold(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, soldValue, conditionValue, dateBoughtValue, dateSellValue);
			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				soldPage.revalidate();
				soldPage.repaint();
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
			investmentsPage.revalidate();
			investmentsPage.repaint();
		
		}
		
		if (e.getSource() == addInvestment) {			
			JPanel addInvestPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JTextField brand = new JTextField("Brand");
			JTextField size = new JTextField("Size");
			JTextField colour = new JTextField("Colour");
			JTextField price = new JTextField("Price");
			JTextField sale = new JTextField("Sale");
			JTextField condition = new JTextField("Condition");
			JTextField dateBought = new JTextField("Date Bought");
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
			addInvestPanel.add(dateBought);
			addInvestPanel.add(dateSell);

			int result = JOptionPane.showConfirmDialog(mainWindow, addInvestPanel, "Enter Investment Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = brand.getText();
			    String sizeValue = size.getText();
			    String colourValue = colour.getText();
			    String priceValue = price.getText();
			    String saleValue = sale.getText();
			    String conditionValue = condition.getText();
			    String dateBoughtValue = dateBought.getText();
			    String dateSellValue = dateSell.getText();
			    API.addInvestment(nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue, dateSellValue);
			    createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);
				investmentsPage.revalidate();
				investmentsPage.repaint();
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
			JTextField ediBrand = new JTextField(editBrand);
			JTextField ediSize = new JTextField(editSize);
			JTextField ediColour = new JTextField(editColour);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JTextField ediCondition = new JTextField(editCondition);
			JTextField ediDateBought = new JTextField(editDateBought);
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
			editInvestmentPanel.add(ediDateBought);
			editInvestmentPanel.add(ediDateSell);
			
			int result = JOptionPane.showConfirmDialog(mainWindow, editInvestmentPanel, "Enter Investment Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = ediBrand.getText();
			    String sizeValue = ediSize.getText();
			    String colourValue = ediColour.getText();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String conditionValue = ediCondition.getText();
			    String dateBoughtValue = ediDateBought.getText();
			    String dateSellValue = ediDateSell.getText();
			    API.updateInvestment(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue, dateSellValue);
			    createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);
				investmentsPage.revalidate();
				investmentsPage.repaint();
			}
			
		}
		if (e.getSource() == addStock || e.getSource() == addStock2) {
			JPanel addStockPanel = new JPanel();
			JTextField name = new JTextField("Name");
			JTextField brand = new JTextField("Brand");
			FlowLayout fl = new FlowLayout();
			addStockPanel.setLayout(fl);
			addStockPanel.add(name);
			addStockPanel.add(brand);

			int result = JOptionPane.showConfirmDialog(mainWindow, addStockPanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = brand.getText();
			    API.addStock(nameValue, brandValue);

			}
		}
		
		if (e.getSource() == addShoe) {			
			JPanel addShoePanel = new JPanel();
			JTextField name = new JTextField("Name");
			JTextField brand = new JTextField("Brand");
			JTextField size = new JTextField("Size");
			JTextField colour = new JTextField("Colour");
			JTextField price = new JTextField("Price");
			JTextField sale = new JTextField("Sale");
			JTextField condition = new JTextField("Condition");
			JTextField dateBought = new JTextField("Date Bought");
			FlowLayout fl = new FlowLayout();
			addShoePanel.setLayout(fl);
			addShoePanel.add(name);
			addShoePanel.add(brand);
			addShoePanel.add(size);
			addShoePanel.add(colour);
			addShoePanel.add(price);
			addShoePanel.add(sale);
			addShoePanel.add(condition);
			addShoePanel.add(dateBought);

			int result = JOptionPane.showConfirmDialog(mainWindow, addShoePanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = name.getText();
			    String brandValue = brand.getText();
			    String sizeValue = size.getText();
			    String colourValue = colour.getText();
			    String priceValue = price.getText();
			    String saleValue = sale.getText();
			    String conditionValue = condition.getText();
			    String dateBoughtValue = dateBought.getText();
			    API.addShoe(nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue);
			    createShoeTable();
				shoePane.getViewport().remove(shoeTable);
				shoePane.getViewport().add(shoeTable);
				salesPage.revalidate();
				salesPage.repaint();
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
			JTextField ediBrand = new JTextField(editBrand);
			JTextField ediSize = new JTextField(editSize);
			JTextField ediColour = new JTextField(editColour);
			JTextField ediPrice = new JTextField(editPrice);
			JTextField ediSale = new JTextField(editSale);
			JTextField ediCondition = new JTextField(editCondition);
			JTextField ediDateBought = new JTextField(editDateBought);

			FlowLayout fl = new FlowLayout();
			editShoePanel.setLayout(fl);
			editShoePanel.add(ediName);
			editShoePanel.add(ediBrand);
			editShoePanel.add(ediSize);
			editShoePanel.add(ediColour);
			editShoePanel.add(ediPrice);
			editShoePanel.add(ediSale);
			editShoePanel.add(ediCondition);
			editShoePanel.add(ediDateBought);

			
			int result = JOptionPane.showConfirmDialog(mainWindow, editShoePanel, "Enter Stock Info:", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			    String nameValue = ediName.getText();
			    String brandValue = ediBrand.getText();
			    String sizeValue = ediSize.getText();
			    String colourValue = ediColour.getText();
			    String priceValue = ediPrice.getText();
			    String saleValue = ediSale.getText();
			    String conditionValue = ediCondition.getText();
			    String dateBoughtValue = ediDateBought.getText();
			    
			    API.updateShoe(editID, nameValue, brandValue, sizeValue, colourValue, priceValue, saleValue, conditionValue, dateBoughtValue);
			    createShoeTable();
				shoePane.getViewport().remove(shoeTable);
				shoePane.getViewport().add(shoeTable);
				salesPage.revalidate();
				salesPage.repaint();
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
			salesPage.revalidate();
			salesPage.repaint();
		
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

			    
			    API.addSold(soldName, soldBrand, soldSize, soldColour, soldPrice, soldSale, soldAmount, soldCondition, soldDateBought, soldDateSell);
			    System.out.println("Delete Shoe Test");
				String deleteID = shoeTableData[rowID][0];
				API.deleteShoe(deleteID);
				createShoeTable();
				shoePane.getViewport().remove(shoeTable);
				shoePane.getViewport().add(shoeTable);
				salesPage.revalidate();
				salesPage.repaint();
			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				soldPage.revalidate();
				soldPage.repaint();
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

			    
			    API.addSold(soldName, soldBrand, soldSize, soldColour, soldPrice, soldSale, soldAmount, soldCondition, soldDateBought, soldDateSell);
			    System.out.println("Delete Investment Test");
				String deleteID = investmentTableData[rowID][0];
				API.deleteInvestment(deleteID);
				createInvestmentTable();
				investmentPane.getViewport().remove(investmentTable);
				investmentPane.getViewport().add(investmentTable);
				investmentsPage.revalidate();
				investmentsPage.repaint();
			    createSoldTable();
				soldPane.getViewport().remove(soldTable);
				soldPane.getViewport().add(soldTable);
				soldPage.revalidate();
				soldPage.repaint();
			}
		}
		
		if (e.getSource() == loginButton) {
			String userCheck = usernameText.getText();
			String passwordCheck = passwordText.getText();
			System.out.println(userCheck);
			System.out.println(passwordCheck);
			
			if (userCheck.equals("Admin") && passwordCheck.equals("Password")) {
				cl.show(containerPanel,  "3");
				navigationBar.setVisible(true);
				usernameText.setText("Username");
				passwordText.setText("Password");
				loginPage.revalidate();
				loginPage.repaint();
			} else if (userCheck.equals("User") && passwordCheck.equals("Password")) {
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
	}
}

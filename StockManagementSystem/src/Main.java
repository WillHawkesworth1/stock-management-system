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
import javax.swing.*;

public class Main implements ActionListener {
	
	private static JFrame mainWindow;
	private static JPanel loginPage, salesPage, containerPanel, overviewPage, investmentsPage, costsPage, soldPage, weeklyReviewPage, monthlyReviewPage, usersPage;
	private static JMenuBar navigationBar;
	private static JMenu navigationMenu, loginMenu;
	private static JMenuItem overviewItem, stockItem, investmentsItem, costsItem, soldItem, weeklyReviewItem, monthlyReviewItem, usersItem, signOutItem;
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
		mainWindow.setSize(800, 600);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adds the container panel to the window.
		mainWindow.add(containerPanel);
		mainWindow.setVisible(true);
	}
	
	private static void revalidateMainWindow() {
		
		mainWindow.invalidate();
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
	
	private static void createLoginPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		loginPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Login Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		loginPage.add(titleLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont (usernameLabel.getFont ().deriveFont (30.0f));
		loginPage.add(usernameLabel);
		
		JTextField usernameText = new JTextField("Username");
		loginPage.add(usernameText);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont (passwordLabel.getFont ().deriveFont (30.0f));
		loginPage.add(passwordLabel);
		
		JTextField passwordText = new JTextField("Password");
		loginPage.add(passwordText);
		
		JButton loginButton = new JButton("Login");
		loginPage.add(loginButton);
		
		
	}
	
	private static void createSalesPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		salesPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("Current Stock Page");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		salesPage.add(titleLabel);
		
		JLabel currentValueLabel = new JLabel("Current Value: N/A");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(currentValueLabel);
		
		JLabel predictedValueLabel = new JLabel("Predicted Sale Value: N/A");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(predictedValueLabel);
		
		JLabel predictedProfitLabel = new JLabel("Predicted Profit Value: N/A");
		titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
		salesPage.add(predictedProfitLabel);
		
		JButton addStockButton = new JButton("Add Stock");
		salesPage.add(addStockButton);
		
		JButton newStockButton = new JButton("New Stock Type");
		salesPage.add(newStockButton);
		
		JButton editStockButton = new JButton("Edit Stock");
		salesPage.add(editStockButton);
		
		JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
		salesPage.add(sortStockList);
		
		JButton sortStockButton = new JButton("Sort Stock");
		salesPage.add(sortStockButton);
		
		String[] stockTableColumns = {"Stock", "Brand", "Size"};
		String[][] stockTableData = {{"Shoe 1", "Brand 1", "Size 1"},
									{"Shoe 2", "Brand 2", "Size 2"},
									{"Shoe 3", "Brand 3", "Size 3"}};
									
		JTable stockTable = new JTable(stockTableData, stockTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		
		stockTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		stockTable.setFillsViewportHeight(true);
		salesPage.add(new JScrollPane(stockTable));
		
	}
		
	private static void createOverviewPage() {
			
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		overviewPage.add(gwentGrailsLogo);	
		
		JLabel titleLabel = new JLabel("Overview Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		overviewPage.add(titleLabel);
		
		JLabel stockValueLabel = new JLabel("Current Stock Value: N/A");
		overviewPage.add(stockValueLabel);
		
		JLabel stockSaleLabel = new JLabel("Predicted Stock Sale Value: N/A");
		overviewPage.add(stockSaleLabel);
		
		JLabel stockProfitLabel = new JLabel("Predicted Stock Profit Value: N/A");
		overviewPage.add(stockProfitLabel);
			
		JLabel investmentValueLabel = new JLabel("Current Investments Value: N/A");
		overviewPage.add(investmentValueLabel);
		
		JLabel investmentSaleLabel = new JLabel("Predicted Investments Sale Value: N/A");
		overviewPage.add(investmentSaleLabel);
		
		JLabel investmentProfitLabel = new JLabel("Predicted Investments Profit Value: N/A");
		overviewPage.add(investmentProfitLabel);	
			
	}

	private static void createInvestmentsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				investmentsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Investments Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				investmentsPage.add(titleLabel);
				
				JLabel currentValueLabel = new JLabel("Current Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(currentValueLabel);
				
				JLabel predictedValueLabel = new JLabel("Predicted Sale Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(predictedValueLabel);
				
				JLabel predictedProfitLabel = new JLabel("Predicted Profit Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				investmentsPage.add(predictedProfitLabel);
				
				JButton addStockButton = new JButton("Add Investment");
				investmentsPage.add(addStockButton);
				
				JButton newStockButton = new JButton("New Stock Type");
				investmentsPage.add(newStockButton);
				
				JButton editStockButton = new JButton("Edit Investment");
				investmentsPage.add(editStockButton);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				investmentsPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Investments");
				investmentsPage.add(sortStockButton);
				
				String[] investmentsTableColumns = {"Stock", "Brand", "Size"};
				String[][] investmentsTableData = {{"Shoe 1", "Brand 1", "Size 1"},
											{"Shoe 2", "Brand 2", "Size 2"},
											{"Shoe 3", "Brand 3", "Size 3"}};
											
				JTable investmentsTable = new JTable(investmentsTableData, investmentsTableColumns) {
				
					public boolean isCellEditable(int data, int columns) {
						
						return false;
						
					}
					
				};
				
				investmentsTable.setPreferredScrollableViewportSize(new Dimension(300,300));
				investmentsTable.setFillsViewportHeight(true);
				investmentsPage.add(new JScrollPane(investmentsTable));
		
	}
	
	private static void createSoldPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				soldPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Sold Stock Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
				soldPage.add(titleLabel);
				
				JLabel currentValueLabel = new JLabel("Total Bought Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(currentValueLabel);
				
				JLabel predictedValueLabel = new JLabel("Total Sold Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(predictedValueLabel);
				
				JLabel predictedProfitLabel = new JLabel("Total Profit Value: N/A");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (24.0f));
				soldPage.add(predictedProfitLabel);
			
				JButton editStockButton = new JButton("Edit Stock");
				soldPage.add(editStockButton);
				
				JComboBox<String> sortStockList = new JComboBox<String>(stockCategories);
				soldPage.add(sortStockList);
				
				JButton sortStockButton = new JButton("Sort Stock");
				soldPage.add(sortStockButton);
				
				String[] soldTableColumns = {"Stock", "Brand", "Size"};
				String[][] soldTableData = {{"Shoe 1", "Brand 1", "Size 1"},
											{"Shoe 2", "Brand 2", "Size 2"},
											{"Shoe 3", "Brand 3", "Size 3"}};
											
				JTable soldTable = new JTable(soldTableData, soldTableColumns) {
				
					public boolean isCellEditable(int data, int columns) {
						
						return false;
						
					}
					
				};
				
				soldTable.setPreferredScrollableViewportSize(new Dimension(300,300));
				soldTable.setFillsViewportHeight(true);
				soldPage.add(new JScrollPane(soldTable));
		
	}
	
	private static void createCostsPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
				ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
				JLabel gwentGrailsLogo = new JLabel(ggLogo);
				costsPage.add(gwentGrailsLogo);
				
				JLabel titleLabel = new JLabel("Company Costs Page");
				titleLabel.setFont (titleLabel.getFont ().deriveFont (27.0f));
				costsPage.add(titleLabel);
				
				JLabel totalReturnLabel = new JLabel("Total Returns Cost: N/A");
				totalReturnLabel.setFont (totalReturnLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalReturnLabel);
				
				JLabel totalEquipmentLabel = new JLabel("Total Equipment Cost: N/A");
				totalEquipmentLabel.setFont (totalEquipmentLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalEquipmentLabel);
				
				JLabel totalPostageLabel = new JLabel("Total Postage Cost Value: N/A");
				totalPostageLabel.setFont (totalPostageLabel.getFont ().deriveFont (16.0f));
				costsPage.add(totalPostageLabel);
				
				JLabel totalBotLabel = new JLabel("Total Bot Cost Value: N/A");
				totalBotLabel.setFont (totalBotLabel.getFont ().deriveFont (17.0f));
				costsPage.add(totalBotLabel);
				
				JLabel totalOtherLabel = new JLabel("Total Other Cost Value: N/A");
				totalOtherLabel.setFont (totalOtherLabel.getFont ().deriveFont (17.0f));
				costsPage.add(totalOtherLabel);
				
				JButton addCostButton = new JButton("Add Cost");
				costsPage.add(addCostButton);
				
				JButton editCostButton = new JButton("Edit Cost");
				costsPage.add(editCostButton);
				
				JComboBox<String> sortCostList = new JComboBox<String>(stockCategories);
				costsPage.add(sortCostList);
				
				JButton sortCostButton = new JButton("Sort Cost");
				costsPage.add(sortCostButton);
				
				String[] costsTableColumns = {"Category", "Name", "Price"};
				String[][] costsTableData = {{"Category 1", "Name 1", "Price 1"},
											{"Category 2", "Name 2", "Price 2"},
											{"Category 3", "Name 3", "Price 3"}};
											
				JTable costsTable = new JTable(costsTableData, costsTableColumns) {
				
					public boolean isCellEditable(int data, int columns) {
						
						return false;
						
					}
					
				};
				
				costsTable.setPreferredScrollableViewportSize(new Dimension(300,300));
				costsTable.setFillsViewportHeight(true);
				costsPage.add(new JScrollPane(costsTable));
		
	}
	
	private static void createWeeklyReviewPage() {
		
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
		
		String[] weeklyReviewTableColumns = {"Stock", "Brand", "Size"};
		String[][] weeklyReviewTableData = {{"Shoe 1", "Brand 1", "Size 1"},
									{"Shoe 2", "Brand 2", "Size 2"},
									{"Shoe 3", "Brand 3", "Size 3"}};
									
		JTable weeklyReviewTable = new JTable(weeklyReviewTableData, weeklyReviewTableColumns) {
		
			public boolean isCellEditable(int data, int columns) {
				
				return false;
				
			}
			
		};
		weeklyReviewTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		weeklyReviewTable.setFillsViewportHeight(true);
		weeklyReviewPage.add(new JScrollPane(weeklyReviewTable));
		
	}
	
	private static void createMonthlyReviewPage() {
		
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
			
			String[] monthlyReviewTableColumns = {"Stock", "Brand", "Size"};
			String[][] monthlyReviewTableData = {{"Shoe 1", "Brand 1", "Size 1"},
												{"Shoe 2", "Brand 2", "Size 2"},
												{"Shoe 3", "Brand 3", "Size 3"}};
										
			JTable monthlyReviewTable = new JTable(monthlyReviewTableData, monthlyReviewTableColumns) {
				
				public boolean isCellEditable(int data, int columns) {
						
					return false;
						
				}
					
			};
			monthlyReviewTable.setPreferredScrollableViewportSize(new Dimension(300,300));
			monthlyReviewTable.setFillsViewportHeight(true);
			monthlyReviewPage.add(new JScrollPane(monthlyReviewTable));
			
	}
	
	private static void createUserPage() {
		
		//Creates all the of the content, setting boundaries and information for each one.
		ImageIcon ggLogo = new ImageIcon("src/GwentGrailsLogo.jpg");
		JLabel gwentGrailsLogo = new JLabel(ggLogo);
		gwentGrailsLogo.setBounds(0, 0, 100, 100);
		usersPage.add(gwentGrailsLogo);
		
		JLabel titleLabel = new JLabel("User Page");
		titleLabel.setBounds(250, 20, 500, 80);
		titleLabel.setFont (titleLabel.getFont ().deriveFont (48.0f));
		usersPage.add(titleLabel);
		
		JButton addUser = new JButton("Add User");
		usersPage.add(addUser);
		
		JButton deleteUser = new JButton("Delete User");
		usersPage.add(deleteUser);
		
		String[] usersTableColumns = {"Stock", "Brand", "Size"};
		String[][] usersTableData = {{"Shoe 1", "Brand 1", "Size 1"},
											{"Shoe 2", "Brand 2", "Size 2"},
											{"Shoe 3", "Brand 3", "Size 3"}};
									
		JTable usersTable = new JTable(usersTableData, usersTableColumns) {
			
			public boolean isCellEditable(int data, int columns) {
					
				return false;
					
			}
				
		};
		usersTable.setPreferredScrollableViewportSize(new Dimension(300,300));
		usersTable.setFillsViewportHeight(true);
		usersPage.add(new JScrollPane(usersTable));
		
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
		
		mainWindow.setJMenuBar(navigationBar);
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
			cl.show(containerPanel,  "1");
		}
		
		
	}
	
}

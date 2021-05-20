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

	public static void main(String[] args) {
		
		JFrame loginPage = new JFrame("Login Page");
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel pageTitle = new JLabel("Login Page", SwingConstants.CENTER);
		pageTitle.setPreferredSize(new Dimension(300, 100));
		loginPage.getContentPane().add(pageTitle, BorderLayout.CENTER);
		
		loginPage.setLocationRelativeTo(null);
		loginPage.pack();
		loginPage.setVisible(true);

	}

}

package programmingPartner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.Dimension;
import java.awt.*;


public class LoginWindow {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	
	
	//Create the Login Window
	public LoginWindow() {
		initialize();
	}
	
	//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		frame.setBounds(0, 0, 300, 160);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new CloseWindowAdapter());
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserNameLabel = new JLabel("User Name :");
		lblUserNameLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblUserNameLabel.setBounds(10, 11, 78, 15);
		frame.getContentPane().add(lblUserNameLabel);
		
		JLabel lblPasswordLabel = new JLabel("Password    :");
		lblPasswordLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblPasswordLabel.setBounds(10, 37, 78, 15);
		frame.getContentPane().add(lblPasswordLabel);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setToolTipText("Enter a valid user account name");
		textFieldUserName.setColumns(50);
		textFieldUserName.setBounds(89, 9, 195, 20);
		frame.getContentPane().add(textFieldUserName);
		
		JLabel lblLoginErrorLabel = new JLabel("Invalid Credentials: Please Re-enter");
		lblLoginErrorLabel.setEnabled(true);
		lblLoginErrorLabel.setForeground(Color.RED);
		lblLoginErrorLabel.setBounds(41, 63, 233, 15);
		lblLoginErrorLabel.setVisible(false);
		frame.getContentPane().add(lblLoginErrorLabel);
		
		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.setMnemonic('L');
		btnLoginButton.setToolTipText("Click button to verify user credentials");
		btnLoginButton.setBounds(32, 89, 89, 23);
		btnLoginButton.addActionListener(new LoginButtonListener());
		frame.getContentPane().add(btnLoginButton);
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.setMnemonic('C');
		btnCancelButton.setToolTipText("Click button to cancel login and exit");
		btnCancelButton.setBounds(165, 89, 89, 23);
		btnCancelButton.addActionListener(new CancelButtonListener());
		btnCancelButton.addKeyListener(new CancelButtonKeyListener());
		frame.getContentPane().add(btnCancelButton);
		
		passwordField = new JPasswordField(10);		
		passwordField.setToolTipText("Enter a valid user account password");
		passwordField.setBounds(89, 34, 195, 20);
		frame.getContentPane().add(passwordField);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUserName, passwordField, btnLoginButton, btnCancelButton}));
		
		frame.getRootPane().setDefaultButton(btnLoginButton);	//Sets LoginButton as default for Enter key press
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}//End initialize
	
	private class CancelButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				System.exit(0);
            }
		}		
	}//End class CancelButtonKeyListener
	
	
	private class LoginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String inputUserName;	//To hold user input
			char[] inputUserPass;	//To hold user input			
					
			//Get user information from text fields
			inputUserName = textFieldUserName.getText();
			inputUserPass = passwordField.getPassword();		
								
			/**
			 * INSERT CODE FOR USER NAME AND USER PASSWORD VERIFICATION
			 */
				
			//Store user information in ProgrammingPartner.java
			ProgrammingPartner.userName = inputUserName;
			//Release system resources
			frame.dispose();
			//Create the MainMenu window
			MainMenu MainMenu = new MainMenu();			
		}//End actionPerformed			
	}//End class LoginButtonListener
	
	private class CancelButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}//End actionPerformed
	}//End class CancelButtonListener
	
	private class CloseWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){ 
			int result;
			result = JOptionPane.showConfirmDialog(null, "Are your sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}//End windowClosing
		
	}//End class CloseWindowAdapter
}//End class LoginWindow


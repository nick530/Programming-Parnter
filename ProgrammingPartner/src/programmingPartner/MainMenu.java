package programmingPartner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JOptionPane;	
import java.awt.*;

public class MainMenu {

	private JFrame frame;
	
	//Create the window.
	public MainMenu() {
		initialize();
	}

	//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		frame.setBounds(0, 0, 265, 250);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new CloseWindowAdapter());
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Century", Font.BOLD, 24));
		lblMainMenu.setBounds(51, 11, 145, 30);
		frame.getContentPane().add(lblMainMenu);
		
		JButton btnLessonButton = new JButton("Go to Lessons");
		btnLessonButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLessonButton.setMnemonic('G');
		btnLessonButton.setToolTipText("Click button to load the Lesson Selection Window");
		btnLessonButton.setBounds(61, 52, 123, 30);
		btnLessonButton.addActionListener(new LessonButtonListener());
		btnLessonButton.addKeyListener(new LessonButtonKeyListener());
		frame.getContentPane().add(btnLessonButton);
		
		JButton btnProgressButton = new JButton("View Progress");
		btnProgressButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProgressButton.setMnemonic('P');
		btnProgressButton.setToolTipText("Click button to view Lesson Progress");
		btnProgressButton.setBounds(61, 93, 123, 30);
		btnProgressButton.addActionListener(new ProgressButtonListener());
		btnProgressButton.addKeyListener(new ProgressButtonKeyListener());
		frame.getContentPane().add(btnProgressButton);
		
		JButton btnAccountButton = new JButton("Manage Account");
		btnAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAccountButton.setMnemonic('M');
		btnAccountButton.setToolTipText("Click button to manage/change user account information");
		btnAccountButton.setBounds(61, 134, 123, 30);
		btnAccountButton.addActionListener(new AccountButtonListener());
		btnAccountButton.addKeyListener(new AccountButtonKeyListener());
		frame.getContentPane().add(btnAccountButton);
		
		JButton btnLogoutButton = new JButton("Log Out");
		btnLogoutButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogoutButton.setToolTipText("Click button to save and logout of Users account");
		btnLogoutButton.setMnemonic('L');
		btnLogoutButton.setBounds(160, 170, 80, 17);
		btnLogoutButton.addActionListener(new LogoutButtonListener());
		btnLogoutButton.addKeyListener(new LogoutButtonKeyListener());
		frame.getContentPane().add(btnLogoutButton);
		
		JLabel lblUserLabel = new JLabel(ProgrammingPartner.userName);
		lblUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUserLabel.setBounds(10, 176, 110, 15);
		frame.getContentPane().add(lblUserLabel);
		
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblMainMenu, btnLessonButton, btnProgressButton, btnAccountButton}));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic('x');
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setMnemonic('A');
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmHelpContents = new JMenuItem("Help Contents");
		mntmHelpContents.setMnemonic('H');
		mnHelp.add(mntmHelpContents);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLessonButton, btnProgressButton, btnAccountButton, btnLogoutButton}));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}
	
	private class LessonButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
	        	frame.dispose();
				LessonSelection LessonSelection = new LessonSelection();
            }
		}		
	}//End class LessonButtonKeyListener
	
	private class ProgressButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				//**PROGRESS WINDOW NOT DESIGNED YET***
				JOptionPane.showMessageDialog(null, "You choose the progress button");//Remove after completing Progress Window
            }
		}		
	}//End class ProgressButtonKeyListener
	
	private class AccountButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				//**ACCOUNT WINDOW NOT DESIGNED YET***
				JOptionPane.showMessageDialog(null, "You choose the account button");//Remove after completing Account Window
            }
		}		
	}//End class AccountButtonKeyListener
	
	private class LogoutButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				frame.dispose();
				ProgrammingPartner.userName = null;
				LoginWindow LoginWindow = new LoginWindow();
            }
		}		
	}//End class LogoutButtonKeyListener
	
	private class LessonButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			LessonSelection LessonSelection = new LessonSelection();
		}//End actionPerformed
	}//End class LessonButtonListener
	
	private class ProgressButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//**PROGRESS WINDOW NOT DESIGNED YET***
			//frame.setVisible(false);
			//ProgressWindow ProgressWindow = new ProgressWindow();
			JOptionPane.showMessageDialog(null, "You clicked on the progress button");	//Remove after completing Progress Window
		}//End actionPerformed
	}//End class ProgressButtonListener
	
	private class AccountButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//**ACCOUNT WINDOW NOT DESIGNED YET***
			//frame.setVisible(false);
			//AccountWindow AccountWindow = new AccountWindow();
			JOptionPane.showMessageDialog(null, "You clicked on the account button");	//Remove after completing Progress Window and Account Window
			
		}//End actionPerformed
	}//End class AccountButtonListener
	
	private class LogoutButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			ProgrammingPartner.userName = null;
			LoginWindow LoginWindow = new LoginWindow();
		}//End actionPerformed
	}//End class LogoutButtonListener
	
	private class CloseWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){ 
			int result;
			result = JOptionPane.showConfirmDialog(null, "Are your sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}//End windowClosing
		
	}//End class CloseWindowAdapter
	
}//End class MainMenu

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Main {

	private JFrame MainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.MainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainMenu = new JFrame();
		MainMenu.setBounds(100, 100, 218, 262);
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		MainMenu.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		MainMenu.getContentPane().setLayout(new BoxLayout(MainMenu.getContentPane(), BoxLayout.X_AXIS));
		
		Panel panel = new Panel();
		MainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Go to Lessons");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnNewButton.setBounds(43, 56, 113, 20);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Progress");
		btnNewButton_1.setBounds(43, 87, 113, 23);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("Manage Account");
		button.setBounds(43, 121, 113, 23);
		panel.add(button);
		
		JLabel lblProgrammingPartnerMain = new JLabel("Programming Partner Main Menu");
		lblProgrammingPartnerMain.setBounds(22, 11, 155, 14);
		panel.add(lblProgrammingPartnerMain);
	}
}

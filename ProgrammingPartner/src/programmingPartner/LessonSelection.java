package programmingPartner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;

public class LessonSelection {

	private JFrame frame;
	private JComboBox comboBoxLesson;
	private JComboBox comboBoxSection;
	private String[] lessons = {null, "Lesson One", "Lesson Two"};
	private String[] lessonOneSections = {null, "Section One", "Section Two"};
	private String[] lessonTwoSections = {null, "Section One", "Section Two"};
	private String selectedLesson;
	private String selectedSection;
	// Create the Window
	public LessonSelection() {
		initialize();
	}//End LessonSelection

	
	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		frame.setBounds(0, 0, 265, 250);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new CloseWindowAdapter());
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lesson Selection");
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 11, 219, 33);
		frame.getContentPane().add(lblNewLabel);
		
		comboBoxLesson = new JComboBox(lessons);
		comboBoxLesson.setToolTipText("Select a Lesson to proceed");
		comboBoxLesson.setMaximumRowCount(3);
		comboBoxLesson.setBounds(62, 60, 188, 20);
		comboBoxLesson.addActionListener(new ComboBoxLessonListener());		
		frame.getContentPane().add(comboBoxLesson);
		
		
		comboBoxSection = new JComboBox(lessonOneSections);
		comboBoxSection.setToolTipText("Select a Section to proceed");
		comboBoxSection.setBounds(62, 91, 188, 20);
		comboBoxSection.addActionListener(new ComboBoxSectionListener());
		frame.getContentPane().add(comboBoxSection);
		
		JLabel lblLesson = new JLabel("Lesson :");
		lblLesson.setFont(new Font("Century", Font.PLAIN, 12));
		lblLesson.setBounds(10, 63, 92, 14);
		frame.getContentPane().add(lblLesson);
		
		JLabel lblSection = new JLabel("Section :");
		lblSection.setFont(new Font("Century", Font.PLAIN, 12));
		lblSection.setBounds(10, 94, 74, 14);
		frame.getContentPane().add(lblSection);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setToolTipText("Click button to return to the main menu");
		btnBackButton.setMnemonic('B');
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackButton.setBounds(10, 136, 110, 30);
		btnBackButton.addActionListener(new BackButtonListener());
		btnBackButton.addKeyListener(new BackButtonKeyListener());
		frame.getContentPane().add(btnBackButton);
		
		JButton btnContinueButton = new JButton("Continue");
		btnContinueButton.setToolTipText("Click to confirm selections and proceed to selected Lesson Section");
		btnContinueButton.setMnemonic('C');
		btnContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnContinueButton.setBounds(139, 136, 110, 30);
		btnContinueButton.addActionListener(new ContinueButtonListener());
		btnContinueButton.addKeyListener(new ContinueButtonKeyListener());
		frame.getContentPane().add(btnContinueButton);
		
		JLabel lblUserLabel = new JLabel(ProgrammingPartner.userName);
		lblUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUserLabel.setBounds(10, 176, 110, 15);
		frame.getContentPane().add(lblUserLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic('S');
		mnFile.add(mntmSave);
		
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
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxLesson, comboBoxSection, btnBackButton, btnContinueButton}));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		
	}//End initialize
	
	//******************************************************************//
	//		THE FOLLOWING PRIVATE CLASSES DEFINE ACTIONLISTENERS		//
	//******************************************************************//
	
	//*****
	//	The ComboBoxLessonListener class implements an ActionListener for
	//	a ComboBox component named comboBoxLesson. It defines the function
	//	actionPerformed.
	//*****	
	private class ComboBoxLessonListener implements ActionListener{
		//*****
		//	The actionPerformed method 
		//*****
		
		public void actionPerformed(ActionEvent e){
			//Get the selected lesson			
			selectedLesson = (String) comboBoxLesson.getSelectedItem();
			//Update comboBoxSection based on user lesson selection
			if(selectedLesson == "Lesson One"){
				comboBoxSection.removeAllItems();
				for(int index = 0; index < lessonOneSections.length;index++){
					comboBoxSection.addItem(lessonOneSections[index]);
				}
			}
			else if(selectedLesson == "Lesson Two"){
				comboBoxSection.removeAllItems();
				for(int index = 0; index < lessonTwoSections.length;index++){
					comboBoxSection.addItem(lessonTwoSections[index]);
				}
			}			
		}//End actionPerformed		
	}//End class ComboBoxLessonListener
	
	private class ComboBoxSectionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Get the selected lesson			
			selectedSection = (String) comboBoxSection.getSelectedItem();						
		}//End actionPerformed		
	}//End class ComboBoxSectionListener
	
	private class BackButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				frame.dispose();
				MainMenu MainMenu = new MainMenu();
            }
		}		
	}//End class BackButtonKeyListener
	
	private class ContinueButtonKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				if(selectedLesson == null){
					JOptionPane.showMessageDialog(null, "Please Select a Lesson");				
				}
				else if(selectedSection == null){
					JOptionPane.showMessageDialog(null, "Please Select a Section");				
				}
				
				if(selectedLesson != null && selectedSection != null){
				ProgrammingPartner.selectedLesson = selectedLesson;
				ProgrammingPartner.selectedSection = selectedSection;
				//ProgrammingPartner.currentCheckpoint;
				frame.setVisible(false);
				LessonWindow LessonWindow = new LessonWindow();
				}
            }
		}		
	}//End class ContinueButtonKeyListener
		
	private class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			MainMenu MainMenu = new MainMenu();
		}//End actionPerformed
	}//End class BackButtonListener
	
	private class ContinueButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){			
			if(selectedLesson == null){
				JOptionPane.showMessageDialog(null, "Please Select a Lesson");				
			}
			else if(selectedSection == null){
				JOptionPane.showMessageDialog(null, "Please Select a Section");				
			}
			
			if(selectedLesson != null && selectedSection != null){
			ProgrammingPartner.selectedLesson = selectedLesson;
			ProgrammingPartner.selectedSection = selectedSection;	
			frame.setVisible(false);
			LessonWindow LessonWindow = new LessonWindow();
			}
		}//End actionPerformed
	}//End class ContinueButtonListener
	
	private class CloseWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){ 
			int result;
			result = JOptionPane.showConfirmDialog(null, "Are your sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}//End windowClosing
		
	}//End class CloseWindowAdapter
	
}//End class LessonSelection

package programmingPartner;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import java.awt.Panel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.*;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class LessonWindow {

	private JFrame frame;

	//Create the window	
	public LessonWindow() {
		initialize();
	}//End LessonWindow
	
	// Initialize the contents of the frame.	
	private void initialize() {
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new CloseWindowAdapter()); 
		
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
		frame.getContentPane().setLayout(null);
		
		Panel panelHeader = new Panel();
		panelHeader.setBounds(0, 0, 800, 50);
		frame.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblHeaderLabel = new JLabel("   " + ProgrammingPartner.selectedLesson + " / " +
											ProgrammingPartner.selectedSection);
		lblHeaderLabel.setFont(new Font("Century", Font.BOLD, 20));
		lblHeaderLabel.setBounds(0, 0, 404, 50);
		panelHeader.add(lblHeaderLabel);
		
		Panel panelContent = new Panel();
		panelContent.setBounds(0, 50, 400, 450);
		frame.getContentPane().add(panelContent);
		panelContent.setLayout(null);
		
		Panel panelInput = new Panel();
		panelInput.setBounds(400, 50, 400, 450);
		frame.getContentPane().add(panelInput);
		panelInput.setLayout(null);
		
		Panel panelProgress = new Panel();
		panelProgress.setBounds(0, 500, 800, 100);
		frame.getContentPane().add(panelProgress);
		panelProgress.setLayout(null);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setToolTipText("Click to return to the Lesson Selection Screen");
		btnBackButton.setMnemonic('B');
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackButton.setBounds(10, 11, 110, 30);
		btnBackButton.addActionListener(new BackButtonListener());
		panelProgress.add(btnBackButton);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setToolTipText("Progress though current Lesson");
		progressBar.setBounds(130, 11, 529, 30);
		panelProgress.add(progressBar);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.setToolTipText("Click button to save progress");
		btnSaveButton.setMnemonic('S');
		btnSaveButton.setBounds(669, 11, 110, 30);
		btnSaveButton.addActionListener(new SaveButtonListener());
		panelProgress.add(btnSaveButton);
		
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelContent, panelInput, panelProgress}));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}//End initialize
	
	private class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ProgrammingPartner.selectedLesson = null;
			ProgrammingPartner.selectedSection = null;
			frame.dispose();
			LessonSelection LessonSelection = new LessonSelection();
		}//End actionPerformed
	}//End class BackButtonListener
	
	private class SaveButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//***
			//***NEED TO IMPLEMENT LESSON SAVE PROCEDURES HERE
			//***
			JOptionPane.showMessageDialog(null, "You choose the save button");//Remove after completing save procedures
		}//End actionPerformed
	}//End class BackButtonListener
	
	private class CloseWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we){ 
			int result;
			result = JOptionPane.showConfirmDialog(null, "Are your sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}//End windowClosing
		
	}//End class CloseWindowAdapter
}//End class LessonWindow

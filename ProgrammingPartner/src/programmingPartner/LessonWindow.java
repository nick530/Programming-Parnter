package programmingPartner;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import java.awt.Panel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.*;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class LessonWindow {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmHelpContents;
	private Panel panelHeader;
	private JLabel lblHeaderLabel;
	private JPanel panelContent;
	private JButton btnPreviousButton;
	private JButton btnNextButton;
	private JLabel imageLabel;
	private JPanel panelInput;
	private Panel panelProgress;
	private JButton btnBackButton;
	private JProgressBar progressBar;
	private JButton btnSaveButton;
	private static final int MAX_IMAGES = 3;
	private static ImageIcon images[]; 
	private static ImageIcon displayedImage;
	private static int imageIndex = 0;	
	
	/**
	 *	CONSTRUCTOR 
	 */
	public LessonWindow() {
		initialize();
	}//End LessonWindow
	
	/**
	 * Function Definition: initialize
	 * Function Description : This function initializes the contents of the frame.	
	 */
	private void initialize() {
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE IMAGES ARRAY
		//****************************************************************************
		
		//Initialize the images array
		//The images array holds ImageIcon objects containing lesson material
		images = new ImageIcon[MAX_IMAGES];
		//Fill the images array
		for(int i = imageIndex; i < MAX_IMAGES; i++){
			images[i] = new ImageIcon("Images\\" + ProgrammingPartner.selectedLesson + 
									  "\\" + ProgrammingPartner.selectedSection + "\\" + 
									  "test" + (i) + ".jpg");
		}
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE FRAME
		//****************************************************************************
		
		//Initialize the frame
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		//Set the location and size of frame(x, y, width, height)
		frame.setBounds(0, 0, 800, 600);
		//Set default close operation
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//Add a WindowListener to confirm program exit
		frame.addWindowListener(new CloseWindowAdapter()); 
		//Set the frames Content Panel layout to null
		frame.getContentPane().setLayout(null);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE FRAMES MENU
		//****************************************************************************
		
		//Initialize the menuBar
		menuBar = new JMenuBar();
		//Set the frames menu bar
		frame.setJMenuBar(menuBar);
		
		//Initialize the File menu
		mnFile = new JMenu("File");
		//Set the menu hot key
		mnFile.setMnemonic('F');
		//Add the menu to the menu bar
		menuBar.add(mnFile);
		
		//Initialize the File menu items
		mntmSave = new JMenuItem("Save");
		//Set menu item hot key
		mntmSave.setMnemonic('S');
		//Add the menu item to the File menu
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		//Set the hot key
		mntmExit.setMnemonic('x');
		//Add the menu item to the File menu
		mnFile.add(mntmExit);
		
		//Initialize the Help menu
		mnHelp = new JMenu("Help");
		//Set the hot key
		mnHelp.setMnemonic('H');
		//Add the Help menu to the menu bar
		menuBar.add(mnHelp);
		
		//Initialize the Help menu items
		mntmAbout = new JMenuItem("About");
		//Set the hot key
		mntmAbout.setMnemonic('A');
		//Add the menu item to the help menu
		mnHelp.add(mntmAbout);
		
		mntmHelpContents = new JMenuItem("Help Contents");
		//Set the hot key
		mntmHelpContents.setMnemonic('H');
		//Add the  menu item to the Help menu;
		mnHelp.add(mntmHelpContents);
		
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE HEADER PANEL
		//****************************************************************************
		
		//Initialize the Header Panel
		panelHeader = new Panel();
		//Set the panels location and size(x, y, width, height)
		//Location x,y within the content pane of frame
		panelHeader.setBounds(0, 0, 800, 50);
		//Add the Header Panel to the Content frame
		frame.getContentPane().add(panelHeader);
		//Set the Header  Panel layout to null
		panelHeader.setLayout(null);
		//Initialize the Header Label
		lblHeaderLabel = new JLabel("   " + ProgrammingPartner.selectedLesson +
										   " / " +ProgrammingPartner.selectedSection);
		//Set the Header Labels font properties 
		lblHeaderLabel.setFont(new Font("Century", Font.BOLD, 20));
		//Set location and size of the Header Label
		//Location x,y within the Header Panel
		lblHeaderLabel.setBounds(0, 0, 404, 50);
		//Add the label to the Header Panel
		panelHeader.add(lblHeaderLabel);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE CONTENT PANEL
		//****************************************************************************
		
		//Initialize the Content Panel
		//The Content Panel contains elements necessary to display lesson material 
		//Elements include two JButtons and a JLabel set to display an ImageIcon object
		panelContent = new JPanel();
		panelContent.setBounds(3, 50, 400, 450);
		frame.getContentPane().add(panelContent);
		panelContent.setLayout(null);
		panelContent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		//Initialize the ContentPanelButtons
		btnPreviousButton = new JButton("Previous");
		btnPreviousButton.setToolTipText("Click to view previous material");
		btnPreviousButton.setMnemonic('P');
		btnPreviousButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPreviousButton.setBounds(10, 409, 110, 30);
		btnPreviousButton.addActionListener(new PreviousButtonListener());
		panelContent.add(btnPreviousButton);
		
		btnNextButton = new JButton("Next");
		btnNextButton.setToolTipText("Click to view more material");
		btnNextButton.setMnemonic('N');
		btnNextButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNextButton.setBounds(280, 409, 110, 30);
		btnNextButton.addActionListener(new NextButtonListener());
		panelContent.add(btnNextButton);
		
		//Initialize the Content Panel Label
		//The Content Panel Label displays an ImageIcon
		//The ImageIcon displayedImage holds the lesson content being displayed on screen
		imageLabel = new JLabel("");		
		displayedImage = new ImageIcon("Images\\testDefault.jpg");
		imageLabel.setBounds(10, 11, 380, 387);
		displayedImage = images[imageIndex];
		imageLabel.setIcon(displayedImage);
		panelContent.add(imageLabel);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE INPUT PANEL
		//****************************************************************************
		
		panelInput = new JPanel();
		panelInput.setBounds(400, 50, 390, 450);
		frame.getContentPane().add(panelInput);
		panelInput.setLayout(null);
		panelInput.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE PROGRESS PANEL
		//****************************************************************************
		
		panelProgress = new Panel();
		panelProgress.setBounds(0, 500, 800, 100);
		frame.getContentPane().add(panelProgress);
		panelProgress.setLayout(null);
		
		btnBackButton = new JButton("Back");
		btnBackButton.setToolTipText("Click to return to the Lesson Selection Screen");
		btnBackButton.setMnemonic('B');
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackButton.setBounds(10, 11, 110, 30);
		btnBackButton.addActionListener(new BackButtonListener());
		panelProgress.add(btnBackButton);
		
		progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setToolTipText("Progress though current Lesson");
		progressBar.setBounds(130, 11, 529, 30);
		panelProgress.add(progressBar);
		
		btnSaveButton = new JButton("Save");
		btnSaveButton.setToolTipText("Click button to save progress");
		btnSaveButton.setMnemonic('S');
		btnSaveButton.setBounds(669, 11, 110, 30);
		btnSaveButton.addActionListener(new SaveButtonListener());
		panelProgress.add(btnSaveButton);
		
		//****************************************************************************
		//			THE FOLLOWING CODE COMPLETES WINDOW INITIALIZATION
		//****************************************************************************
		
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelContent, panelInput, panelProgress}));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}//End initialize
	
	
	//****************************************************************************
	//			THE FOLLOWING CODE BLOCKS ARE PRIVATE INNER CLASSES
	//			THAT LISTEN FOR GUI INTERACTIONS IN THE CONTENT PANEL
	//****************************************************************************
	
	private class PreviousButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (imageIndex != 0){
				imageIndex--;
				displayedImage = images[imageIndex];
				imageLabel.setIcon(displayedImage);
			}
			else{
				JOptionPane.showMessageDialog(null, "You have reached the Beginning of the lesson.");	
			}
		}//End actionPerformed
	}//End class PreviousButtonListener
	
	
	private class NextButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (imageIndex < (MAX_IMAGES-1)){
				imageIndex++;
				displayedImage = images[imageIndex];
				imageLabel.setIcon(displayedImage);
			}
			else{
				JOptionPane.showMessageDialog(null, "You have reached the end of the lesson.");	
			}
			
		}//End actionPerformed
	}//End class NextButtonListener
	
	//****************************************************************************
	//			THE FOLLOWING CODE BLOCKS ARE PRIVATE INNER CLASSES
	//			THAT LISTEN FOR GUI INTERACTIONS IN THE PROGRESS PANEL
	//****************************************************************************
	
	private class BackButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ProgrammingPartner.selectedLesson = null;
			ProgrammingPartner.selectedSection = null;
			frame.dispose();
			imageIndex = 0;
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

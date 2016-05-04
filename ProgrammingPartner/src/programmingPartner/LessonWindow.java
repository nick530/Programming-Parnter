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
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class LessonWindow {

	private JFrame frame;					//The Window Frame
	private JMenuBar menuBar;				//The Menu Bar
	private JMenu mnFile;					//The File Menu
	private JMenuItem mntmSave;				//A File Menu Item
	private JMenuItem mntmExit;				//A File Menu Item
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
	private JLabel lblQuestionLabel;
	private JPanel panelProgress;
	private JButton btnBackButton;
	private JProgressBar progressBar;
	private JButton btnSaveButton;
	private static final int MAX_IMAGES = 3;
	private static int num_Questions = 3;
	private static ImageIcon images[]; 
	private static ImageIcon questions[];
	private static ImageIcon displayedImage;
	private static ImageIcon displayedQuestion;
	private static int imageIndex = 0;
	private static int questionIndex = 0;
	private JPanel panelTrueFalse;
	private JCheckBox chckbxTrue;
	private JCheckBox chckbxFalse;
	private JPanel panelMultiChoice;
	private JPanel panelTextAnswer;
	private JTextField textField;
	private JButton btnAccept;
	private JButton btnClear;
	private JButton btnNextQuestion;
	private JButton btnPreviousQuestion;
	private boolean trueFalse = true;
	private boolean textAnswer = false;
	private boolean multiChoice = false;
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
		//				THE FOLLOWING CODE INITIALIZES THE QUESTIONS ARRAY
		//****************************************************************************
		
		//Initialize the questions array
		//The questions array holds ImageIcon objects containing lesson material
		questions = new ImageIcon[num_Questions];
		//Fill the questions array
		for(int i = questionIndex; i < num_Questions; i++){
			questions[i] = new ImageIcon("Images\\" + ProgrammingPartner.selectedLesson + 
									  "\\" + ProgrammingPartner.selectedSection + "\\" + 
									  "\\Check Point" + "\\" + "test" + (i) + ".jpg");
		}
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE FRAME
		//****************************************************************************
		
		//Initialize the frame
		frame = new JFrame("Programming Partner");
		frame.setResizable(false);
		//Set the location and size of frame(x, y, width, height)
	    frame.setBounds(0,0,800,600);
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
		panelHeader.setBounds(10, 0, 774, 30);
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
		lblHeaderLabel.setBounds(0, 0, 378, 30);
		//Add the label to the Header Panel
		panelHeader.add(lblHeaderLabel);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE CONTENT PANEL
		//****************************************************************************
		
		//Initialize the Content Panel
		//The Content Panel contains elements necessary to display lesson material 
		//Elements include two JButtons and a JLabel set to display an ImageIcon object
		panelContent = new JPanel();
		panelContent.setBounds(10, 36, 450, 450);
		frame.getContentPane().add(panelContent);
		panelContent.setLayout(null);
		panelContent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		//Initialize the ContentPanelButtons
		btnPreviousButton = new JButton("Previous");
		btnPreviousButton.setToolTipText("Click to view previous material");
		btnPreviousButton.setMnemonic('P');
		btnPreviousButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPreviousButton.setBounds(116, 409, 110, 30);
		btnPreviousButton.addActionListener(new PreviousButtonListener());
		panelContent.add(btnPreviousButton);
		
		btnNextButton = new JButton("Next");
		btnNextButton.setToolTipText("Click to view more material");
		btnNextButton.setMnemonic('N');
		btnNextButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNextButton.setBounds(236, 409, 110, 30);
		btnNextButton.addActionListener(new NextButtonListener());
		panelContent.add(btnNextButton);
		
		//Initialize the Content Panel Label
		//The Content Panel Label displays an ImageIcon
		//The ImageIcon displayedImage holds the lesson content being displayed on screen
		imageLabel = new JLabel("");		
		imageLabel.setBackground(Color.BLACK);
		displayedImage = new ImageIcon("Images\\testDefault.jpg");
		imageLabel.setBounds(23, 5, 400, 400);
		displayedImage = images[imageIndex];
		imageLabel.setIcon(displayedImage);
		panelContent.add(imageLabel);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE INPUT PANEL
		//****************************************************************************
		//Create base panel
		panelInput = new JPanel();
		panelInput.setBounds(465, 36, 319, 450);
		frame.getContentPane().add(panelInput);
		panelInput.setLayout(null);
		panelInput.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		displayedQuestion = new ImageIcon("Images\\testDefault.jpg");
		displayedQuestion = questions[questionIndex];
		//Create and set question label
		lblQuestionLabel = new JLabel("");
		lblQuestionLabel.setBounds(10, 10, 300, 200);
		panelInput.add(lblQuestionLabel);
		lblQuestionLabel.setBackground(Color.BLACK);
		lblQuestionLabel.setIcon(displayedQuestion);
		//Create four buttons
		//Accept button
		btnAccept = new JButton("Accept");
		btnAccept.setToolTipText("Click to view more material");
		btnAccept.setMnemonic('N');
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAccept.setBounds(170, 409, 110, 30);
		btnAccept.addActionListener(new AcceptButtonListener());
		panelInput.add(btnAccept);
		//Clear Button
		btnClear = new JButton("Clear");
		btnClear.setToolTipText("Click to view more material");
		btnClear.setMnemonic('N');
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(50, 409, 110, 30);
		btnClear.addActionListener(new ClearButtonListener());
		panelInput.add(btnClear);
		//Next Question Button
		btnNextQuestion = new JButton("Next");
		btnNextQuestion.setToolTipText("Click to view more material");
		btnNextQuestion.setMnemonic('N');
		btnNextQuestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNextQuestion.setBounds(170, 227, 110, 30);
		btnNextQuestion.addActionListener(new NextQuestionListener());
		panelInput.add(btnNextQuestion);
		//Previous Question Button
		btnPreviousQuestion = new JButton("Previous");
		btnPreviousQuestion.setToolTipText("Click to view previous material");
		btnPreviousQuestion.setMnemonic('P');
		btnPreviousQuestion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPreviousQuestion.setBounds(50, 227, 110, 30);
		btnPreviousQuestion.addActionListener(new PreviousQuestionListener());
		panelInput.add(btnPreviousQuestion);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE TRUE FALSE PANEL
		//****************************************************************************
		panelTrueFalse = new JPanel();
		panelTrueFalse.setBounds(10, 283, 300, 115);
		panelInput.add(panelTrueFalse);
		panelTrueFalse.setBackground(Color.GRAY);
		panelTrueFalse.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelTrueFalse.setLayout(null);
		
		//Create two check boxes
		//True check box
		chckbxTrue = new JCheckBox("True");
		chckbxTrue.setBounds(99, 7, 97, 23);
		panelTrueFalse.add(chckbxTrue);
		//False check box
		chckbxFalse = new JCheckBox("False");
		chckbxFalse.setBounds(99, 33, 97, 23);
		panelTrueFalse.add(chckbxFalse);
		panelTrueFalse.setVisible(true);
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE TEXT ANSWER PANEL
		//****************************************************************************
		panelTextAnswer = new JPanel();
		panelTextAnswer.setBounds(10, 283, 300, 115);
		panelInput.add(panelTextAnswer);
		panelTextAnswer.setLayout(null);
		panelTextAnswer.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelTextAnswer.setBackground(Color.GRAY);	
		//Create a text field
		textField = new JTextField();
		textField.setBounds(10, 11, 280, 93);
		panelTextAnswer.add(textField);
		textField.setColumns(10);
		panelTextAnswer.setVisible(false);
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE MULTICHOICE PANEL
		//****************************************************************************
		panelMultiChoice = new JPanel();
		panelMultiChoice.setBounds(10, 283, 300, 115);
		panelInput.add(panelMultiChoice);
		panelMultiChoice.setLayout(null);
		panelMultiChoice.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelMultiChoice.setBackground(Color.GRAY);		
		//Create four radio buttons
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(120, 7, 55, 23);
		panelMultiChoice.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(120, 33, 55, 23);
		panelMultiChoice.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setBounds(120, 59, 55, 23);
		panelMultiChoice.add(rdbtnC);
		
		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setBounds(120, 85, 55, 23);
		panelMultiChoice.add(rdbtnD);
		panelMultiChoice.setVisible(false);
		
		
		
		//****************************************************************************
		//				THE FOLLOWING CODE INITIALIZES THE PROGRESS PANEL
		//****************************************************************************
		
		panelProgress = new JPanel();
		panelProgress.setBounds(10, 490, 774, 50);
		frame.getContentPane().add(panelProgress);
		panelProgress.setLayout(null);
		panelProgress.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setToolTipText("Progress though current Lesson");
		progressBar.setBounds(175, 11, 428, 30);
		panelProgress.add(progressBar);
		
		btnSaveButton = new JButton("Save");
		btnSaveButton.setToolTipText("Click button to save progress");
		btnSaveButton.setMnemonic('S');
		btnSaveButton.setBounds(654, 11, 110, 30);
		btnSaveButton.addActionListener(new SaveButtonListener());
		panelProgress.add(btnSaveButton);
		
		btnBackButton = new JButton("Back");
		btnBackButton.setBounds(10, 11, 110, 30);
		panelProgress.add(btnBackButton);
		btnBackButton.setToolTipText("Click to return to the Lesson Selection Screen");
		btnBackButton.setMnemonic('B');
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBackButton.addActionListener(new BackButtonListener());
		
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
	//			THAT LISTEN FOR GUI INTERACTIONS IN THE INPUT PANEL
	//****************************************************************************
	
	private class NextQuestionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (questionIndex < (num_Questions-1)){
				questionIndex++;
				displayedQuestion = questions[questionIndex];
				lblQuestionLabel.setIcon(displayedQuestion);
			}
				if(questionIndex == 0){
					trueFalse = true;					
					multiChoice = false;
					textAnswer = false;
				}
				else if(questionIndex == 1){
						trueFalse = false;
						multiChoice = true;
						textAnswer = false;
				}
				else if(questionIndex == 2){
						trueFalse = false;
						multiChoice = false;
						textAnswer = true;					
				}
				
				if(trueFalse){
					panelTrueFalse.setVisible(true);
					panelTextAnswer.setVisible(false);
					panelMultiChoice.setVisible(false);
				}
				else if(textAnswer){
					panelTrueFalse.setVisible(false);
					panelTextAnswer.setVisible(true);
					panelMultiChoice.setVisible(false);
				}
				else if(multiChoice){
					panelTrueFalse.setVisible(false);
					panelTextAnswer.setVisible(false);
					panelMultiChoice.setVisible(true);
				}
				
			else{
				JOptionPane.showMessageDialog(null, "You have reached the Last Question.");	
			}
			
		}//End actionPerformed
	}//End class NextQuestionListener
	
	private class PreviousQuestionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (questionIndex != 0){
				questionIndex--;
				displayedQuestion = questions[questionIndex];
				lblQuestionLabel.setIcon(displayedQuestion);
			}
				if(questionIndex == 0){
					trueFalse = true;					
					multiChoice = false;
					textAnswer = false;
				}
				else if(questionIndex == 1){
						trueFalse = false;
						multiChoice = true;
						textAnswer = false;
				}
				else if(questionIndex == 2){
						trueFalse = false;
						multiChoice = false;
						textAnswer = true;					
				}
				
				if(trueFalse){
					panelTrueFalse.setVisible(true);
					panelTextAnswer.setVisible(false);
					panelMultiChoice.setVisible(false);
				}
				else if(textAnswer){
					panelTrueFalse.setVisible(false);
					panelTextAnswer.setVisible(true);
					panelMultiChoice.setVisible(false);
				}
				else if(multiChoice){
					panelTrueFalse.setVisible(false);
					panelTextAnswer.setVisible(false);
					panelMultiChoice.setVisible(true);
				}
			else{
				JOptionPane.showMessageDialog(null, "You have reached the First Question.");	
			}
		}//End actionPerformed
	}//End class PreviousQuestionListener
	
	private class AcceptButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//***
			//***NEED TO IMPLEMENT QUESTION- ANSWER VERIFICATION PROCEDURES HERE
			//***
			JOptionPane.showMessageDialog(null, "You choose the accept button");//Remove after completing procedures
		}//End actionPerformed
	}//End class AcceptButtonListener
	
	private class ClearButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//***
			//***NEED TO IMPLEMENT QUESTION-ANSWER RESET PROCEDURES HERE
			//***
			JOptionPane.showMessageDialog(null, "You choose the clear button");//Remove after completing procedures
		}//End actionPerformed
	}//End class ClearButtonListener
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

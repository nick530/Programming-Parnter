import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class MultipleChoice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleChoice window = new MultipleChoice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultipleChoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IMAGE HERE");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 414, 140);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Additional info here");
		lblNewLabel_1.setBounds(157, 162, 105, 14);
		panel.add(lblNewLabel_1);
		
		JRadioButton rdbtnChoice_1 = new JRadioButton("Choice1");
		rdbtnChoice_1.setBounds(47, 183, 109, 23);
		panel.add(rdbtnChoice_1);
		
		JRadioButton rdbtnChoice_2 = new JRadioButton("Choice2");
		rdbtnChoice_2.setBounds(47, 218, 109, 23);
		panel.add(rdbtnChoice_2);
		
		JRadioButton rdbtnChoice_3 = new JRadioButton("Choice3");
		rdbtnChoice_3.setBounds(243, 183, 109, 23);
		panel.add(rdbtnChoice_3);
		
		JRadioButton rdbtnChoice4 = new JRadioButton("Choice4");
		rdbtnChoice4.setBounds(243, 218, 109, 23);
		panel.add(rdbtnChoice4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(157, 259, 89, 23);
		panel.add(btnSubmit);
	}
}

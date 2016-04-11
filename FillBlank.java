import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class FillBlank {

	private JFrame frame;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FillBlank window = new FillBlank();
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
	public FillBlank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblImageHere = new JLabel("IMAGE HERE");
		lblImageHere.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImageHere.setBounds(10, 11, 414, 118);
		panel.add(lblImageHere);
		
		JLabel lblAdditionalInfoHere = new JLabel("Additional Info Here");
		lblAdditionalInfoHere.setBounds(160, 140, 96, 14);
		panel.add(lblAdditionalInfoHere);
		
		txtInput = new JTextField();
		txtInput.setBounds(94, 165, 243, 20);
		panel.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(160, 196, 89, 23);
		panel.add(btnSubmit);
	}
}

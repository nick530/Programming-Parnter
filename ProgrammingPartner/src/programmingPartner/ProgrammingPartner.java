package programmingPartner;

import java.awt.EventQueue;

public class ProgrammingPartner {
	static String userName;
	static String selectedLesson;
	static String selectedSection;
	static String currentCheckpoint;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow LoginWindow = new LoginWindow();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	
		});
	}//End main
}//End Programming Partner

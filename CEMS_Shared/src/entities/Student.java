package entities;

import java.util.ArrayList;

public class Student extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8543197188371937033L;
	private ArrayList<ExecutedTest> testsExecutedArr;

	public Student(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
		
	}

	
}

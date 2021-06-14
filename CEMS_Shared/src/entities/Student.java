package entities;

import java.util.ArrayList;

/**
 * @author David
 *	Student type of user
 */
public class Student extends User {

	private static final long serialVersionUID = -8543197188371937033L;
	private ArrayList<ExecutedTest> testsExecutedArr;



	/**
	 * @param username			Student username	
	 * @param password			Student password
	 * @param firstName			Student first name
	 * @param lastName			Student last name
	 * @param personalSID		Student personal ID
	 * @param email				Student email
	 * @param role				Student role
	 */
	public Student(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
		
	}
	
	public ArrayList<ExecutedTest> getTestsExecutedArr() {
		return testsExecutedArr;
	}
	
}

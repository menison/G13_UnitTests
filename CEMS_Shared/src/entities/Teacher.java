package entities;

/**
 * @author David
 *	Teacher class type of user 
 */
public class Teacher extends User {


	private static final long serialVersionUID = -683452306781377337L;

	/**
	 * @param username			Teacher username
	 * @param password			Teacher password
	 * @param firstName			Teacher first name
	 * @param lastName			Teacher last name
	 * @param personalSID		Teacher personal ID
	 * @param email				Teacher email
	 * @param role				Teacher role
	 */
	public Teacher(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
		
	}

	
}

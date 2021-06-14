package entities;

/**
 * @author David
 * Class for principal type of user
 */
public class Principal extends User {

	
	private static final long serialVersionUID = 629373580566303236L;

	/**
	 * @param username			principal username
	 * @param password			principal password
	 * @param firstName			principal first name
	 * @param lastName			principal last name
	 * @param personalSID		principal personal ID
	 * @param email				principal email
	 * @param role				role
	 */
	public Principal(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
	}

}

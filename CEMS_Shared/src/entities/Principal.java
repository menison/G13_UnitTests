package entities;

public class Principal extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 629373580566303236L;

	public Principal(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
	}

}

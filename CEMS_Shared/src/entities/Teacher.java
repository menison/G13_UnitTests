package entities;

public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -683452306781377337L;

	public Teacher(String username, String password, String firstName, String lastName, String personalSID,
			String email, String role) {
		
		super(username, password, firstName, lastName, personalSID, email, role);
		
	}

	
}

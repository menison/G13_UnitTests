package entities;

import java.io.Serializable;

/**
 *  This class creates a "Park" entity and includes the function getID.
 */
public abstract class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String personalSID; //personal identifier -> for a student = ID, for a teacher/principal = workerID.
	private String email;
	private String role;

	public User(String username, String password, String firstName, String lastName, String personalSID, String email,
			String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalSID = personalSID;
		this.email = email;
		this.role = role;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPersonalSID() {
		return personalSID;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	
}

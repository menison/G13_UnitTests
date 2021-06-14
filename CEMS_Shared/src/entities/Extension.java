package entities;

import java.io.Serializable;



/**
 * Class extension for data from Extension table in SQL DATABASE
 * @author David
 *
 */
public class Extension implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String testCode;
	private String requestedBy;
	private int newDuration;
	private String reason;
	private int isRelevant;
	private int isAuthorized;
	
	/**
	 * Constructor
	 * @param testCode			Test execution code
	 * @param requestedBy		ID of extension requester
	 * @param newDuration		new duration of requester
	 * @param reason			reason for time extension
	 * @param isRelevant		is extension still relevant
	 * @param isAuthorized		did principal authorized extension
	 */
	public Extension(String testCode, String requestedBy, int newDuration, String reason, int isRelevant,int isAuthorized) {

		this.testCode = testCode;
		this.requestedBy = requestedBy;
		this.newDuration = newDuration;
		this.reason = reason;
		this.isRelevant = isRelevant;
		this.isAuthorized=isAuthorized;
	}
	/**
	 * Constructor for three fields
	 * @param newDuration			duration for extension
	 * @param testCode				execution code
	 * @param requestedBy			ID of extension requester
	 */
	public Extension(int newDuration,String testCode, String requestedBy) {

		this.testCode = testCode;
		this.requestedBy = requestedBy;
		this.newDuration = newDuration;
	}

	public String getTestCode() {
		return testCode;
	}
	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public int getNewDuration() {
		return newDuration;
	}
	public void setNewDuration(int newDuration) {
		this.newDuration = newDuration;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getIsRelevant() {
		return isRelevant;
	}
	public void setIsRelevant(int isRelevant) {
		this.isRelevant = isRelevant;
	}
	public int getIsAuthorized() {
		return isAuthorized;
	}
	public void setIsAuthorized(int isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

}

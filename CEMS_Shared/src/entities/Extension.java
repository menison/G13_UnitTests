package entities;

import java.io.Serializable;

public class Extension implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2250533346362565971L;
	private String testCode;
	private String requestedBy;
	private int newDuration;
	private String reason;
	private int isRelevant;
	private int isAuthorized;
	
	public Extension(String testCode, String requestedBy, int newDuration, String reason, int isRelevant,int isAuthorized) {

		this.testCode = testCode;
		this.requestedBy = requestedBy;
		this.newDuration = newDuration;
		this.reason = reason;
		this.isRelevant = isRelevant;
		this.isAuthorized=isAuthorized;
	}
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

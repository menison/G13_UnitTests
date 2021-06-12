package entities;

import java.io.Serializable;

public class ActivatedTest implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7278799683179472714L;
	private String testCode;
	private String testID;
	private String activatedBy;
	private String startDate;
	private String startTime;
	private int isActivated;
	
	public ActivatedTest(String testCode, String testID, String activatedBy, String startDate, String startTime,
			int isActivated) {
		this.testCode = testCode;
		this.testID = testID;
		this.activatedBy = activatedBy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.isActivated = isActivated;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public String getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

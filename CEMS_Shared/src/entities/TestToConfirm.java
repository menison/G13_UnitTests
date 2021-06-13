package entities;


import java.io.Serializable;

public class TestToConfirm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473453805476116538L;
	private String testID;
	private String testCode;
	private String date;
	private String executedBy;
	private int grade;
	private int isSuspect;
	
	public TestToConfirm(String testID, String testCode, String date, String executedBy, 
			int grade, int isSuspect) {
		super();
		this.testID = testID;
		this.testCode = testCode;
		this.date = date;
		this.executedBy = executedBy;
		this.grade = grade;
		this.isSuspect = isSuspect;
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExecutedBy() {
		return executedBy;
	}

	public void setExecutedBy(String executedBy) {
		this.executedBy = executedBy;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getIsSuspect() {
		return isSuspect;
	}

	public void setIsSuspect(int isSuspect) {
		this.isSuspect = isSuspect;
	}
	
}

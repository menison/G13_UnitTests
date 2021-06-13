package entities;

public class TestToConfirm {
	private String testID;
	private String testCode;
	private String date;
	private String executedBy;
	private int Grade;
	
	public TestToConfirm(String testID, String testCode, String date, String executedBy, int grade) {
		super();
		this.testID = testID;
		this.testCode = testCode;
		this.date = date;
		this.executedBy = executedBy;
		Grade = grade;
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
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}
	
	
	
}

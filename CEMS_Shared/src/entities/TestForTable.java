package entities;

public class TestForTable {
	private String testID;
	private String testCode;
	private String Date;
	private int allocatedDuration;
	private int ActualDuration;
	private int grade;
	
	public TestForTable(String testID,String testCode,String Date,int allocatedDuration,
			int ActualDuration,int grade) {
		this.testID = testID;
		this.testCode = testCode;
		this.Date = Date;
		this.allocatedDuration = allocatedDuration;
		this.ActualDuration = ActualDuration;
		this.grade = grade;
	}
}
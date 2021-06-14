package entities;

import java.io.Serializable;

/**
 * @author David
 * this is class is for table view of tests
 */
public class TestForTable implements Serializable {

	private static final long serialVersionUID = -4071914729383965702L;
	private String testID;
	private String testCode;
	private String Date;
	private int allocatedDuration;
	private int ActualDuration;
	private int grade;
	
	/**
	 * @param testID				test id
	 * @param testCode				test code
	 * @param Date					date of test
	 * @param allocatedDuration		allocated duration
	 * @param ActualDuration		actual duration
	 * @param grade					grade
	 */
	public TestForTable(String testID,String testCode,String Date,int allocatedDuration,
			int ActualDuration,int grade) {
		this.testID = testID;
		this.testCode = testCode;
		this.Date = Date;
		this.allocatedDuration = allocatedDuration;
		this.ActualDuration = ActualDuration;
		this.grade = grade;
	}
	
	public TestForTable(String testID) {
		this.testID = testID;
	}
	
	@Override
	public String toString() {
		return(this.testID+","+this.testCode+","+this.Date+","+this.allocatedDuration+
				","+this.ActualDuration+","+this.grade);
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
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getAllocatedDuration() {
		return allocatedDuration;
	}

	public void setAllocatedDuration(int allocatedDuration) {
		this.allocatedDuration = allocatedDuration;
	}

	public int getActualDuration() {
		return ActualDuration;
	}

	public void setActualDuration(int actualDuration) {
		ActualDuration = actualDuration;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
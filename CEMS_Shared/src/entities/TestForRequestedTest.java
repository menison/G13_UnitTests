package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class TestForRequestedTest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6722688811115229185L;
	private String testID;
	private String testCode;
	private String date;
	private int allocatedDuration;
	private int actualDuration;
	private int grade;
	private ArrayList<QaForTable> qa;

	public TestForRequestedTest(String testID, String testCode, String date, int allocatedDuration, int actualDuration,
			int grade,ArrayList<QaForTable> qa) {
		this.testID = testID;
		this.testCode = testCode;
		this.date = date;
		this.allocatedDuration = allocatedDuration;
		this.actualDuration = actualDuration;
		this.grade = grade;
		this.qa = qa;
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

	public int getAllocatedDuration() {
		return allocatedDuration;
	}

	public void setAllocatedDuration(int allocatedDuration) {
		this.allocatedDuration = allocatedDuration;
	}

	public int getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(int actualDuration) {
		this.actualDuration = actualDuration;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public ArrayList<QaForTable> getQa() {
		return qa;
	}

	public void setQa(ArrayList<QaForTable> qa) {
		this.qa = qa;
	}
	
}

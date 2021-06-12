package entities;

import java.time.LocalTime;

public class ExecutedTest  {
	
	private String studentExecuting;
	private Test test;
	private String executionCodePK = null;
	private int[] answers;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	private String composedBy;
	
	public ExecutedTest(Test test, String executionCodePK, int[] answers,
			String studentExecuting, int actualDuration, LocalTime startTime, LocalTime endTime) {
		super();
		this.test = test;
		this.executionCodePK = test.getCurrExecutionCode();
		this.answers = answers;
		this.studentExecuting = studentExecuting;
		this.actualDuration = actualDuration;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getExecutionCodePK() {
		return executionCodePK;
	}

	public void setExecutionCodePK(String executionCodePK) {
		this.executionCodePK = executionCodePK;
	}

	public int[] getAnswers() {
		return answers;
	}

	public int getActualDuration() {
		return actualDuration;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public String getExecutedBy() {
		return studentExecuting;
	}

	public void setExecutedBy(String executedBy) {
		this.studentExecuting = executedBy;
	}

	public Test getTest() {
		return test;
	}
	public String getComposedBy() {
		return composedBy;
	}

	public void setComposedBy(String composedBy) {
		this.composedBy = composedBy;
	}
}

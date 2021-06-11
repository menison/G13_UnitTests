package entities;

import java.time.LocalTime;

public class ExecutedTest  {
	
	private String studentExecuting;
	private Test testInExecution;
	private String executionCodePK = null;
	private int[] answers;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	

	public ExecutedTest(Test testInExecution, String executionCodePK, int[] answers,
			String studentExecuting, int actualDuration, LocalTime startTime, LocalTime endTime) {
		super();
		this.testInExecution = testInExecution;
		this.executionCodePK = testInExecution.getCurrExecutionCode();
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

	public Test getTestInExecution() {
		return testInExecution;
	}


}

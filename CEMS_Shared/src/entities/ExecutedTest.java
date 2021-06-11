package entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ExecutedTest extends Test {
	
	private String executionCodePK = null;
	private HashMap<Question, Integer> answers;
	private Student executedBy;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	

	public ExecutedTest(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, HashMap<Question, Integer> pointDistribution,
			boolean isActivated, String executionCodePK, int actualDuration, LocalTime startTime, LocalTime endTime) {
		super(questions, testID, allocatedDuration, commentsForStudents, commentsForTeachers, currExecutionCode,
				pointDistribution, isActivated);
		this.executionCodePK = executionCodePK;
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

	public HashMap<Question, Integer> getAnswers() {
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

	public Student getExecutedBy() {
		return executedBy;
	}

	public void setExecutedBy(Student executedBy) {
		this.executedBy = executedBy;
	}


}

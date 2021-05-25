package entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ExecutedTest extends Test {
	
	private String executionCodePK = null;
	private HashMap<Question, Integer> answers;
	//private Student studentThatExecuted;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public ExecutedTest(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, HashMap<Question, Integer> pointDistribution,
			boolean isActivated) {
		super(questions, testID, allocatedDuration, commentsForStudents, commentsForTeachers, currExecutionCode,
				pointDistribution, isActivated);
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

	
	

	


}

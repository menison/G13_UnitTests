package entities;

import java.util.ArrayList;

public class Test {
	
    public ArrayList<Question> questions = new ArrayList<>();
	public String testID;
	private int allocatedDuration; //given in minutes
	private String commentsForStudents;
	private String commentsForTeachers;
	private String currExecutionCode;
	private int[] pointDistribution;
	private boolean isActivated;


	public Test(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, int[] pointDistribution, boolean isActivated) {
		super();
		this.questions = questions;
		this.testID = testID;
		this.allocatedDuration = allocatedDuration;
		this.commentsForStudents = commentsForStudents;
		this.commentsForTeachers = commentsForTeachers;
		this.currExecutionCode = currExecutionCode;
		this.pointDistribution = pointDistribution;
		this.isActivated = isActivated;
	}

	public int howManyQuestions() {
		return questions.size();
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public String getTestID() {
		return testID;
	}

	public int getAllocatedDuration() {
		return allocatedDuration;
	}

	public String getCommentsForStudents() {
		return commentsForStudents;
	}

	public String getCommentsForTeachers() {
		return commentsForTeachers;
	}

	public String getCurrExecutionCode() {
		return currExecutionCode;
	}

	public int[] getPointDistribution() {
		return pointDistribution;
	}

	public boolean isActivated() {
		return isActivated;
	}
	
	
}

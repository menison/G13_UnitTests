package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
	
    public ArrayList<Question> questions = new ArrayList<>();
	public String testID;
	private int allocatedDuration; //given in minutes
	private String commentsForStudents;
	private String commentsForTeachers;
	private String currExecutionCode;
	private HashMap <Question, Integer> pointDistribution;
	private int NumberOfQuestion;
	private boolean isActivated;

	public Test(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, HashMap<Question, Integer> pointDistribution,
			boolean isActivated) {
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

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public int getAllocatedDuration() {
		return allocatedDuration;
	}

	public void setAllocatedDuration(int allocatedDuration) {
		this.allocatedDuration = allocatedDuration;
	}

	public String getCommentsForStudents() {
		return commentsForStudents;
	}

	public void setCommentsForStudents(String commentsForStudents) {
		this.commentsForStudents = commentsForStudents;
	}

	public String getCommentsForTeachers() {
		return commentsForTeachers;
	}

	public void setCommentsForTeachers(String commentsForTeachers) {
		this.commentsForTeachers = commentsForTeachers;
	}

	public String getCurrExecutionCode() {
		return currExecutionCode;
	}

	public void setCurrExecutionCode(String currExecutionCode) {
		this.currExecutionCode = currExecutionCode;
	}

	public HashMap<Question, Integer> getPointDistribution() {
		return pointDistribution;
	}

	public void setPointDistribution(HashMap<Question, Integer> pointDistribution) {
		this.pointDistribution = pointDistribution;
	}

	public int getNumberOfQuestion() {
		return NumberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		NumberOfQuestion = numberOfQuestion;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
	
}

package entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	
    public ArrayList<Question> questions = new ArrayList<>();
	public String testID;
	private int allocatedDuration; //given in minutes
	private String commentsForStudents;
	private String commentsForTeachers;
	private String currExecutionCode;
	private String[] pointDistribution;
	private String teacherComposed;
	private int isActivated;


	public Test(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, 
			String[] pointDistribution, int isActivated, String composedBy) {
		super();
		this.questions = questions;
		this.testID = testID;
		this.allocatedDuration = allocatedDuration;
		this.commentsForStudents = commentsForStudents;
		this.commentsForTeachers = commentsForTeachers;
		this.currExecutionCode = currExecutionCode;
		this.pointDistribution = pointDistribution;
		this.isActivated = isActivated;
		this.teacherComposed = composedBy;
	}

	public String getComposedBy() {
		return teacherComposed;
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

	public String[] getPointDistribution() {
		return pointDistribution;
	}

	public int isActivated() {
		return isActivated;
	}
	@Override
	public String toString() {
		String str = new String();
		for (Question q : questions) 
		{ 
		    str+=q;
		}
		return(str + "," + testID + "," + allocatedDuration + "," + commentsForStudents +
				"," + commentsForTeachers + "," + currExecutionCode + "," +
				Arrays.toString(pointDistribution) + "," + teacherComposed + "," + isActivated);
	}
	
}

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
	
	
	
}

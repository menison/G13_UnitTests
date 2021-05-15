package entities;

import java.util.HashMap;

public class Exam {
	public String testID;
	private int allocatedDuration; //given in minutes
	private String comments4Students;
	private String comments4Teachers;
	private String executionCode; //each time a test is activated by a teacher, a new execution code is being set.
	private HashMap <Question, Integer> pointDistribution;
	
}

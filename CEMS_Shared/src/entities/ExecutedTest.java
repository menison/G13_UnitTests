package entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Arrays;

public class ExecutedTest implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7952896035972742953L;
	private String studentExecuting;
	private Test test;
	private String executionCodePK = null;
	private int[] answers;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	private String date;
	private String composedBy;
	private int grade;
	private String sTime;
	

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
	
	public void initAnswers() {
		answers = new int[this.test.howManyQuestions()];
		for(int i = 0; i < answers.length;i++)
			setAnswers(i,-1);
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int[] getAnswers() {
		return answers;
	}
	
	public void setAnswers(int i,int val) {
		if(answers[i] != val)
			answers[i] = val;
	}

	public int getActualDuration() {
		return actualDuration;
	}
	
	public void setActualDuration(int duration) {
		this.actualDuration = duration;
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
	@Override
	public String toString() {
		return(studentExecuting + "," + test.toString() + "," + executionCodePK +
				"," + Arrays.toString(answers) + "," + actualDuration + "," + startTime + 
				"," + endTime + "," + composedBy);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

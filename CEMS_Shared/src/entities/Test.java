package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author David
 * class for test, used to create tests such as one in table SQL DATABASE
 */
public class Test implements Serializable {
	

	private static final long serialVersionUID = 945059225263917860L;
	public ArrayList<Question> questions = new ArrayList<>();
	public String testID;
	private int allocatedDuration; //given in minutes
	private String commentsForStudents;
	private String commentsForTeachers;
	private String currExecutionCode;
	private String[] pointDistribution;
	private String teacherComposed;
	private String subject;
	private String course;
	private int isActivated;
	private String activatedBy;
	private String dateOfStart;
	private String timeOfStart;
	private String questionString;
	private String pointsString;
	private String questionIDString;

	/**
	 * @param testID				test ID
	 * @param questionString		question in string
	 * @param allocatedDuration		test duration
	 * @param commentsForStudents	comments for students by teacher
	 * @param commentsForTeachers	comments for teacher by teacher
	 * @param currExecutionCode		current code
	 * @param pointsString			points in string
	 * @param isActivated			is test active
	 * @param teacherComposed		ID of teacher who composed
	 */
	public Test (String testID,String questionString,int allocatedDuration,String commentsForStudents,String commentsForTeachers,String currExecutionCode,String pointsString,int isActivated,String teacherComposed) {
	
		this.testID=testID;
		this.questionString=questionString;
		this.allocatedDuration=allocatedDuration;
		this.commentsForStudents=commentsForStudents;
		this.commentsForTeachers=commentsForTeachers;
		this.currExecutionCode=currExecutionCode;
		this.pointsString=pointsString;
		this.isActivated=isActivated;
		this.teacherComposed=teacherComposed;
		
		
	}
	/**
	 * @param questions				list of questions
	 * @param testID				test id
	 * @param allocatedDuration		duration of test
	 * @param commentsForStudents	comments for students by teacher
	 * @param commentsForTeachers	comments for teacher by teacher
	 * @param currExecutionCode		current code
	 * @param pointDistribution		points
	 * @param isActivated			is test active
	 * @param composedBy			ID of teacher who composed
	 */
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
		this.questionString ="";
		for(Question s: questions) {
			this.questionString += s.getText() + "," ;
		}
		this.pointsString = "";
		for(String s: pointDistribution) {
			this.pointsString+= s + "," ;
		}
		this.questionIDString ="";
		for(Question s: questions) {
			this.questionIDString += s.getQuestionID() + "," ;
		}
	}
	

	public String getQuestionIDString() {
		return questionIDString;
	}


	public void setQuestionIDString(String questionIDString) {
		this.questionIDString = questionIDString;
	}


	public String getQuestionString() {
		return questionString;
	}


	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}


	/**
	 * @param questions					questions arraylist
	 * @param testID					test id
	 * @param allocatedDuration			duration
	 * @param commentsForStudents		comments for students
	 * @param commentsForTeachers		comments for teacher
	 * @param currExecutionCode			code of current execution
	 * @param pointDistribution			points 
	 * @param teacherComposed			ID of teacher composed the test
	 * @param subject					field id
	 * @param course					course id
	 * @param isActivated				Is test active
	 */
	public Test(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, String[] pointDistribution, String teacherComposed,
			String subject, String course, int isActivated) {
		super();
		this.questions = questions;
		this.testID = testID;
		this.allocatedDuration = allocatedDuration;
		this.commentsForStudents = commentsForStudents;
		this.commentsForTeachers = commentsForTeachers;
		this.currExecutionCode = currExecutionCode;
		this.pointDistribution = pointDistribution;
		this.teacherComposed = teacherComposed;
		this.subject = subject;
		this.course = course;
		this.isActivated = isActivated;
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
	
	public void setTestID(String testID) {
		this.testID=testID;
	}

	public String getTestID() {
		return testID;
	}

	public int getAllocatedDuration() {
		return allocatedDuration;
	}
	
	public void setAllocatedDuration(int duration) {
		this.allocatedDuration = duration;
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
	
	public void setActivated(int isActivated) {
		this.isActivated = isActivated;
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

	public String getTimeOfStart() {
		return timeOfStart;
	}

	public void setTimeOfStart(String timeOfStart) {
		this.timeOfStart = timeOfStart;
	}

	public String getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(String dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public String getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}


	public String getPointsString() {
		return pointsString;
	}


	public void setPointsString(String pointsString) {
		this.pointsString = pointsString;
	}
	
}

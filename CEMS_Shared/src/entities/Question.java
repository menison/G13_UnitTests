package entities;

import java.io.Serializable;
import java.util.Arrays;

public class Question implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659289080390862340L;
	private String questionID;
	private String text, teacherComposed;
	private String[] answers;
	private String answersString;
	private int correctAnswerIndex;
	
	public Question(String questionID, String text, String[] answers, int correctAnswerIndex, 
			String teacherComposed) {
		super();
		this.questionID = questionID;
		this.text = text;
		this.answers = answers;
		this.correctAnswerIndex = correctAnswerIndex;
		this.teacherComposed = teacherComposed;
		this.answersString ="";
		for(String s: answers) {
			this.answersString += s + "," ;
		}
	}

	public Question(String questionID) {
		this.questionID=questionID;
		
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public String getTeacherComposed() {
		return teacherComposed;
	}
	@Override
	public String toString() {
		return(questionID);
	}
	public String getAnswersString() {
		return answersString;
	}

	public void setAnswersString(String answersString) {
		this.answersString = answersString;
	}
	
}

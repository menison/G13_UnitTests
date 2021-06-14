package entities;

import java.io.Serializable;

public class QuestionForCreateTest implements Serializable{
	public String getQuestionStr() {
		return questionStr;
	}
	public void setQuestionStr(String questionStr) {
		this.questionStr = questionStr;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question;
	private String points;
	private String questionStr;
	public QuestionForCreateTest(Question question, String points) {
		super();
		this.question = question;
		this.points = points;
	}
	public QuestionForCreateTest(String question, String points) {
		super();
		this.questionStr = question;
		this.points = points;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
}

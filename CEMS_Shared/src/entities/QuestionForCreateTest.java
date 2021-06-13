package entities;

import java.io.Serializable;

public class QuestionForCreateTest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question;
	private String points;
	
	public QuestionForCreateTest(Question question, String points) {
		super();
		this.question = question;
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

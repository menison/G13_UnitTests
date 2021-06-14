package entities;

import java.io.Serializable;

/**
 * @author David
 *This class is used for add test and edit test
 *we use and object of this class to display quests in a certain test table view
 */
public class QuestionForCreateTest implements Serializable{



	private static final long serialVersionUID = 1L;
	private Question question;
	private String points;

	/**
	 * @param question		Question 
	 * @param points		points of question
	 */
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

package entities;

import java.io.Serializable;

/**
 * @author David
 *	Class used for Question and answers table
 */
public class QaForTable implements Serializable {
	

	private static final long serialVersionUID = 6235476027646410793L;
	private String questionNum;
	private int answer;
	/**
	 * @param questionNum		question number
	 * @param answer			answers
	 */
	public QaForTable(String questionNum,int answer) {
		this.answer = answer;
		this.questionNum = questionNum;
	}
	
	public String getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(String questionNum) {
		this.questionNum = questionNum;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
}

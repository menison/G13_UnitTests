package entities;

public class Question {
	
	private String questionID;
	private String text, teacherComposed;
	private String[] answers;
	private int correctAnswerIndex;
	
	public Question(String questionID, String text, String[] answers, int correctAnswerIndex, 
			String teacherComposed) {
		super();
		this.questionID = questionID;
		this.text = text;
		this.answers = answers;
		this.correctAnswerIndex = correctAnswerIndex;
		this.teacherComposed = teacherComposed;
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
	
	
}

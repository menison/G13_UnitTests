package logics;

import java.util.ArrayList;

import entities.ExecutedTest;
import entities.Question;

public class TestChecker {
	public int checkTest(ExecutedTest toCheck) {
		int grade = 0;
		ArrayList<Question> questions = toCheck.getTest().getQuestions();	
		int[] answersToCheck = toCheck.getAnswers();
		String[] pointsDistribution = toCheck.getTest().getPointDistribution();
		
		for (int i=0; i < questions.size(); i++) {
			int correctAnswerIndex = questions.get(i).getCorrectAnswerIndex();
			if (answersToCheck[i] == correctAnswerIndex)
				grade += Integer.parseInt(pointsDistribution[i]);
		}
		
		return grade;
	}
}

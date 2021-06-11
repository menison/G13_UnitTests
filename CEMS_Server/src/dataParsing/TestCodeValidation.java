package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.Query;
import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;
import entities.Question;
import entities.Test;

public class TestCodeValidation {
	public static Message validateTestCode(Message object) {
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		String toSplit = (String)object.getObj();
		String[] splitted = toSplit.split(",");
		String desiredTestToValidate = splitted[0];
		String studentExecuting = splitted[1];
		Message messageToReturn;
		ExecutedTest execTest;
		ArrayList<Question> questions;
		
		try {
			stmt = con.createStatement();
			rs = Query.getTestByExecutionCode(desiredTestToValidate);

		while (rs.next())
		{
			String testID = rs.getString(1);
			String questionText = null, commentsForStudents = rs.getString(4);
			String commentsForTeachers = rs.getString(5);
			int correctAnswerIndex = -1;
			int allocatedDuration = rs.getInt(3);
			int isActivated = rs.getInt(8);
			String[] answers = null;
			String[] arr = rs.getString(2).split(",");
			questions = new ArrayList<Question>();
			String[] pointsDistribution = rs.getString(7).split(",");
			String teacherComposed = rs.getString(9);
			
			for (int i=0; i<arr.length; i++)
			{
				ResultSet questionTuple = Query.getQuestionByID(arr[i]);
				while (rs.next()) {
					questionText = questionTuple.getString(2);
					answers = questionTuple.getString(3).split(",");
					correctAnswerIndex = questionTuple.getInt(4);
				}
					
				Question qToAdd = new Question(arr[i], questionText, answers, correctAnswerIndex,
						teacherComposed);
				questions.add(qToAdd);
			}
			 
			Test testInExecution = new Test(questions, testID, allocatedDuration, commentsForStudents, 
					commentsForTeachers, desiredTestToValidate, pointsDistribution, isActivated, 
					teacherComposed);
			
			execTest = new ExecutedTest(testInExecution, desiredTestToValidate, null, studentExecuting,
					0, null, null);
		}
			rs.close();
			.TestCodeValidation. messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error validating TestCode");
			e.printStackTrace();
		}
		return null;
	}
}

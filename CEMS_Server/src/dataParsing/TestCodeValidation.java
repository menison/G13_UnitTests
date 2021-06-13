package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Operation;
import common.Permission;
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
		String desiredTestToValidate= splitted[0];
		String studentExecuting = splitted[1];
		ExecutedTest execTest;
		ArrayList<Question> questions;
		Message messageToReturn;
		
		try {
			stmt = con.createStatement();
			rs = Query.getTestByExecutionCode(desiredTestToValidate);
			if (!rs.next()) {
				return new Message(Operation.SendTestCode, "false");
			}
			//rs.next();
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
			String teacherComposedTest = rs.getString(9);
			System.out.println("Finished reading from rs");
			for (int i=0; i<arr.length; i++)
			{
				ResultSet questionTuple = Query.getQuestionByID(arr[i]);
				questionTuple.next(); 
				questionText = questionTuple.getString(2);
				answers = questionTuple.getString(3).split(",");
				correctAnswerIndex = questionTuple.getInt(4);
				String teacherComposedQuestion = questionTuple.getString(5);
				Question qToAdd = new Question(arr[i], questionText, answers, correctAnswerIndex,
						teacherComposedQuestion);
				questions.add(qToAdd);
			}
			 
			Test testInExecution = new Test(questions, testID, allocatedDuration, commentsForStudents, 
					commentsForTeachers, desiredTestToValidate, pointsDistribution, isActivated, 
					teacherComposedTest);
			
			execTest = new ExecutedTest(testInExecution, desiredTestToValidate, null, studentExecuting,
					0, null, null);
			execTest.setComposedBy(teacherComposedTest);
			rs.close();
			messageToReturn = new Message(Operation.SendTestCode, execTest);
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error validating TestCode");
			e.printStackTrace();
		}
		return null;
	}
	public static String getExecTestStr(ExecutedTest test) {
		String str = new String();
		
		return str;
	}
}

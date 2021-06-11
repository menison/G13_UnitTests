package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;
import entities.Question;
import entities.Test;
import gui.ServerController;

public class TestCodeValidation {
	public static Message validateTestCode(Message object) {
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		String desiredTestToValidate = (String) object.getObj();
		Message messageToReturn;
		ExecutedTest execTest;
		ArrayList<Question> questions;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test WHERE isActivated = true AND"
					+ " currExecutionCode= " + desiredTestToValidate + ";");
			ServerController.sc.addToTextArea("Validating test code.");

			System.out.println("Success setting table");

		while (rs.next())
		{
			String testID = rs.getString(1);
			String[] arr= rs.getString(2).split(",");
			questions = new ArrayList<Question>();
			for (int i=0; i<arr.length; i++)
			{
				Question qToAdd = new Question(arr[i], getQuestionText(), arr, i);
				questions.add(qToAdd);
			}
			Test testInExecution = new Test(null, desiredTestToValidate, 0, desiredTestToValidate, desiredTestToValidate, desiredTestToValidate, null, false);
			execTest = new ExecutedTest(testInExecution, desiredTestToValidate, null, studentExecuting,
					0, null, null);
		}
			rs.close();
			//return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error validating TestCode");
			e.printStackTrace();
		}
		return null;
	}
}

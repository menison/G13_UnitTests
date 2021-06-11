package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Operation;
import database.SetConnectionDB;
import entities.ExecutedTest;
import entities.Message;
import gui.ServerController;

public class TestCodeValidation {
	public static Message validateTestCode(Message object) {
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		String desiredTestToValidate = (String) object.getObj();
		Message messageToReturn;
		ExecutedTest execTest;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test WHERE isActivated = true AND"
					+ " currExecutionCode= " + desiredTestToValidate + ";");
			ServerController.sc.addToTextArea("Validating test code.");

			System.out.println("Success setting table");

		while (rs.next())
		{
			//execTest = new ExecutedTest(rs.getString(1),  );
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

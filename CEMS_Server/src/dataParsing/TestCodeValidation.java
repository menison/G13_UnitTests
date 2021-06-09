package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Operation;
import database.SetConnectionDB;
import entities.Message;

import gui.ServerController;

public class TestCodeValidation {
	public static Message validateTestCode(Message object) {
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		String desiredTestToValidate = (String) object.getObj();
		Message messageToReturn;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT test.currExecutionCode FROM test WHERE isActivated = true AND"
					+ " currExecutionCode= " + desiredTestToValidate + ";");
			ServerController.sc.addToTextArea("Validating test code.");

			System.out.println("Success setting table");

			if (rs.getString(1) != null)
				messageToReturn = new Message(Operation.SendTestCode, "false");
			else
				messageToReturn = new Message(Operation.SendTestCode, "true");
			rs.close();
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error validating TestCode");
			e.printStackTrace();
		}
		return null;
	}
}

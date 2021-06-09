package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		ArrayList<Object> tuple = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test WHERE isActivated = true AND"
					+ " currExecutionCode= " + desiredTestToValidate + ";");
			ServerController.sc.addToTextArea("Validating test code.");

			System.out.println("Success setting table");

			
			if (rs.getString(1) != null) //figure out which coloumn contains currExecCode
			{
				for (int i=1; i< numOfTuples; i++)
					tuple.add(rs.getString(i));
			
				messageToReturn = new Message(Operation.SendTestCode, tuple);
			}
			else
				messageToReturn = new Message(Operation.SendTestCode, "false");
			rs.close();
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error validating TestCode");
			e.printStackTrace();
		}
		return null;
	}
}

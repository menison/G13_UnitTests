package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Operation;
import database.SetConnectionDB;
import entities.Message;
import entities.TestForFullTable;
import gui.ServerController;

public class GetFullTestTable {
	
	public static Message getTestTable(Message object) {
		//ArrayList<Object> arrayToSend = new ArrayList<>();
		ArrayList<TestForFullTable> testList;
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		TestForFullTable t;
		testList = new ArrayList<TestForFullTable>();
		String returnStr = "";
		Message messageToReturn;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Tests;");
			ServerController.sc.addToTextArea("Fetching tests");
			//arrayToSend.add(Convert.FromResultsetToExecutedTest(rs));
			while (rs.next()) {
				t = new TestForFullTable(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getString(5));
				testList.add(t);
			}
			System.out.println("Success setting table");
			rs.close();
			for(int i = 0; i < testList.size();i++) {
				returnStr += testList.get(i);
				returnStr += "/";
			}
			//arrayToSend.add(testList);
			//return new Message(Operation.GetTestTable,arrayToSend);
			messageToReturn = new Message(Operation.GetFullTestTable,returnStr);
			//return new Message(Operation.GetTestTable,testList);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
}

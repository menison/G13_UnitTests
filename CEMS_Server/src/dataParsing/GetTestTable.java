package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Operation;
import database.SetConnectionDB;
import entities.Message;
import entities.TestForTable;
import gui.ServerController;

public class GetTestTable {
	
	public static Message getTestTable(Message object) {
		ArrayList<Object> arrayToSend = new ArrayList<>();
		ArrayList<TestForTable> testList;
		String studentID = (String)object.getObj();
		Statement stmt;
		ResultSet rs;
		Connection con = SetConnectionDB.start();
		TestForTable t;
		testList = new ArrayList<TestForTable>();
		String returnStr = "";
		Message messageToReturn;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM executedtest WHERE ExecutedBy = "+ studentID + ";");
			ServerController.sc.addToTextArea("Fetching executed tests");
			while (rs.next()) {
				t = new TestForTable(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getInt(5),rs.getInt(6));
				testList.add(t);
			}
			if(testList.size() == 0)
				return new Message(Operation.GetTestTable,"no content");
			System.out.println("Success setting table");
			rs.close();
			messageToReturn = new Message(Operation.GetTestTable,testList);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	
}
package dataParsing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Operation;
import database.Query;
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
		String composer;
		ResultSet field;
		ResultSet course;
		Connection con = SetConnectionDB.start();
		
		TestForFullTable t;
		testList = new ArrayList<TestForFullTable>();
		String returnStr = "";
		Message messageToReturn;
		try {
			rs = Query.SelectFullTable("Test");
			ServerController.sc.addToTextArea("Fetching tests");
			//arrayToSend.add(Convert.FromResultsetToExecutedTest(rs));
			while (rs.next()) {
			composer=Query.getFullNameByID(rs.getString(9));
			
				
				// TestForFullTable(String testID,String subject,String course,int duration,String composer,composerID)
				t = new TestForFullTable(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),composer);
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

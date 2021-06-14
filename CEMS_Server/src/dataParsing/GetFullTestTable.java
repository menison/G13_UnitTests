package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import common.Operation;
import database.Query;
import entities.Message;
import entities.TestForFullTable;
import gui.ServerController;

public class GetFullTestTable {
	
	public static Message getTestTable(Message object) {
		//ArrayList<Object> arrayToSend = new ArrayList<>();
		ArrayList<TestForFullTable> testList;
		Statement stmt;
		ResultSet rs;
		ResultSet rs2;
		String composer;
		String courseName;
		String fieldName;
		TestForFullTable t;
		testList = new ArrayList<TestForFullTable>();
		String returnStr = "";
		Message messageToReturn;
		try {
			rs = Query.getTestListForTeacherFullTable();
			ServerController.sc.addToTextArea("Fetching tests");
			
			while (rs.next()) {

			fieldName=rs.getString(2);
			courseName=rs.getString(3);
			composer=rs.getString(6)+" "+rs.getString(5);
				// TestForFullTable(String testID,String subject,String course,int duration,String composer,composerID)
				t = new TestForFullTable(rs.getString(1),fieldName,courseName,
						rs.getInt(4),composer);
				testList.add(t);
			}
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
			e.printStackTrace();
		}
		return null;
	}
}

package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import common.Operation;
import database.Query;
import entities.Message;
import gui.ServerController;

public class TeacherGetAllSelfExecutedTests {
	public static Message getAllSelfExecutedTests(Message msg) {
		String executedExams = "";
		String query = null;
		String teacherID = (String) msg.getObj();
		query = "SELECT testID FROM ExecutedTest WHERE ComposedBy = " +  teacherID + " GROUP BY testID;";
		ResultSet rs;
		Message messageToReturn;
		try {	
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Fetching testID of : " + teacherID);
			while (rs.next()) {
				executedExams+= rs.getString(1)+";";
			}
			rs.close();
			messageToReturn = new Message(Operation.GetTestsForTeacherReport,executedExams);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}

}

package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Message;
import gui.ServerController;

public class PrincipalGetReport {
	public static Message getReport(Message msg) {
		
		String query = null;
		String generetaedBy = ((String) msg.getObj()).split("_")[0];
		String generetaedValue = ((String) msg.getObj()).split("_")[1];
		switch(generetaedBy) {
		case "Student":
				query = "SELECT Grade FROM ExecutedTest WHERE ExecutedBy = " +  generetaedValue + ";";
			break;
		case "Course":
				query = "SELECT Grade FROM ExecutedTest WHERE testID LIKE " +  "'" + generetaedValue +"%' ;";
			break;
		case "Teacher":
				query = "SELECT Grade FROM ExecutedTest WHERE ComposedBy = " +  generetaedValue + ";";
			break;
		case "Test":
			query = "SELECT Grade FROM ExecutedTest WHERE testID = " + generetaedValue +";";
		break;
		}
		ArrayList<String> gradesList;
		ResultSet rs;
		gradesList = new ArrayList<String>();
		gradesList.add(generetaedBy);
		gradesList.add(generetaedValue);
		Message messageToReturn;
		try {	
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Fetching grades of : " + generetaedBy + " " + generetaedValue);
			while (rs.next()) {
				gradesList.add(rs.getString(1));
			}
			rs.close();
			messageToReturn = new Message(Operation.GetReport,gradesList);
			return messageToReturn;
		} catch	(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
}

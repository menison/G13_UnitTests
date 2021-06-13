package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Operation;
import database.Query;
import entities.Extension;
import entities.Message;
import gui.ServerController;

public class PrincipalGetExtentionRequests {
	public static Message getExtensions(Message msg) {
		ArrayList<Extension> extensions = new ArrayList<Extension>();
		String query = null;
		query = "SELECT * FROM extensionrequest;";
		ResultSet rs;
		Message messageToReturn;
		try {
			rs = Query.getReport(query);
			ServerController.sc.addToTextArea("Fetching Extensions");
			while (rs.next()) {
				Extension extension = new Extension(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getInt(6),rs.getInt(5));
				extensions.add(extension);
			}
			rs.close();
			messageToReturn = new Message(Operation.GetExtensionRequests, extensions);
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	public static Message principalApproveRequests(Message msg) {
		String testCode = ((String) msg.getObj()).split("_")[0];
		String newDuration = ((String) msg.getObj()).split("_")[1];
		Query.update("UPDATE `query`.`extensionrequest` SET `isAuthorized` = 1 WHERE (`TestCode` = '" + testCode + "');");
		Query.update("UPDATE `query`.`activatedtest` SET `duration` = "+ newDuration +" WHERE (`code` = '"+testCode+"');");
		ServerController.sc.addToTextArea("Update duration for exam" + testCode + " to " + newDuration);
		return new Message(Operation.ApproveExtensionRequests, "done");
	}
	public static Message principalDeclineRequests(Message msg) {
		String testCode = (String) msg.getObj();
		Query.update("UPDATE `query`.`extensionrequest` SET `isAuthorized` = 0 WHERE (`TestCode` = '" + testCode + "');");
		ServerController.sc.addToTextArea("Ignore extention for " + testCode );
		return new Message(Operation.DeclineExtensionRequests, "done");
	}

}

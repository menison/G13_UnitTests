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
						rs.getString(4), rs.getInt(5),rs.getInt(6));
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

}

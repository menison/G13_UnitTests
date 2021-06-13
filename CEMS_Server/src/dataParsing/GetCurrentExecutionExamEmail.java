package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

public class GetCurrentExecutionExamEmail {

	public static Message getComposerEmail(Message object) {
		String composerId = (String)object.getObj();
		String email = null;
		ResultSet rs = Query.getEmailByComposerId(composerId);
		try {
			rs.next();
			email = rs.getString(6);
		} catch (SQLException e) {}
		return new Message(Operation.getInstructionsAndMail,email);
	}
}

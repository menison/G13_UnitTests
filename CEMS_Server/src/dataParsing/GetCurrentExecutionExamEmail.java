package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

/**
 * This class is responsible for reading the test's composer email from the DB and delivering
 * it on to the client-side.
 *
 */
public class GetCurrentExecutionExamEmail {

	/**
	 * This method is responsible for retrieving an email address of the composer of a test;
	 * @param object containing the composer's ID.
	 * @return Message containing the relevant email.
	 */
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

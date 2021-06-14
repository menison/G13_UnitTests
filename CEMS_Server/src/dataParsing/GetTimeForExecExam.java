package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

/**
 * This class is responsible for retrieving start time of a test from the DB, given
 * the test's execution code sent from the client.
 *
 */
public class GetTimeForExecExam {
	
	/**
	 * This method is responsible for retrieving what is the start time of a given test
	 * @param object
	 * @return a message containing the desired time.
	 */
	public static Message getTime(Message object) {
		String executionCode = (String)object.getObj();
		String TimeToReturn = new String();
		ResultSet rs = Query.getActivatedTestByExecutionCode(executionCode);
		try {
			rs.next();
			TimeToReturn = rs.getString(5);
			rs.close();
		} catch (SQLException e) {}
		return new Message(Operation.getTimeForActiveExam,TimeToReturn);
	}
}

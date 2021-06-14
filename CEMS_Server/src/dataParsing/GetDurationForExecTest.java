package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

/**
 * This class is responsible for getting the duration of a test by its' execution code.
 */
public class GetDurationForExecTest {
	/**
	 * This method is responsible for retrieving the duration of a given test by its'
	 * execution code.
	 * @param object containing the test's execution code.
	 * @return message containing the test's fresh duration from the DB.
	 */
	public static Message getDuration(Message object) {
		String execCode = (String)object.getObj();
		int durationToReturn = 0;
		ResultSet rs = Query.getActivatedTestByExecutionCode(execCode);
		try {
			rs.next();
			durationToReturn = rs.getInt(9);
		} catch (SQLException e) {}
		return new Message(Operation.GetTimeForTestInExecution,durationToReturn);
	}
}

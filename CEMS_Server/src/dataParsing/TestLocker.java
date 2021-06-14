package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

/**
 * This class is responsible for locking a test from server side.
 *
 */
public class TestLocker {

	/**
	 * This method will lock a test if he is activated and a test with the given
	 * execution code exists. it will update the client according to success or failure of the 
	 * operation.
	 * @param receivedMessage
	 * @return
	 */
	public static Message lock(Message receivedMessage) {
		String testCode = (String) receivedMessage.getObj();
		ResultSet rs = Query.getLiveTestByExecutionCode(testCode);
		try {
			if (!rs.next())
				return new Message(Operation.LockTest,"false");
			else {
				Query.updateIsActivated(testCode);
				return new Message(Operation.LockTest, "true");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Message(Operation.LockTest,testCode);
	}

}

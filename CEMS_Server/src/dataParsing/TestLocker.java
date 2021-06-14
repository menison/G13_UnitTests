package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

public class TestLocker {

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

package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

public class GetDurationForExecTest {
	public static Message getDuration(Message object) {
		String execCode = (String)object.getObj();
		int durationToReturn = 0;
		ResultSet rs = Query.getTestByExecutionCode(execCode);
		try {
			rs.next();
			durationToReturn = rs.getInt(3);
		} catch (SQLException e) {}
		return new Message(Operation.GetTimeForTestInExecution,durationToReturn);
	}
}

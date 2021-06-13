package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

public class GetTimeForExecExam {
	
	public static Message getTime(Message object) {
		String executionCode = (String)object.getObj();
		String DateToReturn = new String();
		ResultSet rs = Query.getActivatedTestByExecutionCode(executionCode);
		try {
			rs.next();
			DateToReturn = rs.getString(5);
			rs.close();
		} catch (SQLException e) {}
		return new Message(Operation.getTimeForActiveExam,DateToReturn);
	}
}

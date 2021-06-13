package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;

public class CheckIfTestIsLocked {
	
	public static Message checkForLockedTest(Message object) {
		String testCode = (String)object.getObj();
		int isActive = 0;
		ResultSet rs = Query.getActivatedTestsByCode(testCode);
		try {
			rs.next();
			isActive = rs.getInt(6);
		} catch (SQLException e) {}
		return new Message(Operation.CheckIfTestIsLocked,isActive);
	}
}

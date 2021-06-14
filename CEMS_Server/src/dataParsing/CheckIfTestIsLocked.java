package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;


/**Class for checking if a test is currently locked by using the the test execution code.
 * @author Aviv
 *
 */
public class CheckIfTestIsLocked {
	
	/**Method to check if a test is locked.
	 * @param object Message containing the operation name and the test code.
	 * @return returns a message containing the operaiont name and the isActive parameter which indicates if the test is locked.
	 */
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

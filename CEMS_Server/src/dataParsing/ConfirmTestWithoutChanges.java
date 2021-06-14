package dataParsing;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;

/**Class for confirming a test without changing the grade or any other information.
 * @author Aviv
 *
 */
public class ConfirmTestWithoutChanges {

	/**Method for confirming a test grade without changing it.
	 * @param receivedMessage Message containing the operation name and the test entity.
	 * @return returns a message with the operation name and a confirmation string.
	 */
	public static Message executeUpdate(Message receivedMessage) {
		TestToConfirm ttc = (TestToConfirm) receivedMessage.getObj();
		String executedBy = ttc.getExecutedBy();
		String testCode = ttc.getTestCode();
		int isSuccess = Query.updateIsAuthorized(testCode, executedBy);
		
		if (isSuccess != 0)
			return new Message(Operation.ConfirmTestWithoutChanges, "success");
		
		return new Message(Operation.ConfirmTestWithoutChanges, "fail");
	}
		
}

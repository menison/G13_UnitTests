package dataParsing;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;


/**Class for test grade confirmation by the teacher.
 * @author Aviv
 *
 */
public class ConfirmTestChangeGrade {

	/**Method that responsible for test grade confirmation by the teacher.
	 * @param receivedMessage Message containing the operation name and the test entity.
	 * @return returns a message with the operation name and a sucess/fail srting.
	 */
	public static Message executeUpdate(Message receivedMessage) {
		
		TestToConfirm ttc = (TestToConfirm) receivedMessage.getObj();
		String executedBy = ttc.getExecutedBy();
		String testCode = ttc.getTestCode();
		int newGrade = ttc.getGrade();
		int isSuccess = Query.confirmAndChangeGrade(newGrade, executedBy, testCode);
		
		if (isSuccess != 0)
			return new Message(Operation.ConfirmTestWithChanges, "success");
		
		return new Message(Operation.ConfirmTestWithChanges, "fail");
	}

}

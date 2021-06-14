package dataParsing;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;

public class ConfirmTestWithoutChanges {

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

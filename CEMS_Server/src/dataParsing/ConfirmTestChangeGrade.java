package dataParsing;

import common.Operation;
import database.Query;
import entities.Message;
import entities.TestToConfirm;

public class ConfirmTestChangeGrade {

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

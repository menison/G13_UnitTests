package dataParsing;

import common.Operation;
import database.Query;
import entities.Message;

public class ConfirmTestWithoutChanges {

	public static Message executeUpdate(Message receivedMessage) {
		int isSuccess = Query.updateIsAuthorized();
		
		if (isSuccess != 0)
			return new Message(Operation.ConfirmTestWithoutChanges, "success");
		
		return new Message(Operation.ConfirmTestWithoutChanges, "fail");
	}
		
}

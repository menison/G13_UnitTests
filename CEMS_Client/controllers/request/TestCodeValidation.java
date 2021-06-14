package request;

import cachedUserData.DataManager;
import entities.ExecutedTest;
import entities.Message;

public class TestCodeValidation {

	/**
	 * This method sets the current executed test for student if the test code is correct
	 * @param receivedMessage
	 */
	public static void informUser(Message receivedMessage) {
		
		if (receivedMessage.getObj() == "false") {
			DataManager dm = DataManager.getDataManager();
			dm.setTestInExecution(null);
		}
		else
		{
			DataManager dm = DataManager.getDataManager();
			ExecutedTest testInExecution = (ExecutedTest)receivedMessage.getObj();
			dm.setTestInExecution(testInExecution);
		}

	}

}

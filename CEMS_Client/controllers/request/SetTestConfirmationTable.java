package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestToConfirm;

public class SetTestConfirmationTable {

	/**
	 * This methods receives from the server all the tests that require grade confirmation
	 * @param receivedMessage
	 */
	public static void set(Message receivedMessage) {
		ArrayList<TestToConfirm> testList = (ArrayList<TestToConfirm>) receivedMessage.getObj();
		DataManager dm = DataManager.getDataManager();
		if(testList == null) {
			dm.setTestsToConfirm(null);
			return;
		}
		dm.setTestsToConfirm(testList);
	}

}

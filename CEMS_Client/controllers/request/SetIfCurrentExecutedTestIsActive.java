package request;

import cachedUserData.DataManager;
import entities.Message;

public class SetIfCurrentExecutedTestIsActive {
	/**
	 * This method sets the active indication so the system knows if to lock the test during execution
	 * @param msg
	 */
	public static void setActive(Message msg) {
		int isActive = (int)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().getTest().setActivated(isActive);
	}
}

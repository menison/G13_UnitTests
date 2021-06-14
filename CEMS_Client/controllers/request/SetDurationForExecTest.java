package request;

import cachedUserData.DataManager;
import entities.Message;

public class SetDurationForExecTest {
	
	/**
	 * This method sets time for an exam that is currently executed, this will be used
	 * to check if there have been any time extensions
	 * @param msg
	 */
	public static void setDuration(Message msg) {
		int timeFromServer = (int)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().getTest().setAllocatedDuration(timeFromServer);
	}
}

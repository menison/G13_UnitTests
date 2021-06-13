package request;

import cachedUserData.DataManager;
import entities.Message;

public class SetIfCurrentExecutedTestIsActive {
	public static void setActive(Message msg) {
		int isActive = (int)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().getTest().setActivated(isActive);
	}
}

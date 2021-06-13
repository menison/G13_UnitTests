package request;

import cachedUserData.DataManager;
import entities.Message;

public class SetDurationForExecTest {
	
	public static void setDuration(Message msg) {
		int timeFromServer = (int)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.getTestInExecution().getTest().setAllocatedDuration(timeFromServer);
	}
}

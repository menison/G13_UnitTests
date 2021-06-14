package request;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForRequestedTest;

public class SetRequestedTest {
	
	public static void setTest(Message msg) {
		TestForRequestedTest t = (TestForRequestedTest)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setReviewTest(t);
	}
}

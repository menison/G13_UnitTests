package request;

import cachedUserData.DataManager;
import entities.Message;
import entities.TestForRequestedTest;

public class SetRequestedTest {
	
	/**
	 * This method sets a test in the DataManager that the student requested to review
	 * @param msg
	 */
	public static void setTest(Message msg) {
		TestForRequestedTest t = (TestForRequestedTest)msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setReviewTest(t);
	}
}

package request;

import cachedUserData.DataManager;
import entities.Message;

public class GetCurrentExecEmail {
	
	/**
	 * This method receives the email of the teacher who wrote the exam that is currently beeing
	 * executed by student
	 * @param receivedMessage
	 */
	public static void setEmail(Message receivedMessage) {
		String email = (String)receivedMessage.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setCurrentExecEmail(email);
	}
}

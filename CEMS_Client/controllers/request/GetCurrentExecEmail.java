package request;

import cachedUserData.DataManager;
import entities.Message;

public class GetCurrentExecEmail {
	
	public static void setEmail(Message receivedMessage) {
		String email = (String)receivedMessage.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setCurrentExecEmail(email);
	}
}

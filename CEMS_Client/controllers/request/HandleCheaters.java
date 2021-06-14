package request;

import java.util.HashSet;

import cachedUserData.DataManager;
import entities.Message;

public class HandleCheaters {

	public static void handle(Message receivedMessage) {
		HashSet<String> cheaters = (HashSet<String>) receivedMessage.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setSuspectsForFraud(cheaters);
	}

}

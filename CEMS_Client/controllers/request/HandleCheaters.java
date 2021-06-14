package request;

import java.util.HashSet;

import cachedUserData.DataManager;
import entities.Message;

/**
 * @author David
 *	class to handle cheaters
 */
public class HandleCheaters {

	/** hjandles chater
	 * @param receivedMessage			Hashset of cheaters
	 */
	public static void handle(Message receivedMessage) {
		HashSet<String> cheaters = (HashSet<String>) receivedMessage.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setSuspectsForFraud(cheaters);
	}

}

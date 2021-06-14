package request;

import cachedUserData.DataManager;
import entities.Message;

/**	class HandleActivateStatus
 * @author David
 *	this class handles messages from server with fail and success scenarios 
 */
public class HandleActivateStatus {

	/**
	 * @param msag			message that holds a String as a message from server
	 * msag comes from server and this method is a used when message is success
	 */
	public  static void activateSuccess(Message msag) {
		String msg = (String)msag.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setActivateSuccess(true);
		dm.setActivateMsg(msg);
	}
	/**
	 * @param msag			message that holds a String as a message from server
	 * msag comes from server and this method is a used when message is failed
	 */
	public  static void activateFailed(Message msag) {
		String msg = (String)msag.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setActivateSuccess(false);
		dm.setActivateMsg(msg);
	}
}

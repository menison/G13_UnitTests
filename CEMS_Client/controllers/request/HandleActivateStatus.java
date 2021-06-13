package request;

import cachedUserData.DataManager;
import entities.Message;

public class HandleActivateStatus {

	public  static void activateSuccess(Message msag) {
		String msg = (String)msag.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setActivateSuccess(true);
		dm.setActivateMsg(msg);
	}
	public  static void activateFailed(Message msag) {
		String msg = (String)msag.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setActivateSuccess(false);
		dm.setActivateMsg(msg);
	}
}

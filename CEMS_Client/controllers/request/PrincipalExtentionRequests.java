package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Extension;
import entities.Message;
@SuppressWarnings("unchecked")

public class PrincipalExtentionRequests {
	public static void principalSetExtentionRequests(Message receivedMessage) {
		ArrayList<Extension> extensions = (ArrayList<Extension>) receivedMessage.getObj();
		DataManager.getDataManager().setExtensionRequests(extensions);
	}
	public static void principalApproveExtentionRequests(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setActivateMsg(msg);
	}
	public static void principalDeclineExtentionRequests(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setActivateMsg(msg);
	}

}

package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Extension;
import entities.Message;
@SuppressWarnings("unchecked")

public class PrincipalExtentionRequests {
	/**
	 * This method sets the extension requests by teachers for the principal
	 * @param receivedMessage
	 */
	public static void principalSetExtentionRequests(Message receivedMessage) {
		ArrayList<Extension> extensions = (ArrayList<Extension>) receivedMessage.getObj();
		DataManager.getDataManager().setExtensionRequests(extensions);
	}
	/**
	 * This method notifies user if extension request has been approved successfully
	 * @param receivedMessage
	 */
	public static void principalApproveExtentionRequests(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setActivateMsg(msg);
	}
	/**
	 * This method notifies user if extension request has been declined successfully
	 * @param receivedMessage
	 */
	public static void principalDeclineExtentionRequests(Message receivedMessage) {
		String msg = (String) receivedMessage.getObj();
		DataManager.getDataManager().setActivateMsg(msg);
	}

}

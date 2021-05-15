package request;

import cachedUserData.DataManager;
import application.ClientUI;
import entities.Message;

/**
 * @author avivs100
 *	The master class for all controllers designed to transfer 
 *  information between the user and the server
 */
public abstract class AbstractController {
	public static DataManager dataManager = DataManager.getDataManager();

	public AbstractController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void SendToServer(Message msg) { 
		ClientUI.chat.accept(msg);
	}

}

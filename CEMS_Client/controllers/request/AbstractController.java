package request;

import cachedUserData.DataManager;
import application.ClientUI;
import entities.Message;


/**Abstract class with the purpose of sending information to the server
 * @author Aviv
 *
 */
public abstract class AbstractController {
	public static DataManager dataManager = DataManager.getDataManager();

	public AbstractController() {
	
	}
	
	public static void SendToServer(Message msg) { 
		ClientUI.chat.accept(msg);
	}

}

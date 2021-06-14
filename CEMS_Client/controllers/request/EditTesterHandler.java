package request;

import cachedUserData.DataManager;
import entities.Message;
import entities.Test;

/**Class EditTesterHandler
 *@author David
 *class that handles requests for editTestController
 */

public class EditTesterHandler {

	/**Add to data base
	 * @param msg			this msg holds a Test object
	 * 
	 * test object from msg is moved to data manager
	 */
	public static void addToDB(Message msg) {
		Test test = (Test)msg.getObj();
		
		DataManager.getDataManager().setTest(test);
		
	}

	/** gets message from server to data manager
	 * @param msg			message holds String from server which is moved to data manager
	 */
	public static void getMsg(Message msg) {
		String str = (String)msg.getObj();
		
		DataManager.getDataManager().setActivateMsg(str);
		
		}

}

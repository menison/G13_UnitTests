package request;

import cachedUserData.DataManager;
import entities.Message;
import entities.Test;

public class EditTesterHandler {
	
	public static void addToDB(Message msg) {
		Test test = (Test)msg.getObj();
		
		DataManager.getDataManager().setTest(test);
		
	}

}

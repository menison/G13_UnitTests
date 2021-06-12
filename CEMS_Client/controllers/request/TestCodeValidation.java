package request;

import cachedUserData.DataManager;
import entities.ExecutedTest;
import entities.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestCodeValidation {

	public static void informUser(Message receivedMessage) {
		
		if (receivedMessage.getObj() == "false") {
			DataManager dm = DataManager.getDataManager();
			dm.setTestInExecution(null);
		}
		else
		{
			DataManager dm = DataManager.getDataManager();
			ExecutedTest testInExecution = (ExecutedTest)receivedMessage.getObj();
			dm.setTestInExecution(testInExecution);
		}

	}

}

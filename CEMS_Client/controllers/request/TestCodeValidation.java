package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.Message;
import entities.Test;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestCodeValidation {

	public static void informUser(Message receivedMessage) {
		ArrayList<Object> tuple = (ArrayList<Object>) receivedMessage.getObj();
		Test executed = new Test(tuple.get(1), tuple.get(2), tuple.get(3), tuple.get(4),
				tuple.get(5), tuple.get(6), tuple.get(7), tuple.get(8));
		if (receivedMessage.getObj() == "false") {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Test code is not valid.");
			alert.showAndWait();
		}
		else
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Test code is valid, let's continue!");
			alert.showAndWait();
			Test executed = new Test();
		}
		DataManager dm = DataManager.getDataManager();
		T
		dm.getTestIn
	}

}

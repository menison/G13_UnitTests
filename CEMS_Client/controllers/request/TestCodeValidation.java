package request;

import java.util.ArrayList;

import cachedUserData.DataManager;
import entities.ExecutedTest;
import entities.Message;
import entities.Test;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestCodeValidation {

	public static void informUser(Message receivedMessage) {
		ArrayList<Object> tuple = (ArrayList<Object>) receivedMessage.getObj();
		
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
			ExecutedTest executed = new ExecutedTest(null, null, 0, null, null, null, null, false);
		}

	}

}

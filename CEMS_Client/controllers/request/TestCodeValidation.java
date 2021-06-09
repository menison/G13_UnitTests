package request;

import entities.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestCodeValidation {

	public static void informUser(Message receivedMessage) {
		
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
		}
	}

}

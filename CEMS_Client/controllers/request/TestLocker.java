package request;

import entities.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestLocker {

	/**
	 * This method notifies the user if test lock has been performed successfully
	 * @param receivedMessage
	 */
	public static void informUser(Message receivedMessage) {
		String res = (String) receivedMessage.getObj();
		switch (res) {
		case "false":
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(res);
			alert.showAndWait();
			break;
		case "true":
			Alert alert2 = new Alert(AlertType.CONFIRMATION);
			alert2.setContentText(res);
			alert2.showAndWait();
			break;
		}

	}

}

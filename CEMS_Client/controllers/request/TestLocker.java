package request;

import entities.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TestLocker {

	public static void informUser(Message receivedMessage) {
		String res = (String) receivedMessage.getObj();
		switch (res) {
		case "false":
			System.out.println("WALLAK FALSE");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(res);
			alert.showAndWait();
			break;
		case "true":
			System.out.println("WALLAK TRUE");
			Alert alert2 = new Alert(AlertType.CONFIRMATION);
			alert2.setContentText(res);
			alert2.showAndWait();
			break;
		}

	}

}

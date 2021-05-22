package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooseTestTypeController {

	@FXML
	private Button chooseTestType_btnManual;

	@FXML
	private Button chooseTestType_btnComput;

	@FXML
	void openCompTest(ActionEvent event) {
		EnterStudentIdController esic = new EnterStudentIdController();
		Stage primaryStage = new Stage();
		esic.start(primaryStage);
	}

	@FXML
	void openManualTest(ActionEvent event) {
		ManualTestController mtc = new ManualTestController();
		Stage primaryStage = new Stage();
		mtc.start(primaryStage);
	}
	
}

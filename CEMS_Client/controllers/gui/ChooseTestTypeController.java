package gui;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseTestTypeController {

	@FXML
	private Button chooseTestType_btnManual;

	@FXML
	private Button chooseTestType_btnComput;

	@FXML
	void openCompTest(ActionEvent event) {
		openNewScene("/fxml/EnterStudentId.fxml", event);
	}

	@FXML
	void openManualTest(ActionEvent event) {
		ManualTestController mtc = new ManualTestController();
		Stage primaryStage = new Stage();
		mtc.start(primaryStage);
	}



}

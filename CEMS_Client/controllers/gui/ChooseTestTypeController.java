package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

	public void start(Stage primaryStage) throws Exception {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ChooseTestType.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Choose Test Type");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

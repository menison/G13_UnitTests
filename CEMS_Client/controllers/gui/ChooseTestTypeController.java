package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * A controller class handling the interaction with student in choose test type window.
 */
public class ChooseTestTypeController {

	@FXML
	private Button chooseTestType_btnManual;

	@FXML
	private Button chooseTestType_btnComput;

	/**
	 * This method will route the user to the take computerized test window.
	 * @param event - Computerized was clicked.
	 */
	@FXML
	void openCompTest(ActionEvent event) {
		EnterStudentIdController esic = new EnterStudentIdController();
		Stage primaryStage = new Stage();
		Stage stage = (Stage) chooseTestType_btnComput.getScene().getWindow();
		stage.close();
		esic.start(primaryStage);
		
	}

	/**
	 * This method will route the user to the take manual test window.
	 * @param event - Manual was clicked.
	 */
	@FXML
	void openManualTest(ActionEvent event) {
		ManualTestController mtc = new ManualTestController();
		Stage primaryStage = new Stage();
		Stage stage = (Stage) chooseTestType_btnComput.getScene().getWindow();
		stage.close();
		mtc.start(primaryStage);
		
	}

	/**
	 * Standard controller starting mechanism.
	 * @param primaryStage
	 * @throws Exception
	 */
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

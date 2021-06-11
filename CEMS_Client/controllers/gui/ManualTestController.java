package gui;

import java.io.File;
import java.io.IOException;
import com.jfoenix.controls.JFXTextField;
import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ManualTestController {

	private File SolutionFile;

	@FXML
	private Button manualTest_btnDownload;

	@FXML
	private Button manualTest_btnUpload;

	@FXML
	private ProgressIndicator manualTest_pieProgressIndicator;

	@FXML
	private JFXTextField manualTest_txtElapsedTime;

	@FXML
	private Button manualTest_btnSend;

	@FXML
    void downloadTest(ActionEvent event) {
		Stage stage = (Stage) manualTest_btnDownload.getScene().getWindow();
		FileChooser fc = new FileChooser();
		File f = fc.showSaveDialog(stage);
		ClientUI.chat.accept(new Message(Operation.DownloadManualTest, (Object)f));
		
		
    }

	@FXML
	void uploadTest(ActionEvent event) {
		Stage stage = (Stage) manualTest_btnUpload.getScene().getWindow();
		FileChooser fc = new FileChooser();
		SolutionFile = fc.showOpenDialog(stage);
		ClientUI.chat.accept(new Message(Operation.UploadManualTest, (Object)SolutionFile));
	}

	@FXML
	void sendManualTest(ActionEvent event) {
		ClientUI.chat.accept(new Message(Operation.UploadManualTest, (Object)SolutionFile));
		TestFinalController tfc = new TestFinalController();
		Stage primaryStage = new Stage();
		tfc.start(primaryStage);
	}

	public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ManualTest.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Manual Test");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

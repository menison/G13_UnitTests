package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
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
		Stage stage = new Stage();
		FileChooser fc = new FileChooser();
		File f = fc.showSaveDialog(stage);
		ClientUI.chat.accept(new Message(Operation.DownloadManualTest, (Object)f));
		
		
    }

	@FXML
	void uploadTest(ActionEvent event) {
		FileChooser fc = new FileChooser();
		SolutionFile = fc.showOpenDialog(null);
	}

	@FXML
	void sendManualTest(ActionEvent event) {
		ClientUI.chat.accept(new Message(Operation.UploadManualTest, (Object)SolutionFile));
	}

	public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ManualTest.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		primaryStage.setTitle("Manual Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

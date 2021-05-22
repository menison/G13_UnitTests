package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ManualTestController implements Initializable {

	private File SolutionFile;
	
	@FXML
	private ImageView cemsLogo;

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
		FileChooser fc = new FileChooser();
		File f = fc.showSaveDialog(null);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}

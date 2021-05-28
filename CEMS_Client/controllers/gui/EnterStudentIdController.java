package gui;

import java.io.IOException;
import java.util.Timer;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EnterStudentIdController {

    @FXML
    private Button testInfo_btnStartTest;

    @FXML
    private JFXTextField testInfo_txtEnterUserID;

    @FXML
    private JFXTextField testInfo_txtContactMail;

    @FXML
    private JFXTextArea testInfo_txtArea_testInstruc;

	public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EnterStudentId.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Computerized test - Enter ID");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void StartTest(ActionEvent event) {
    //create executed test instance
    	// open question form according to the kitzon case
    	
    }
	
}

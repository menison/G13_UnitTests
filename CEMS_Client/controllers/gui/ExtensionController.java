package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExtensionController {

    @FXML
    private JFXTextField extension_txtTimeExtension;
    
    @FXML
    private JFXTextArea extension_TextReason;
    @FXML
    
    private JFXButton extension_btnRqstExtension;

    @FXML
    private JFXButton extension_btnClose;

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) extension_btnClose.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void requestExtension(ActionEvent event) {
    	int time = 0;
    	try {
    		time = Integer.parseInt(extension_txtTimeExtension.getText());
    		
    	} catch (NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setContentText("Please use numbers only");
    		alert.showAndWait();
    		return;
    	}
    	String reason = extension_TextReason.getText();
    	DataManager.getDataManager().addToInfoExtension(time, reason, 1, -1);
		ClientUI.chat.accept(new Message(Operation.RequestExtension,DataManager.getDataManager().getExtension()));
    	
    }
	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/Extension.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Extension");
		newStage.setScene(scene);
		newStage.show();
	}
	
}

package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Extension;
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
    		warningPopUp("Please use numbers only");

    		return;
    	}
    	
    	String reason = extension_TextReason.getText();
    	Extension ex = DataManager.getDataManager().getExtension();
    	//	public Extension(String testCode, String requestedBy, int newDuration, String reason, int isRelevant,int isAuthorized) {
    	Extension exet = new Extension(ex.getTestCode(),ex.getRequestedBy(),ex.getNewDuration()+time,reason,1,-1);

		ClientUI.chat.accept(new Message(Operation.RequestExtension, exet));
		
		if(DataManager.getDataManager().isActivateSuccess()) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(DataManager.getDataManager().getActivateMsg());
			alert.showAndWait();
	    	Stage stage = (Stage) extension_btnRqstExtension.getScene().getWindow();
	    	stage.close();

		}
		else {
			warningPopUp(DataManager.getDataManager().getActivateMsg());
			}
    	
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
	
    public void warningPopUp(String warning) {   //warnings func
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(warning);

		alert.showAndWait();
    }
	
}

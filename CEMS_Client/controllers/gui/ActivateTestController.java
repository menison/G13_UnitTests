package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ActivateTestController {
	
    @FXML
    private JFXTextField ActivateTest_pinCodeField;

    @FXML
    private JFXButton ActivateTest_btnActivate;

    @FXML
    private JFXButton ActivateTest_btnClose;
    @FXML
    private Label errorTxt;
    

    
	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ActivateTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Activate test");
		newStage.setScene(scene);
		newStage.show();
	}
    @FXML
    void Activate(ActionEvent event) {
		DataManager dm = DataManager.getDataManager();
    	String[] toSend = new String[2];
    	String pinCode = ActivateTest_pinCodeField.getText();
    	if(pinCode.length()!=4) {
    		errorTxt.setText("Code must be 4 characters");
    		errorTxt.setVisible(true);
    	}
    	
    	else {
    	errorTxt.setVisible(false);
    	toSend[0]=pinCode;
    	toSend[1]=dm.getTestID();
    	}
    	
		ClientUI.chat.accept(new Message(Operation.ActivateTestCode,toSend));
    }

    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage stage = (Stage) ActivateTest_btnClose.getScene().getWindow();
    	stage.close();
    }
    

}

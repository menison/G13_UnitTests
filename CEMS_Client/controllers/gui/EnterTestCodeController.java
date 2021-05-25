package gui;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EnterTestCodeController {

    @FXML
    private Button EnterTestCode_btnSendCode;

    @FXML
    private JFXTextField EnterTestCode_txtCode;

    public String getTestCode() {
    	return EnterTestCode_txtCode.getText();
    }
    
    @FXML
    void SendTestCode(ActionEvent event) {
    	ClientUI.chat.accept(new Message(Operation.SendTestCode, (Object)getTestCode()));
    }
    
    public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EnterTestCode.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Enter Test Code");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
    
}

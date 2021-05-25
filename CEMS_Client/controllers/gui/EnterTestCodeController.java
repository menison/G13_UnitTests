package gui;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import entities.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EnterTestCodeController {

    @FXML
    private Button EnterTestCode_btnSendCode;

    @FXML
    private JFXTextField EnterTestCode_txtCode;
    
    @FXML
    private Button EnterTestCode_btnBack;
    
    private Test testInExecution;
    
    public String getTestCode() {
    	return EnterTestCode_txtCode.getText();
    }
    
    @FXML
    void SendTestCode(ActionEvent event) throws Exception {
    	ClientUI.chat.accept(new Message(Operation.SendTestCode, (Object)getTestCode())); 
    	
    	
    	Alert pop = new Alert(AlertType.WARNING);
    	pop.showAndWait();
    	Stage stage = (Stage) EnterTestCode_btnSendCode.getScene().getWindow();
    	Stage primaryStage = new Stage();
    	ChooseTestTypeController cttc = new ChooseTestTypeController();
    	cttc.start(primaryStage);
    	stage.close();
    }
    
    @FXML
    void Back(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) EnterTestCode_btnBack.getScene().getWindow();
    	StudentMenuController smc = new StudentMenuController();
    	smc.start(newStage);
    	stage.close();
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

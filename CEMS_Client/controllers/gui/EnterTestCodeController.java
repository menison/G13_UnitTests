package gui;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.ExecutedTest;
import entities.Message;
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
    
    public String getTestCode() {
    	return EnterTestCode_txtCode.getText();
    }
    
    @FXML
    void SendTestCode(ActionEvent event) throws Exception {
    	DataManager dm = DataManager.getDataManager();
    	String toAccept = getTestCode() + "," + dm.getCurrentUser().getPersonalSID();
    	
    	
    	ClientUI.chat.accept(new Message(Operation.SendTestCode, (Object)toAccept)); 
    	
    	ExecutedTest execTest = dm.getTestInExecution();
    	if (execTest == null) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Test code is not valid.");
			alert.showAndWait();
			
			Stage current = (Stage) EnterTestCode_btnSendCode.getScene().getWindow();
			current.close();
			
			Stage primaryStage = new Stage();
			start(primaryStage);
			
    	}
    		 	
    	Alert pop = new Alert(AlertType.WARNING);
    	pop.setContentText("Beware - you are about to start a test. This action cannot"
    			+ "be canceled");
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

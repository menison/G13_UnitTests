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

/**
 * A controller class handling the interaction with student in Enter test code window.
 */
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
    
    /**
     * This method sends the test code to the server, making sure it exists and
     * retrieving its' date by the testcode from the server.
     * @param event - a click on send has occured.
     * @throws Exception
     */
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
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Test code is valid, let's continue!");
			alert.showAndWait();
	    	Stage stage = (Stage) EnterTestCode_btnSendCode.getScene().getWindow();
	    	stage.close();
	    	Stage primaryStage = new Stage();
	    	ChooseTestTypeController cttc = new ChooseTestTypeController();
	    	cttc.start(primaryStage);
    	}
    }
    
    /**
     * This method
     * @param event - back button was pressed.
     * @throws Exception
     */
    @FXML
    void Back(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) EnterTestCode_btnBack.getScene().getWindow();
    	StudentMenuController smc = new StudentMenuController();
    	stage.close();
    	smc.start(newStage);
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

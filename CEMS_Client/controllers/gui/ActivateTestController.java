package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.ActivatedTest;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

/**
 * @author David
 * This Class is a controller for the test activation
 * @param ActivateTest_pinCodeField			pin code Field
 * @param ActivateTest_btnActivate			button that checks if 
 * 											entered code is valid and if yes it actiavates the test
 *
 * @param ActivateTest_dateSelect			date selector
 * @param ActivateTest_timeSelect			time selector
 * 
 */
public class ActivateTestController {
	
    @FXML
    private JFXTextField ActivateTest_pinCodeField;

    @FXML
    private JFXButton ActivateTest_btnActivate;

    @FXML
    private JFXButton ActivateTest_btnClose;

    
    @FXML
    private JFXDatePicker ActivateTest_dateSelect;

    @FXML
    private JFXTimePicker ActivateTest_timeSelect;
    /**
     * starts window
     */
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
    /**
     * activate function
     */
    void Activate(ActionEvent event) {
		DataManager dm = DataManager.getDataManager();
    	String pinCode = ActivateTest_pinCodeField.getText();//check if code is 4 characters
    	if(pinCode.length()!=4) {
			warningPopUp("Code must be 4 characters.");

    	}
    	else if(!pinCode.matches("[a-zA-Z0-9]*")){ // check if code is letters and numbers only
			warningPopUp("Letters and numbers only please.");
    	}
    	else if(ActivateTest_dateSelect.getValue()==null){ // checks if user chose a date

			warningPopUp("Please choose a date.");

    	}
    	else if(ActivateTest_timeSelect.getValue()==null){ // checks if user chose a time
			warningPopUp("Please choose time.");
    	}

    	else if(ActivateTest_dateSelect.getValue().compareTo(LocalDate.now())<0){ 
    		
    		warningPopUp("Please provide a future date");
    	}
    	else if(ActivateTest_dateSelect.getValue().compareTo(LocalDate.now())==0 && ActivateTest_timeSelect.getValue().compareTo(LocalTime.now())<0){ 
    		
    		warningPopUp("Please provide a future time.");
    	}
			

    	else {
  	

    	ActivatedTest activeTest =new ActivatedTest(pinCode,dm.getTestID(),dm.getCurrentUser().getPersonalSID(),ActivateTest_dateSelect.getValue(),ActivateTest_timeSelect.getValue(),1);
		ClientUI.chat.accept(new Message(Operation.ActivateTestCode,activeTest));
		
		if(dm.isActivateSuccess()) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(dm.getActivateMsg());
			alert.showAndWait();
	    	Stage stage = (Stage) ActivateTest_btnActivate.getScene().getWindow();
	    	stage.close();

		}
		else {
			warningPopUp(dm.getActivateMsg());
			}
		
    	}
    	
    }

    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage stage = (Stage) ActivateTest_btnClose.getScene().getWindow();
    	stage.close();
    }
    public void warningPopUp(String warning) {  
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(warning);

		alert.showAndWait();
    }
	@FXML
	public void initialize() {
		ActivateTest_timeSelect.getEditor().setDisable(true);
		ActivateTest_dateSelect.getEditor().setDisable(true);
	}

}
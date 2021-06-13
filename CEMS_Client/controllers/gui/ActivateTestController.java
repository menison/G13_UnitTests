package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ActivateTestController {
	
    @FXML
    private JFXTextField ActivateTest_pinCodeField;

    @FXML
    private JFXButton ActivateTest_btnActivate;

    @FXML
    private JFXButton ActivateTest_btnClose;
    @FXML
    private Label errorTxt;
    
    @FXML
    private JFXDatePicker ActivateTest_dateSelect;

    @FXML
    private JFXTimePicker ActivateTest_timeSelect;
    
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
    	String[] toSend = new String[5];
    	String pinCode = ActivateTest_pinCodeField.getText();//check if code is 4 characters
    	if(pinCode.length()!=4) {
			warningPopUp("Code must be 4 characters.");

    	}
    	else if(ActivateTest_dateSelect.getValue()==null){ // checks if user chose a date

			warningPopUp("please choose a date.");

    	}
    	else if(ActivateTest_timeSelect.getValue()==null){ // checks if user chose a time
			warningPopUp("please choose time.");
    	}
    		

    	else {
    		// formats date
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy"); 
        	LocalDate date =ActivateTest_dateSelect.getValue();
        	String dateString = date.format(formatter);
			// formats time
        	LocalTime time =ActivateTest_timeSelect.getValue();
        	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        	String timeString = time.format(timeFormatter);
        	
    	errorTxt.setVisible(false);
    	toSend[0]=pinCode;
    	toSend[1]=dm.getTestID();
    	toSend[2]=dateString;
    	toSend[3]=timeString;
    	toSend[4]=dm.getCurrentUser().getPersonalSID();
		ClientUI.chat.accept(new Message(Operation.ActivateTestCode,toSend));
		
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
    public void warningPopUp(String warning) {   //warnings func
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(warning);

		alert.showAndWait();
    }

}


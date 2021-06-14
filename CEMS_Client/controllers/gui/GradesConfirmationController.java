package gui;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.TestToConfirm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

    public class GradesConfirmationController implements Initializable {


        @FXML
        private JFXTextField calculatedGrade_txtField;
        
        @FXML
        private Label labelToHide1;

        @FXML
        private Label labelToHide2;

        @FXML
        private JFXTextField newGrade_txtField;

        @FXML
        private JFXToggleButton confimation_slideBar;

        @FXML
        private JFXTextField reasonForChange_txtField;

        @FXML
        private JFXButton confirmation_btnClose;

        @FXML
        private JFXButton confirmation_BtnSave;
        
        @FXML
        void changeGrade(ActionEvent event) {
        
    		if (confimation_slideBar.isSelected()) {
    			newGrade_txtField.setVisible(true);
        		reasonForChange_txtField.setVisible(true);
        		labelToHide1.setVisible(true);
        		labelToHide2.setVisible(true);
        		confirmation_BtnSave.setText("Save");
    		}
    		else {
    			newGrade_txtField.setVisible(false);
        		reasonForChange_txtField.setVisible(false);
        		labelToHide1.setVisible(false);
        		labelToHide2.setVisible(false);
        		confirmation_BtnSave.setText("Authorize");
    		}
    			
        }


        @FXML
        void Save(ActionEvent event) {
        	int newGrade = Integer.parseInt(newGrade_txtField.getText());
    		//String reason = reasonForChange_txtField.getText();
    		
    		String op = confirmation_BtnSave.getText();
    		System.out.println(op);
    		DataManager dm = DataManager.getDataManager();
    		TestToConfirm t = dm.getT();
    		t.setGrade(newGrade);
    		switch (op) {
    		case "Save":
    			ClientUI.chat.accept(new Message(Operation.ConfirmTestWithChanges, t));
    			break;
    		case "Authorize":
    			ClientUI.chat.accept(new Message(Operation.ConfirmTestWithoutChanges, "authorize"));
    			break;
    		}
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setContentText(op + "executed successfully!");
    		alert.showAndWait();		
        }
        
        @FXML
        void close(ActionEvent event) {
        	Stage stage = (Stage) confirmation_btnClose.getScene().getWindow();
        	stage.close();
        }
        
        public void start(Stage primaryStage) {	
        	Pane root;
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/fxml/GradesConfirmation.fxml"));
    		try {
				root = loader.load();
				Scene scene = new Scene(root);
	    		primaryStage.setTitle("Confirm Grades");
	    		primaryStage.setScene(scene);
	    		primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			ClientUI.chat.accept(new Message(Operation.GetCalculatedGradeForConfirmation, null));
			DataManager dm = DataManager.getDataManager();
			TestToConfirm t = dm.getT();
			int calculatedGrade = t.getGrade();
			calculatedGrade_txtField.setText(String.valueOf(calculatedGrade));
			newGrade_txtField.setVisible(false);
    		reasonForChange_txtField.setVisible(false);
    		confimation_slideBar.setSelected(false);
    		labelToHide1.setVisible(false);
    		labelToHide2.setVisible(false);
    		confirmation_BtnSave.setText("Authorize");
    		calculatedGrade_txtField.setEditable(false);
    		HashSet<String> suspects = dm.getSuspectsForFraud();
    		if (suspects.contains(t.getExecutedBy()))
    			
			
		}
        

    }



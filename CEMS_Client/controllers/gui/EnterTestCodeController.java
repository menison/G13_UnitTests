package gui;

import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    
}

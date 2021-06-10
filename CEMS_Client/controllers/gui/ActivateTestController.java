package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ActivateTestController {

    @FXML
    private JFXTextField ActivateTest_pinCodeField;

    @FXML
    private JFXButton ActivateTest_btnActivate;

    @FXML
    private JFXButton ActivateTest_btnClose;

    
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
    	String pinCode = ActivateTest_pinCodeField.getText();
    	
    }

    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) ActivateTest_btnClose.getScene().getWindow();
    	TestTableController ttc = new TestTableController();
    	ttc.start(newStage);
    	stage.close();
    }
    

}

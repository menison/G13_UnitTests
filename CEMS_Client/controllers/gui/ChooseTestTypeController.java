package gui;

import java.io.IOException;

import application.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseTestTypeController {

    @FXML
    private Button chooseTestType_btnManual;

    @FXML
    private Button chooseTestType_btnComput;

    @FXML
    void openCompTest(ActionEvent event) {
    	openNewScene("/fxml/ManualTest.fxml", event);
    }

    @FXML
    void openManualTest(ActionEvent event) {
    	openNewScene("/fxml/ManualTest.fxml", event);
    }
    
    private void openNewScene(String FXML ,ActionEvent event ) {
    	
    
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(e->e.consume());
		Pane root;
		try {
			root = loader.load(getClass().getResource(FXML).openStream());
			Scene scene = new Scene(root);
			primaryStage.setTitle("GoNature");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    

}

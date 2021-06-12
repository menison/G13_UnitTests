package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestFinalController {

    @FXML
    private Button txtSentSuccess_btnClose;

    @FXML
    private JFXTextField testSentSuccess_txtTimeSpent;
    

    public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestFinal.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Finished - test sent successfully!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void close(ActionEvent event) {
    	Stage primaryStage = (Stage) txtSentSuccess_btnClose.getScene().getWindow();
    	primaryStage.close();
    	StudentMenuController smc = new StudentMenuController();
    	primaryStage = new Stage();
    	smc.start(primaryStage);
    }
}

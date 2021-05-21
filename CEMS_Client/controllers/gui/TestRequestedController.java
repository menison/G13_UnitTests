package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestRequestedController {

    @FXML
    private Button TestCopySuccess_btnClose;

    @FXML
    void Close(ActionEvent event) {
    	Stage stage = (Stage) TestCopySuccess_btnClose.getScene().getWindow();
    	stage.close();
    }
    
    public void start(Stage primaryStage) throws Exception {	
		//Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("TestRequested.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Test Requested");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

}

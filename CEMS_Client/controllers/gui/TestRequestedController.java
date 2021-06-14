package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author David
 *TestRequestedController controller for testRequested FXML
 */
public class TestRequestedController {

    @FXML
    private Button TestCopySuccess_btnClose;

    /**
     * closes window
     * @param event
     */
    @FXML
    void Close(ActionEvent event) {
    	Stage stage = (Stage) TestCopySuccess_btnClose.getScene().getWindow();
    	stage.close();
    }
    
    /**
     * starts window
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {	
		//Parent root = FXMLLoader.load(getClass().getResource("TestRequested.fxml"));
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestRequested.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Test Requested");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

}

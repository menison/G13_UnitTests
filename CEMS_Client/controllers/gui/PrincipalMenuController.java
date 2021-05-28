package gui;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalMenuController {

    @FXML
    private JFXButton PrincipalMenu_btnReports;

    @FXML
    private JFXButton PrincipalMenu_btnExtensionRequests;

    @FXML
    private JFXButton PrincipalMenu_btnLogout;
    
    public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalMenu.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Principal Menu");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
    @FXML
    void PrincipalMenu_btnReportsClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalGetReportWindowController pgrwc = new PrincipalGetReportWindowController();
    	pgrwc.start(newStage);
    	currentStage.close();
    }
    @FXML
    void PrincipalMenu_btnExtensionRequestsClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalTestExtentionRequestsController pterc = new PrincipalTestExtentionRequestsController();
    	pterc.start(newStage);
    	currentStage.close();
    }
    @FXML
    void PrincipalMenu_btnLogoutClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	LoginCemsController lcc = new LoginCemsController();
    	lcc.start(newStage);
    	currentStage.close();
    }

}

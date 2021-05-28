package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalTestExtentionRequestsController {

    @FXML
    private TableView<?> PrincipalTestExtentionRequests_tblViewRequests;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnDone;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnDecline;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnApprove;

	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalTestExtentionRequests.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Test Extention Requests");
		newStage.setScene(scene);
		newStage.show();
	}
    @FXML
    void PrincipalTestExtentionRequests_btnDoneClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalMenuController pmc = new PrincipalMenuController();
    	pmc.start(newStage);
    	currentStage.close();
    }
	

}

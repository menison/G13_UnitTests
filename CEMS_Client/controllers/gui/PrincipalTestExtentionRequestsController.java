package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Extension;
import entities.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A controller class handling interaction with principal in test extension requests window.
 */

public class PrincipalTestExtentionRequestsController {

    @FXML
    private TableView<Extension> PrincipalTestExtentionRequests_tblViewRequests;

    @FXML
    private TableColumn<Extension, String> PrincipalTestExtentionRequests_testCodeCol;

    @FXML
    private TableColumn<Extension, String> PrincipalTestExtentionRequests_requestedByCol;

    @FXML
    private TableColumn<Extension, Integer> PrincipalTestExtentionRequests_newDurationCol;

    @FXML
    private TableColumn<Extension, String> PrincipalTestExtentionRequests_reasonCol;

    @FXML
    private TableColumn<Extension, Integer> PrincipalTestExtentionRequests_isAuthorizedCol;

    @FXML
    private TableColumn<Extension, Integer> PrincipalTestExtentionRequests_isRelevantCol;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnDone;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnDecline;

    @FXML
    private JFXButton PrincipalTestExtentionRequests_btnApprove;
    
    /**
     * Standard controller starting mechanism.
     * @param primaryStage - a stage to start on.
     */
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
	
	
    /**
     * This method finishes the extension request, closes the current window
     * and re-opens principal main menu.
     * @param event- a click on done has occured.
     * @throws Exception
     */
    @FXML
    void PrincipalTestExtentionRequests_btnDoneClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalMenuController pmc = new PrincipalMenuController();
    	pmc.start(newStage);
    	currentStage.close();
    }
    
	/**
	 * This method, as soon as an instance of this controller is created,
	 * initializes the extension requests table with data from server.
	 */
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetExtensionRequests));
		ObservableList<Extension> tests = FXCollections
				.observableArrayList(DataManager.getDataManager().getExtensionRequests());
		PrincipalTestExtentionRequests_testCodeCol.setCellValueFactory(new PropertyValueFactory<>("testCode"));
		PrincipalTestExtentionRequests_requestedByCol.setCellValueFactory(new PropertyValueFactory<>("requestedBy"));
		PrincipalTestExtentionRequests_newDurationCol.setCellValueFactory(new PropertyValueFactory<>("newDuration"));
		PrincipalTestExtentionRequests_reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
		PrincipalTestExtentionRequests_isRelevantCol.setCellValueFactory(new PropertyValueFactory<>("isRelevant"));
		PrincipalTestExtentionRequests_isAuthorizedCol.setCellValueFactory(new PropertyValueFactory<>("isAuthorized"));
		PrincipalTestExtentionRequests_tblViewRequests.setItems(tests);
	}
	
	
	/**
	 * This method approves the extension request and making sure that DB is updated with
	 * the new test's duration and with a saved record of the extension request - new time and
	 * reason will be saved within DB.
	 * @param event - a click on approve has occured
	 * @throws Exception
	 */
	@FXML
	void approve(ActionEvent event) throws Exception {
		Extension extension = PrincipalTestExtentionRequests_tblViewRequests.getSelectionModel().getSelectedItem();
		if(extension == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("You have to choose request!");
			alert.showAndWait();
		}else {
			if(extension.getIsAuthorized()!=-1) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Already approved/Notapproved");
				alert.showAndWait();
			}else {
				ClientUI.chat.accept(new Message(Operation.ApproveExtensionRequests,extension.getTestCode()+"_"+extension.getNewDuration()));
				if(DataManager.getDataManager().getActivateMsg().equals("done")) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Done");
					alert.setContentText("Extention request has been aproved");
					alert.showAndWait();
					PrincipalMenuController pmc = new PrincipalMenuController();
					Stage primaryStage = new Stage();
					pmc.start(primaryStage);
					((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText("There was a problem adding the test, Please try again");
					alert.showAndWait();
				}
			}
		}
	}
	
	/**
	 * This method declines the extension request and making sure that DB is updated 
	 * with a saved record of the extension request - new time and
	 * reason will be saved within DB.
	 * @param event - a click on approve has occured
	 * @throws Exception
	 */
	@FXML
	void decline(ActionEvent event) throws Exception {
		Extension extension = PrincipalTestExtentionRequests_tblViewRequests.getSelectionModel().getSelectedItem();
		if(extension == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("You have to choose request!");
			alert.showAndWait();
		}else {
			if(extension.getIsAuthorized()!=-1) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Already approved/Notapproved");
				alert.showAndWait();
			}else {
				ClientUI.chat.accept(new Message(Operation.DeclineExtensionRequests,extension.getTestCode()));
				if(DataManager.getDataManager().getActivateMsg().equals("done")) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Done");
					alert.setContentText("Extention request has been decline");
					alert.showAndWait();
					PrincipalMenuController pmc = new PrincipalMenuController();
					Stage primaryStage = new Stage();
					pmc.start(primaryStage);
					((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText("There was a problem adding the test, Please try again");
					alert.showAndWait();
				}
			}
		}

	}
}

package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.Question;
import entities.TestToConfirm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalTestExtentionRequestsController {

    @FXML
    private TableView<TestToConfirm> PrincipalTestExtentionRequests_tblViewRequests;

    @FXML
    private TableColumn<TestToConfirm, String> PrincipalTestExtentionRequests_testCodeCol;

    @FXML
    private TableColumn<TestToConfirm, String> PrincipalTestExtentionRequests_requestedByCol;

    @FXML
    private TableColumn<TestToConfirm, Integer> PrincipalTestExtentionRequests_newDurationCol;

    @FXML
    private TableColumn<TestToConfirm, String> PrincipalTestExtentionRequests_reasonCol;

    @FXML
    private TableColumn<TestToConfirm, Integer> PrincipalTestExtentionRequests_isAuthorizedCol;

    @FXML
    private TableColumn<TestToConfirm, Integer> PrincipalTestExtentionRequests_isRelevantCol;

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
    
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetExtensionRequests));
		ObservableList<TestToConfirm> tests = FXCollections
				.observableArrayList(DataManager.getDataManager().getTestToConfirm());
		PrincipalTestExtentionRequests_testCodeCol.setCellValueFactory(new PropertyValueFactory<>("testID"));
		PrincipalTestExtentionRequests_requestedByCol.setCellValueFactory(new PropertyValueFactory<>("text"));
		PrincipalTestExtentionRequests_newDurationCol.setCellValueFactory(new PropertyValueFactory<>("answersString"));
		PrincipalTestExtentionRequests_reasonCol.setCellValueFactory(new PropertyValueFactory<>("correctAnswerIndex"));
		PrincipalTestExtentionRequests_isAuthorizedCol.setCellValueFactory(new PropertyValueFactory<>("teacherComposed"));
		PrincipalTestExtentionRequests_isRelevantCol.setCellValueFactory(new PropertyValueFactory<>("teacherComposed"));
		PrincipalTestExtentionRequests_tblViewRequests.setItems(tests);

	}

}

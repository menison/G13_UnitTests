package gui;

import java.io.IOException;
import java.util.ArrayList;
import com.jfoenix.controls.JFXButton;
import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.TestForFullTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * ClassFullTestTableController for FullTestTable FXML.
 * @author David
 *	This class handles FullTestTable for buttons and table view.
 * @param fullTestTable_btnAddTest			FXML: Add test button.
 * @param fullTestTable_btnActivateTest		FXML: Activate test button.
 * @param fullTestTable_btnEditTest			FXML: Edit test button.
 * @param fullTestTable_btnClose			FXML: Close window button.
 * @param fullTestTbl						FXML: Table view.
 * 
 */
public class FullTestTableController {

    @FXML
    private JFXButton fullTestTable_btnAddTest;

    @FXML
    private JFXButton fullTestTable_btnActivateTest;

    @FXML
    private JFXButton fullTestTable_btnEditTest;

    @FXML
    private JFXButton fullTestTable_btnClose;

    @FXML
    private TableView<TestForFullTable> fullTestTbl;

    @FXML
    private TableColumn<TestForFullTable, String> fullTestTable_IdColumn;

    @FXML
    private TableColumn<TestForFullTable, String> fullTestTable_subjectColumn;

    @FXML
    private TableColumn<TestForFullTable, String> fullTestTable_courseColumn;

    @FXML
    private TableColumn<TestForFullTable, Integer> fullTestTable_durationColumn;

    @FXML
    private TableColumn<TestForFullTable, String> fullTestTable_composerColumn;


	/**
	 * starts FullTestTable window
	 * @param primaryStage
	 * @throws IOException
	 */
	public void start(Stage primaryStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/FullTestTable.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Full Test Table");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * initializes the table view with received TestForFullTable ArrayList from server
	 */
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetFullTestTable));
		DataManager dm = DataManager.getDataManager();
		ArrayList<TestForFullTable> t = new ArrayList<>(); 
		t=dm.getFullTable();
		ObservableList<TestForFullTable> tests = FXCollections.observableArrayList(dm.getFullTable());
		fullTestTable_IdColumn.setCellValueFactory(new PropertyValueFactory<>("testID"));
		fullTestTable_subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
		fullTestTable_courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
		fullTestTable_durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
		fullTestTable_composerColumn.setCellValueFactory(new PropertyValueFactory<>("composer"));
		fullTestTbl.setItems(tests);
	}

    /**
     * Opens ActivateTest window and sends test id to data manager
     * @param event
     * @throws IOException
     */
    @FXML
    void ActivateTest(ActionEvent event) throws IOException {

    	if(fullTestTbl.getSelectionModel().getSelectedItem()!=null){
        Object selectedItems=fullTestTbl.getSelectionModel().getSelectedItem().getTestID();
    	Stage stage = new Stage();
    	ActivateTestController activateTest= new ActivateTestController();
    	activateTest.start(stage);
		DataManager dm = DataManager.getDataManager();
		dm.setTestID(selectedItems.toString());
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setContentText("Please choose a test first.");

    		alert.showAndWait();
    	}
    }

    /**
     * closes window
     * @param event
     * @throws Exception
     */
    @FXML
    void Close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) fullTestTable_btnClose.getScene().getWindow();
    	TeacherMenuController tmc = new TeacherMenuController();
    	tmc.start(newStage);
    	stage.close();
    }

    /**
     * Opens EditTest window and sends test id to data manager
     * @param event
     * @throws IOException
     */
    @FXML
    void EditTest(ActionEvent event) throws IOException {
    	if(fullTestTbl.getSelectionModel().getSelectedItem()!=null){
            Object selectedItems=fullTestTbl.getSelectionModel().getSelectedItem().getTestID();
        	Stage stage = new Stage();
        	EditTestController editTest= new EditTestController();
    		DataManager dm = DataManager.getDataManager();
    		dm.setTestID(selectedItems.toString());
        	editTest.start(stage);
        	}else {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setContentText("Please choose a test first.");

        		alert.showAndWait();
        	}
    }

    /**
     * Opens addTest window and sends test id to data manager
     * @param event
     * @throws IOException
     */
    @FXML
    void addTest(ActionEvent event) throws IOException {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AddTestController atc = new AddTestController();
		atc.start(newStage);
		currentStage.close();
    }
}
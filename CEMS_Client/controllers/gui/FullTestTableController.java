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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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

    @FXML
    void ActivateTest(ActionEvent event) throws IOException {
    	Object selectedItems=fullTestTbl.getSelectionModel().getSelectedItem().getTestID();
    	if(selectedItems!=null);
    	{

    	Stage stage = new Stage();
    	ActivateTestController activateTest= new ActivateTestController();
    	activateTest.start(stage);
		DataManager dm = DataManager.getDataManager();
		dm.setTestID(selectedItems.toString());
    	}	
    }

    @FXML
    void Close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) fullTestTable_btnClose.getScene().getWindow();
    	TeacherMenuController tmc = new TeacherMenuController();
    	tmc.start(newStage);
    	stage.close();
    }

    @FXML
    void EditTest(ActionEvent event) {

    }

    @FXML
    void addTest(ActionEvent event) throws IOException {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AddTestController atc = new AddTestController();
		atc.start(newStage);
		currentStage.close();
    }
}
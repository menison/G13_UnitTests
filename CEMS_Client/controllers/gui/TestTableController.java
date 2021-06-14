package gui;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.TestForTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestTableController{

    @FXML
    private TableView<TestForTable> myTestsTable_tblTests;

    @FXML
    private TableColumn<TestForTable, String> myTests_colTestID;

    @FXML
    private TableColumn<TestForTable, String> myTests_colTestCode;

    @FXML
    private TableColumn<TestForTable, String> myTests_colDate;

    @FXML
    private TableColumn<TestForTable, Integer> myTests_colAllocDuration;

    @FXML
    private TableColumn<TestForTable, Integer> myTests_colActualDuration;

    @FXML
    private TableColumn<TestForTable, Integer> myTests_colGrade;

    @FXML
    private Button myTestsTable_btnBack;

    @FXML
    private Button myTestsTable_btnRequestCopy;
    
    @FXML
    void requestTestCopy(ActionEvent event) throws Exception {
    	DataManager dm = DataManager.getDataManager();
    	Object selectedItems;
    	String second_Column = null;
    	try {
    	selectedItems = myTestsTable_tblTests.getSelectionModel().getSelectedItems().get(0);
    	second_Column = selectedItems.toString().split(",")[1].substring(0);
    	ClientUI.chat.accept(new Message(Operation.GetTestForReview,
    			second_Column+","+dm.getCurrentUser().getPersonalSID()));
    	Stage newStage = new Stage();
    	RequestedTestController rtc = new RequestedTestController();
    	rtc.start(newStage);
    	} catch(Exception e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Please select a row");
			alert.showAndWait();
    	}
    }
    
    @FXML
    void back(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) myTestsTable_btnBack.getScene().getWindow();
    	StudentMenuController smc = new StudentMenuController();
    	smc.start(newStage);
    	stage.close();
    }
    
    public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestTable.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Test Table");
		primaryStage.setScene(scene);
		ClientUI.chat.accept(new Message(Operation.GetTestTable));
		this.setTable();
		primaryStage.show();
	}
    
	public void setTable() {
    	DataManager dm = DataManager.getDataManager();

    	
    	ObservableList<TestForTable> tests = FXCollections.observableArrayList(dm.getExecutedExams());
    	myTests_colTestID.setCellValueFactory(new PropertyValueFactory<>("testID"));
    	myTests_colTestCode.setCellValueFactory(new PropertyValueFactory<>("testCode"));
    	myTests_colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
    	myTests_colAllocDuration.setCellValueFactory(new PropertyValueFactory<>("allocatedDuration"));
    	myTests_colActualDuration.setCellValueFactory(new PropertyValueFactory<>("ActualDuration"));
    	myTests_colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
    	myTestsTable_tblTests.setItems(tests);
    }


}

package gui;

import application.ClientUI;
import common.Operation;
import entities.Message;
import entities.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestTableController {

    @FXML
    private TableView<Test> myTestsTable_tblTests;

    @FXML
    private TableColumn<Test, String> myTests_colTestID;

    @FXML
    private TableColumn<Test, String> myTests_colTestCode;

    @FXML
    private TableColumn<Test, String> myTests_colDate;

    @FXML
    private TableColumn<Test, Integer> myTests_colAllocDuration;

    @FXML
    private TableColumn<Test, Integer> myTests_colActualDuration;

    @FXML
    private TableColumn<Test, Integer> myTests_colGrade;

    @FXML
    private Button myTestsTable_btnBack;

    @FXML
    private Button myTestsTable_btnRequestCopy;
    
    @FXML
    void requestTestCopy(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	TestRequestedController trc = new TestRequestedController();
		trc.start(newStage);
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
		primaryStage.show();
		ClientUI.chat.accept(new Message(Operation.GetTestTable));
	}
}

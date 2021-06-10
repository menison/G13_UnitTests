package gui;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import cachedUserData.DataManager;
import entities.TestForFullTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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


	public void setTable() {
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
}
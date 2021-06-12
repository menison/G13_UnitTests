package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import cachedUserData.DataManager;
import entities.TestForTable;
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

public class TestsStatisticsController {

    @FXML
    private JFXButton testsStatistics_btnClose;

    @FXML
    private TableView<TestForTable> testStatisticsTable;

    @FXML
    private TableColumn<TestForTable, String> testIdColumn;

    @FXML
    private JFXButton testsStatistics_btnGetStatistics;

	public void start(Stage newStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestsStatistics.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Tests Statistics");
		newStage.setScene(scene);
		newStage.show();
	}
	
	@FXML
	void testsStatistics_btnCloseClicked(ActionEvent event) throws Exception {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		TeacherMenuController tmc = new TeacherMenuController();
		tmc.start(newStage);
		currentStage.close();
	}
	
    @FXML 
	void getReport(ActionEvent event) throws IOException {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		TeacherReportWindowController trwc = new TeacherReportWindowController();
		trwc.start(newStage);
		currentStage.close();
	}
    
	@FXML
	public void initialize() {
		DataManager dm = DataManager.getDataManager();
    	ObservableList<TestForTable> tests = FXCollections.observableArrayList(dm.getExecutedExams());
    	testIdColumn.setCellValueFactory(new PropertyValueFactory<>("testID"));
    	testStatisticsTable.setItems(tests);
	}
	
	
}

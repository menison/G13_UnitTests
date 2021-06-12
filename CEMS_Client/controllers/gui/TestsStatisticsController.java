package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestsStatisticsController {

    @FXML
    private JFXButton testsStatistics_btnClose;

    @FXML
    private TableView<?> testStatisticsTable;

    @FXML
    private TableColumn<?, ?> testIdColumn;

    @FXML
    private TableColumn<?, ?> testCodeColumn;

    @FXML
    private JFXButton testsStatistics_btnGetStatistics;

	public void start(Stage newStage) {
		Pane root = null;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestsStatistics.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
}

package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddQuestionForTestController {

    @FXML
    private JFXButton ChooseQuestion_btnSearch;

    @FXML
    private JFXButton ChooseQuestion_btnClose;

    @FXML
    private JFXButton ChooseQuestion_btnAdd;

    @FXML
    private TableView<?> ChooseQuestion_tblQuestion;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_qustionIDcol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_subjectCol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_CourseCol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_composerCol;

    @FXML
    private JFXTextField ChooseQuestion_courseNameField;

    @FXML
    private JFXTextField ChooseQuestion_pointsField;

    @FXML
    void AddQuestion(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) ChooseQuestion_btnClose.getScene().getWindow();
    	AddTestController atc = new AddTestController();
    	atc.start(newStage);
    	stage.close();
    }

    @FXML
    void search(ActionEvent event) {
    	
    }
	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/AddQuestionForTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Add Question For Test");
		newStage.setScene(scene);
		newStage.show();
	}
}

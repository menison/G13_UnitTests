package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddTestController {

    @FXML
    private JFXButton CreateTest_btnAddQuestion;

    @FXML
    private JFXButton CreateTest_btnDeleteQuestion;

    @FXML
    private JFXButton CreateTest_btnClose;

    @FXML
    private JFXButton CreateTest_btnSubmit;

    @FXML
    private TableView<?> CreateTest_tblQuestions;

    @FXML
    private TableColumn<?, ?> CreateTest_QuestionIDCol;

    @FXML
    private TableColumn<?, ?> CreateTest_PointsCol;

    @FXML
    private JFXTextField CreateTest_DurationField;

    @FXML
    private JFXComboBox<?> CreateTest_chooseSubjectBox;

    @FXML
    private JFXComboBox<?> CreateTest_chooseCourseBox;

    @FXML
    private JFXTextArea CreateTest_TeacherCommentsField;

    @FXML
    private JFXTextArea CreateTest_StudentCommentsField;
    
	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/AddTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Add Test");
		newStage.setScene(scene);
		newStage.show();
	}
	
    @FXML
    void addQuestion(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) throws IOException {
		FullTestTableController ftt  = new FullTestTableController();
		ClientUI.chat.accept(new Message(Operation.GetFullTestTable));
		Stage primaryStage = new Stage();
		ftt.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();	
    }

    @FXML
    void deleteQuestion(ActionEvent event) {

    }

    @FXML
    void submitQuestion(ActionEvent event) {

    }
    
}

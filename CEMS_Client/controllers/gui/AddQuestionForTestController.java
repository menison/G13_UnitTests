package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
import entities.TestForTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddQuestionForTestController {

    @FXML
    private JFXButton ChooseQuestion_btnClose;

    @FXML
    private JFXButton ChooseQuestion_btnAdd;

    @FXML
    private TableView<Question> ChooseQuestion_tblQuestion;

    @FXML
    private TableColumn<Question, String> ChooseQuestion_qustionIDcol;

    @FXML
    private TableColumn<Question, String> ChooseQuestion_TextCol;

    @FXML
    private TableColumn<Question, String[]> ChooseQuestion_AnswersCol;

    @FXML
    private TableColumn<Question, Integer> ChooseQuestion_CorrectCol;

    @FXML
    private TableColumn<Question, String> ChooseQuestion_composedCol;

    @FXML
    private JFXTextField ChooseQuestion_pointsField;

    @FXML
    void AddQuestion(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) ChooseQuestion_btnClose.getScene().getWindow();
    	stage.close();
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
	
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetQuestions));
    	ObservableList<Question> questions = FXCollections.observableArrayList(DataManager.getDataManager().getQuestions());
    	ChooseQuestion_qustionIDcol.setCellValueFactory(new PropertyValueFactory<>("questionID"));
    	ChooseQuestion_TextCol.setCellValueFactory(new PropertyValueFactory<>("text"));
    	ChooseQuestion_AnswersCol.setCellValueFactory(new PropertyValueFactory<>("answersString"));
    	ChooseQuestion_CorrectCol.setCellValueFactory(new PropertyValueFactory<>("correctAnswerIndex"));
    	ChooseQuestion_composedCol.setCellValueFactory(new PropertyValueFactory<>("teacherComposed"));
    	ChooseQuestion_tblQuestion.setItems(questions);

	}
}



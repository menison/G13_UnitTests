package gui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
import entities.QuestionForCreateTest;
import entities.TestForTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author David
 * AddQuestionForTestController controller for AddQuestionForTest FXML
 */
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

	/**
	 * adds question to database if all fields are correct 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void AddQuestion(ActionEvent event) throws IOException {
		Question q = ChooseQuestion_tblQuestion.getSelectionModel().getSelectedItem();
		String points = ChooseQuestion_pointsField.getText();
	  	try {
	      	@SuppressWarnings("unused")
	    	int x = Integer.parseInt(ChooseQuestion_pointsField.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Points is only of type integer");
			alert.showAndWait(); //String is not an Integer
			return;
		}
		if (q == null || points.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("You have to choose a question and set points for it");
			alert.showAndWait();
		}
		else {
			QuestionForCreateTest questionForCreateTest = new QuestionForCreateTest(q, points);
			DataManager.getDataManager().getCreateTest_tblQuestions().getItems().add(questionForCreateTest);
			Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setContentText("Question has been added to the test");
			alert.showAndWait();
			
			 
		}
	}

	/**
	 * closes window
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void close(ActionEvent event) throws Exception {
		Stage stage = (Stage) ChooseQuestion_btnClose.getScene().getWindow();
		stage.close();
	}

	/**
	 * starts window
	 * @param newStage
	 * @throws IOException
	 */
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

	/**
	 * initializes table of questions
	 */
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetQuestions));
		ObservableList<Question> questions = FXCollections
				.observableArrayList(DataManager.getDataManager().getQuestions());
		ChooseQuestion_qustionIDcol.setCellValueFactory(new PropertyValueFactory<>("questionID"));
		ChooseQuestion_TextCol.setCellValueFactory(new PropertyValueFactory<>("text"));
		ChooseQuestion_AnswersCol.setCellValueFactory(new PropertyValueFactory<>("answersString"));
		ChooseQuestion_CorrectCol.setCellValueFactory(new PropertyValueFactory<>("correctAnswerIndex"));
		ChooseQuestion_composedCol.setCellValueFactory(new PropertyValueFactory<>("teacherComposed"));
		ChooseQuestion_tblQuestion.setItems(questions);

	}


}

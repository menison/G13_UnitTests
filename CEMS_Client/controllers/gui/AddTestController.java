package gui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
import entities.QuestionForCreateTest;
import entities.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableView<QuestionForCreateTest> CreateTest_tblQuestions;

	@FXML
	private TableColumn<Question, String> CreateTest_QuestionIDCol;

	@FXML
	private TableColumn<Question, String> CreateTest_PointsCol;

	@FXML
	private JFXTextField CreateTest_DurationField;

	@FXML
	private JFXComboBox<Field> CreateTest_chooseSubjectBox;

	@FXML
	private JFXComboBox<Course> CreateTest_chooseCourseBox;

	@FXML
	private JFXTextArea CreateTest_TeacherCommentsField;

	@FXML
	private JFXTextArea CreateTest_StudentCommentsField;

	public ArrayList<QuestionForCreateTest> questionForCreateTest;

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
	public void initialize() {
		this.questionForCreateTest = new ArrayList<QuestionForCreateTest>();
		ClientUI.chat.accept(new Message(Operation.GetSubjectsAndCourses));
		for (Field f : DataManager.getDataManager().getFields()) {
			CreateTest_chooseSubjectBox.getItems().add(f);
		}
		CreateTest_chooseCourseBox.setDisable(true);
		CreateTest_chooseSubjectBox.setOnAction(e -> {
			CreateTest_chooseCourseBox.getItems().clear();
			CreateTest_chooseCourseBox.setDisable(false);
			for (Course c : CreateTest_chooseSubjectBox.getSelectionModel().getSelectedItem().getCourseList()) {
				CreateTest_chooseCourseBox.getItems().add(c);
			}
		});
		ObservableList<QuestionForCreateTest> questions = FXCollections.observableArrayList(this.questionForCreateTest);
		CreateTest_QuestionIDCol.setCellValueFactory(new PropertyValueFactory<>("question"));
		CreateTest_PointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
		CreateTest_tblQuestions.setItems(questions);
	}

	@FXML
	void addQuestion(ActionEvent event) throws IOException {
		DataManager.getDataManager().setCreateTest_tblQuestions(CreateTest_tblQuestions);
		AddQuestionForTestController aqftc = new AddQuestionForTestController();
		ClientUI.chat.accept(new Message(Operation.GetFullTestTable));
		Stage primaryStage = new Stage();
		aqftc.start(primaryStage);
	}

	@FXML
	void close(ActionEvent event) throws Exception {
		FullTestTableController ftt = new FullTestTableController();
		Stage primaryStage = new Stage();
		ftt.start(primaryStage);
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

	@FXML
	void deleteQuestion(ActionEvent event) {
		CreateTest_tblQuestions.getItems().remove(CreateTest_tblQuestions.getSelectionModel().getSelectedItem());
	}

	@FXML
	void submitTest(ActionEvent event) throws Exception {
		boolean notFilledFlag = false;
		String notFilled = "The following fields were not filled:\n ";
		if (CreateTest_tblQuestions.getItems().isEmpty()) {
			notFilled += "-Questions table\n";
			notFilledFlag = true;
		}
		if (CreateTest_chooseSubjectBox.getSelectionModel().getSelectedItem() == null) {
			notFilled += "-Subject\n";
			notFilledFlag = true;
		}
		if (CreateTest_chooseCourseBox.getSelectionModel().getSelectedItem() == null) {
			notFilled += "-Course\n";
			notFilledFlag = true;
		}
		if (CreateTest_DurationField.getText().isEmpty()) {
			notFilled += "-Test Duration\n";
			notFilledFlag = true;
		}
		if(isNumeric(CreateTest_DurationField.getText())==false) {
			notFilled+="Test duration is of type int only\n";
			notFilledFlag = true;
		}
		if (notFilledFlag) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(notFilled);
			alert.showAndWait();
		} else {
			ArrayList<Question> questions = new ArrayList<Question>();
			ArrayList<String> points = new ArrayList<String>();
			for (QuestionForCreateTest qfct : CreateTest_tblQuestions.getItems()) {
				questions.add(qfct.getQuestion());
				points.add(qfct.getPoints());
			}
			String[] pointsArray = new String[points.size()];
			for (int i = 0; i < points.size(); i++) {
				pointsArray[i] = points.get(i);
			}

			Test newTest = new Test(questions, CreateTest_chooseCourseBox.getSelectionModel().getSelectedItem().getID(), Integer.parseInt(CreateTest_DurationField.getText()),
					CreateTest_StudentCommentsField.getText(), CreateTest_TeacherCommentsField.getText(), "-1",
					pointsArray, 0, DataManager.getDataManager().getCurrentUser().getPersonalSID());

			ClientUI.chat.accept(new Message(Operation.AddNewTest,newTest));

			if(DataManager.getDataManager().getAddTestMsg().equals("Added new test successfully")) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setContentText("Added new test successfully");
				alert.showAndWait();

				FullTestTableController ftt = new FullTestTableController();
				Stage primaryStage = new Stage();
				ftt.start(primaryStage);
				((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("There was a problem adding the test, Please try again");
				alert.showAndWait();
			}
		}
	}
	public void addQustionToTable(QuestionForCreateTest question) {
		CreateTest_tblQuestions.getItems().add(question);
	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}

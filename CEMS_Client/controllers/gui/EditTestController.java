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
import entities.Message;
import entities.Question;
import entities.QuestionForCreateTest;
import entities.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditTestController {

    @FXML
    private ImageView studentCommentsField;

    @FXML
    private JFXButton EditTest_btnAddQuestion;

    @FXML
    private JFXButton EditTest_btnDeleteQuestion;

    @FXML
    private JFXButton EditTest_btnClose;

    @FXML
    private JFXButton EditTest_btnSubmit;

    @FXML
    private TableView<QuestionForCreateTest> EditTest_tblQuestions;

    @FXML
    private TableColumn<QuestionForCreateTest, String> EditTest_QuestionIDCol;

    @FXML
    private TableColumn<QuestionForCreateTest, String> EditTest_pointsCol;

    @FXML
    private JFXTextField EditTest_DurationField;


    @FXML
    private JFXTextArea EditTest_teacherCommentsField;

    @FXML
    private JFXTextArea EditTest_studentComentsField;

    @FXML
    void addQuestion(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void deleteQuestion(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

    }
	public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EditTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Edit Test test");
		newStage.setScene(scene);
		newStage.show();
	}
	@FXML
	public void initialize() {
		String testID= DataManager.getDataManager().getTestID();
		ClientUI.chat.accept(new Message(Operation.GetTestByID,testID));
		ArrayList<QuestionForCreateTest> questionForCreateTest = new ArrayList<QuestionForCreateTest>();
		Test test = DataManager.getDataManager().getTest();
		test.getQuestionString();
		String[] questions = test.getQuestionString().split(",");
		String[] points = test.getPointsString().split(",");
		for (int i =0;i<questions.length;i++) {
			questionForCreateTest.add(new QuestionForCreateTest(questions[i],points[i]));
		}
		ObservableList<QuestionForCreateTest> questionsTbl = FXCollections.observableArrayList(questionForCreateTest);
		EditTest_QuestionIDCol.setCellValueFactory(new PropertyValueFactory<>("questionStr"));
		EditTest_pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
		EditTest_tblQuestions.setItems(questionsTbl);
		EditTest_DurationField.setText(Integer.toString(test.getAllocatedDuration()));
		EditTest_teacherCommentsField.setText(test.getCommentsForTeachers());
		EditTest_studentComentsField.setText(test.getCommentsForStudents());
		
	}
}

package gui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Alert.AlertType;
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
    void addQuestion(ActionEvent event) throws IOException {
		DataManager.getDataManager().setCreateTest_tblQuestions(EditTest_tblQuestions);
		AddQuestionForTestController aqftc = new AddQuestionForTestController();
		ClientUI.chat.accept(new Message(Operation.GetFullTestTable));
		Stage primaryStage = new Stage();
		aqftc.start(primaryStage);
    }

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) EditTest_btnClose.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void deleteQuestion(ActionEvent event) {
    	EditTest_tblQuestions.getItems().remove(EditTest_tblQuestions.getSelectionModel().getSelectedItem());
    }

    @FXML
    void submit(ActionEvent event) {
		boolean notFilledFlag = false;
		String notFilled = "The following fields were not filled:\n ";
		if (EditTest_tblQuestions.getItems().isEmpty()) {
			notFilled += "-Questions table\n";
			notFilledFlag = true;
		}

		if (EditTest_DurationField.getText().isEmpty()) {
			notFilled += "-Test Duration\n";
			notFilledFlag = true;
		}
		if (notFilledFlag) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(notFilled);
			alert.showAndWait();
		}
			
    	String QuestionID="";
    	String points="";
    	

		for (QuestionForCreateTest qfct : EditTest_tblQuestions.getItems()) {
			QuestionID+=(qfct.getQuestion().toString())+",";
			points+=(qfct.getPoints())+",";
		}
		points = points.substring(0, points.length() - 1);
		QuestionID = QuestionID.substring(0, QuestionID.length() - 1);

    	String testID= DataManager.getDataManager().getTestID();
    	String teacherComment = EditTest_teacherCommentsField.getText();
    	String studentComment = EditTest_studentComentsField.getText();
    	String currExecCode =  DataManager.getDataManager().getTest().getCurrExecutionCode();
    	int isActivated = DataManager.getDataManager().getTest().isActivated();
    	String comopser = DataManager.getDataManager().getCurrentUser().getPersonalSID();
    	int duration  = Integer.parseInt(EditTest_DurationField.getText());
    
    	Test test = new Test(testID,QuestionID,duration,studentComment, teacherComment, currExecCode, points,isActivated,comopser);
    	ClientUI.chat.accept(new Message(Operation.UpdateTest,test));
    	confirmPopUp(DataManager.getDataManager().getActivateMsg());
    	
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
			
			questionForCreateTest.add(new QuestionForCreateTest(new Question(questions[i]),points[i]));
		}
		ObservableList<QuestionForCreateTest> questionsTbl = FXCollections.observableArrayList(questionForCreateTest);
		EditTest_QuestionIDCol.setCellValueFactory(new PropertyValueFactory<>("question"));
		EditTest_pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
		EditTest_tblQuestions.setItems(questionsTbl);
		EditTest_DurationField.setText(Integer.toString(test.getAllocatedDuration()));
		EditTest_teacherCommentsField.setText(test.getCommentsForTeachers());
		EditTest_studentComentsField.setText(test.getCommentsForStudents());
		
	}
    public void confirmPopUp(String confirm) {   //warnings func
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(confirm);

		alert.showAndWait();
    }

}




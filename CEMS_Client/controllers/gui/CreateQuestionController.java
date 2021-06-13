package gui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Course;
import entities.Field;
import entities.Message;
import entities.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import request.GenerateQuestionID;

public class CreateQuestionController {

    @FXML
    private JFXButton CreateQuestion_btnClose;

    @FXML
    private JFXButton CreateQuestion_btnSubmit;

    @FXML
    private JFXTextArea CreateQuestion_questionField;

    @FXML
    private JFXTextField CreateQuestion_answer1Field;

    @FXML
    private JFXTextField CreateQuestion_answer2Field;

    @FXML
    private JFXTextField CreateQuestion_answer3Field;

    @FXML
    private JFXTextField CreateQuestion_answer4Field;

    @FXML
    private JFXRadioButton CreateQuestion_checkAnswer1;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private JFXRadioButton CreateQuestion_checkAnswer2;

    @FXML
    private JFXRadioButton CreateQuestion_checkAnswer3;

    @FXML
    private JFXRadioButton CreateQuestion_checkAnswer4;

    @FXML
    private JFXButton CreateQuestion_btnClear;

    @FXML
    private JFXComboBox<Field> CreateQuestion_chooseSubjectBox;

    @FXML
    private JFXComboBox<Course> CreateQuestion_chooseCourseBox;
    
	public void start(Stage primaryStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/CreateQuestion.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Create Question");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetSubjectsAndCourses));
		for (Field f : DataManager.getDataManager().getFields()) {
			CreateQuestion_chooseSubjectBox.getItems().add(f);
		}
		CreateQuestion_chooseCourseBox.setDisable(true);
		CreateQuestion_chooseSubjectBox.setOnAction(e -> {
			CreateQuestion_chooseCourseBox.getItems().clear();
			CreateQuestion_chooseCourseBox.setDisable(false);
			for(Course c :CreateQuestion_chooseSubjectBox.getSelectionModel().getSelectedItem().getCourseList()){
				CreateQuestion_chooseCourseBox.getItems().add(c);
			}
		});
		
		
	}

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void submitQuestion(ActionEvent event) {
    	//Check if empty fields
    	if(CreateQuestion_questionField.getText().isEmpty())
    		warningPopUp("Question text filed is empty");
    	else if(CreateQuestion_answer1Field.getText().isEmpty()||CreateQuestion_answer2Field.getText().isEmpty()||
    			CreateQuestion_answer3Field.getText().isEmpty()||CreateQuestion_answer4Field.getText().isEmpty()) {
    		warningPopUp("All 4 answer are needed");
    	}
    	else if(CreateQuestion_chooseSubjectBox.getSelectionModel().getSelectedItem() == null)
    		warningPopUp("You need to choose a subject");
    	else if(CreateQuestion_chooseCourseBox.getSelectionModel().getSelectedItem() == null)
    		warningPopUp("You need to choose a course");
    	int correctAnswer=0;
    	
    	//Map the selected correct answer
    	
    	if(CreateQuestion_checkAnswer1.isSelected())
    		correctAnswer=1;
    	if(CreateQuestion_checkAnswer2.isSelected())
    		correctAnswer=2;
    	if(CreateQuestion_checkAnswer3.isSelected())
    		correctAnswer=3;
    	if(CreateQuestion_checkAnswer4.isSelected())
    		correctAnswer=4;  	
    	String[] answers=new String[4];
    	answers[0]=CreateQuestion_answer1Field.getText();
    	answers[1]=CreateQuestion_answer2Field.getText();
    	answers[2]=CreateQuestion_answer3Field.getText();
    	answers[3]=CreateQuestion_answer4Field.getText();
    	ClientUI.chat.accept(new Message(Operation.GetCourseAmountOfQuestions,CreateQuestion_chooseCourseBox.getSelectionModel().getSelectedItem().getID()));
    	String generatedID=GenerateQuestionID.Generate(CreateQuestion_chooseCourseBox.getSelectionModel().getSelectedItem().getID(), DataManager.getDataManager().getTempAmountOfQuestionsForCourse());
    	Question qst=new Question(generatedID,CreateQuestion_questionField.getText(),answers,correctAnswer,DataManager.getDataManager().getCurrentUser().getPersonalSID());
    	//ClientUI.chat.accept(new Message(Operation.AddQuestionToDatabase,qst));
    	ClientUI.chat.accept(new Message(Operation.IncrementNumOfQuestionsInCourse,CreateQuestion_chooseCourseBox.getSelectionModel().getSelectedItem().getID()));
    	
    	confirmPopUp(DataManager.getDataManager().getAddTestMsg());

    }
    public void warningPopUp(String warning) {   //warnings func
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(warning);

		alert.showAndWait();
    }
    public void confirmPopUp(String confirm) {   //warnings func
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(confirm);

		alert.showAndWait();
    }

}

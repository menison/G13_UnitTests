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
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private JFXComboBox<String> CreateQuestion_chooseSubjectBox;

    @FXML
    private JFXComboBox<String> CreateQuestion_chooseCourseBox;
    
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
		ArrayList<Course> ar;
		ClientUI.chat.accept(new Message(Operation.GetSubjectsAndCourses));
		ar=DataManager.getDataManager().getCourses();
		for(int i=0;i<ar.size();i++) {
			CreateQuestion_chooseCourseBox.getItems().add()
		}
		
		
	}

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void submitQuestion(ActionEvent event) {

    }

}

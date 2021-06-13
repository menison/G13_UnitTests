package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditQuestionController {

    @FXML
    private JFXButton EditQuestion_btnClose;

    @FXML
    private JFXButton EditQuestion_btnSubmit;

    @FXML
    private JFXTextArea EditQuestion_questionField;

    @FXML
    private JFXTextField EditQuestion_asnwer1Field;

    @FXML
    private JFXTextField EditQuestion_answer2Field;

    @FXML
    private JFXTextField EditQuestion_answer3Field;

    @FXML
    private JFXTextField EditQuestion_answer4Field;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer1;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer2;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer3;

    @FXML
    private JFXRadioButton EditQuestion_checkAnswer4;

    @FXML
    private JFXButton EditQuestion_btnClear;

    @FXML
    private JFXComboBox<?> EditQuestion_chooseSubjectBox;

    @FXML
    private JFXComboBox<?> EditQuestion_chooseCourseBox;

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
		Stage stage = (Stage) EditQuestion_btnClose.getScene().getWindow();
		stage.close();
    }

    @FXML
    void submitQuestion(ActionEvent event) {

    }
	public void start(Stage newStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/EditQuestionForTest.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Edit Question For Test");
		newStage.setScene(scene);
		newStage.show();
	}
	@FXML
	public void initialize() {
		ClientUI.chat.accept(new Message(Operation.GetQuestionInfo));
		
	}
}

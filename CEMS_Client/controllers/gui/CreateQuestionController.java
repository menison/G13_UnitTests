package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

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
    private JFXComboBox<?> CreateQuestion_chooseSubjectBox;

    @FXML
    private JFXComboBox<?> CreateQuestion_chooseCourseBox;

    @FXML
    void CreateQuestion_btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void CreateQuestion_btnSubmitClicked(ActionEvent event) {

    }

    @FXML
    void btnClearclicked(ActionEvent event) {

    }

}

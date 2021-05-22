package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

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

    }

    @FXML
    void submitQuestion(ActionEvent event) {

    }

}

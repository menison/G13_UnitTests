package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class EditQuestionController {

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXTextArea questionField;

    @FXML
    private JFXTextField asnwer1Field;

    @FXML
    private JFXTextField answer2Field;

    @FXML
    private JFXTextField answer3Field;

    @FXML
    private JFXTextField answer4Field;

    @FXML
    private JFXRadioButton checkAnswer1;

    @FXML
    private ToggleGroup ToggleGroup1;

    @FXML
    private JFXRadioButton checkAnswer2;

    @FXML
    private JFXRadioButton checkAnswer3;

    @FXML
    private JFXRadioButton checkAnswer4;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXComboBox<?> chooseSubjectBox;

    @FXML
    private JFXComboBox<?> chooseCourseBox;

    @FXML
    void btnClearClicked(ActionEvent event) {

    }

    @FXML
    void btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void btnSubmitClicked(ActionEvent event) {

    }

}

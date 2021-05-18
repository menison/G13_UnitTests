package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

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
    private TableView<?> EditTest_tblQuestions;

    @FXML
    private TableColumn<?, ?> EditTest_QuestionIDCol;

    @FXML
    private TableColumn<?, ?> EditTest_pointsCol;

    @FXML
    private JFXTextField EditTest_DurationField;

    @FXML
    private JFXComboBox<?> EditTest_chooseSubjectBox;

    @FXML
    private JFXComboBox<?> EditTest_chooseCourseBox;

    @FXML
    private JFXTextArea EditTest_teacherCommentsField;

    @FXML
    private JFXTextArea EditTest_studentCommentsField;

    @FXML
    void EditTest_btnAddQuestionclicked(ActionEvent event) {

    }

    @FXML
    void EditTest_btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void EditTest_btnDeleteQuestionClicked(ActionEvent event) {

    }

    @FXML
    void EditTest_btnSubmitClicked(ActionEvent event) {

    }

}

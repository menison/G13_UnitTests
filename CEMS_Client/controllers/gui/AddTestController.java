package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableView<?> CreateTest_tblQuestions;

    @FXML
    private TableColumn<?, ?> CreateTest_QuestionIDCol;

    @FXML
    private TableColumn<?, ?> CreateTest_PointsCol;

    @FXML
    private JFXTextField CreateTest_DurationField;

    @FXML
    private JFXComboBox<?> CreateTest_chooseSubjectBox;

    @FXML
    private JFXComboBox<?> CreateTest_chooseCourseBox;

    @FXML
    private JFXTextArea CreateTest_TeacherCommentsField;

    @FXML
    private JFXTextArea CreateTest_StudentCommentsField;

    @FXML
    void CreateTest_btnAddQuestionClicked(ActionEvent event) {

    }

    @FXML
    void CreateTest_btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void CreateTest_btnDeleteQuestionClicked(ActionEvent event) {

    }

    @FXML
    void CreateTest_btnSubmitClicked(ActionEvent event) {

    }

}

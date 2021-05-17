import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddTestController {

    @FXML
    private JFXButton btnAddQuestion;

    @FXML
    private JFXButton btnDeleteQuestion;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private TableView<?> QuestionsTable;

    @FXML
    private TableColumn<?, ?> QuestionIDCol;

    @FXML
    private TableColumn<?, ?> PointsCol;

    @FXML
    private JFXTextField DurationField;

    @FXML
    private JFXComboBox<?> chooseSubjectBox;

    @FXML
    private JFXComboBox<?> chooseCourseBox;

    @FXML
    private JFXTextArea TeacherCommentsField;

    @FXML
    private JFXTextArea StudentCommentsField;

    @FXML
    void btnAddQuestionClicked(ActionEvent event) {

    }

    @FXML
    void btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void btnDeleteQuestionClicked(ActionEvent event) {

    }

    @FXML
    void btnSubmitClicked(ActionEvent event) {

    }

}

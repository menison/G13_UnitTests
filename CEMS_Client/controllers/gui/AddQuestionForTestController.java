package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddQuestionForTestController {

    @FXML
    private JFXButton ChooseQuestion_btnSearch;

    @FXML
    private JFXButton ChooseQuestion_btnClose;

    @FXML
    private JFXButton ChooseQuestion_btnAdd;

    @FXML
    private TableView<?> ChooseQuestion_tblQuestion;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_qustionIDcol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_subjectCol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_CourseCol;

    @FXML
    private TableColumn<?, ?> ChooseQuestion_composerCol;

    @FXML
    private JFXTextField ChooseQuestion_courseNameField;

    @FXML
    private JFXTextField ChooseQuestion_pointsField;

    @FXML
    void ChooseQuestion_btnAddClicked(ActionEvent event) {

    }

    @FXML
    void ChooseQuestion_btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void ChooseQuestion_btnSearchClicked(ActionEvent event) {

    }

}

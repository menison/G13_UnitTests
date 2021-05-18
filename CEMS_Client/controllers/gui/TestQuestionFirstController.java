package gui;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class TestQuestionFirstController {

    @FXML
    private Button firstQuestion_btnNext;

    @FXML
    private RadioButton firstQuestion_radioAns1;

    @FXML
    private ToggleGroup toggleGroup1;

    @FXML
    private RadioButton firstQuestion_radioAns2;

    @FXML
    private RadioButton firstQuestion_radioAns4;

    @FXML
    private RadioButton firstQuestion_radioAns3;

    @FXML
    private ProgressBar firstQuestion_progressBar;

    @FXML
    private ProgressIndicator firstQuestion_pieProgressIndicator;

    @FXML
    private JFXTextField firstQuestion_txtElapsedTime;

}

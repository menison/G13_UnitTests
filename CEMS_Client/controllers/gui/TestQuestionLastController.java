package gui;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;

public class TestQuestionLastController {

    @FXML
    private Button lastQuestion_finishTest;

    @FXML
    private RadioButton lastQuestion_radioAns1;

    @FXML
    private RadioButton lastQuestion_radioAns2;

    @FXML
    private RadioButton lastQuestion_radioAns4;

    @FXML
    private RadioButton lastQuestion_radioAns3;

    @FXML
    private ProgressBar lastQuestion_progressBar;

    @FXML
    private ProgressIndicator lastQuestion_pieProgressIndic;

    @FXML
    private JFXTextField lastQuestion_timeElapsed;

    @FXML
    private Button lastQuestion_back;

}

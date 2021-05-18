package gui;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;

public class ManualTestController {

    @FXML
    private Button manualTest_btnDownload;

    @FXML
    private Button manualTest_btnUpload;

    @FXML
    private ProgressIndicator manualTest_pieProgressIndicator;

    @FXML
    private JFXTextField manualTest_txtElapsedTime;

    @FXML
    private Button manualTest_btnSend;

}

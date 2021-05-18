package gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FullTestTableController {

    @FXML
    private JFXButton fullTestTable_btnAddTest;

    @FXML
    private JFXButton fullTestTable_btnActivateTest;

    @FXML
    private JFXButton fullTestTable_btnEditTest;

    @FXML
    private JFXButton fullTestTable_btnClose;

    @FXML
    private TableView<?> fullTestTbl;

    @FXML
    private TableColumn<?, ?> fullTestTable_IdColumn;

    @FXML
    private TableColumn<?, ?> fullTestTable_subjectColumn;

    @FXML
    private TableColumn<?, ?> fullTestTable_courseColumn;

    @FXML
    private TableColumn<?, ?> fullTestTable_durationColumn;

    @FXML
    private TableColumn<?, ?> fullTestTable_composerColumn;

}

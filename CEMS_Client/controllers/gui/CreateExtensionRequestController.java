package gui;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CreateExtensionRequestController {

    @FXML
    private JFXButton RequestExtension_btnExtend;

    @FXML
    private JFXButton RequestExtension_btnClose;

    @FXML
    private TableView<?> RequestExtension_tblTest;

    @FXML
    private TableColumn<?, ?> RequestExtension_TestIDCol;

    @FXML
    private TableColumn<?, ?> RequestExtension_subjectCol;

    @FXML
    private TableColumn<?, ?> RequestExtension_courseCol;

    @FXML
    private TableColumn<?, ?> RequestExtension_durationCol;

    @FXML
    private TableColumn<?, ?> RequestExtension_composerCol;

    @FXML
    void Extend(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

}

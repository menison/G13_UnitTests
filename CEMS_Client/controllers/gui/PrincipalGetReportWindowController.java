package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalGetReportWindowController {

    @FXML
    private JFXComboBox<?> PrincipalGetReportWindow_generateByCombo;

    @FXML
    private JFXTextField PrincipalGetReportWindow_valueTxt;

    @FXML
    private JFXButton PrincipalGetReportWindow_btnSubmit;

    @FXML
    private Button PrincipalGetReportWindow_btnBack;

    public void start(Stage newStage) throws IOException {
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalGetReportWindow.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Report Requests");
		newStage.setScene(scene);
		newStage.show();	
	}
    @FXML
    void PrincipalGetReportWindow_btnBackClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalMenuController pmc = new PrincipalMenuController();
    	pmc.start(newStage);
    	currentStage.close();
    }
}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.TestToConfirm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConfirmGradesController implements Initializable{

    @FXML
    private TableView<TestToConfirm> confirmGrades_tblViewConfirm;

    @FXML
    private TableColumn<TestToConfirm, String> tblViewCol_testID;

    @FXML
    private TableColumn<TestToConfirm, String> tblViewCol_testCode;

    @FXML
    private TableColumn<TestToConfirm, String> tblViewCol_Date;

    @FXML
    private TableColumn<TestToConfirm, String> tblViewCol_executedBy;

    @FXML
    private TableColumn<TestToConfirm, Integer> tblViewCol_Grade;

    @FXML
    private JFXButton confirmGrades_btnConfirm;

    @FXML
    private JFXButton confirmGrades_btnBack;
    
    public static boolean isNull;

    @FXML
    void back(ActionEvent event) {
    	Stage newStage = new Stage();
    	Stage stage = (Stage) confirmGrades_btnBack.getScene().getWindow();
    	TeacherMenuController tmc = new TeacherMenuController();
    	tmc.start(newStage);
    	stage.close();
    }

    @FXML
    void confirmGrade(ActionEvent event) {
    	Stage newStage = new Stage();
    	TestToConfirm t = confirmGrades_tblViewConfirm.getSelectionModel().getSelectedItem();
    	ClientUI.chat.accept(new Message(Operation.CheckFraud, t));
    	DataManager dm = DataManager.getDataManager();
    	dm.setT(t);
    	GradesConfirmationController gcc = new GradesConfirmationController();
		gcc.start(newStage);
    }
    
    public void start(Stage primaryStage) {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/ConfirmGrades.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Confirm Grades");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DataManager dm = DataManager.getDataManager();
		String teacherID = dm.getCurrentUser().getPersonalSID();
		ClientUI.chat.accept(new Message(Operation.GetTestConfirmationTable, teacherID));
		if (dm.getTestsToConfirm() == null) {
			System.out.println("Failed to set table - no available tests to confirm!");
		}
		else {
		  	ObservableList<TestToConfirm> tests = FXCollections.observableArrayList(dm.getTestsToConfirm());
	    	tblViewCol_testID.setCellValueFactory(new PropertyValueFactory<>("testID"));
	    	tblViewCol_testCode.setCellValueFactory(new PropertyValueFactory<>("testCode"));
	    	tblViewCol_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
	    	tblViewCol_executedBy.setCellValueFactory(new PropertyValueFactory<>("executedBy"));
	    	tblViewCol_Grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
	    	confirmGrades_tblViewConfirm.setItems(tests);
		}
 
	}

}

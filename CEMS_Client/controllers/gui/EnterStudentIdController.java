package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.ExecutedTest;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A controller class handling the interaction with teacher in lock test window.
 */
public class EnterStudentIdController implements Initializable{

    @FXML
    private Button testInfo_btnStartTest;

    @FXML
    private JFXTextField testInfo_txtEnterUserID;

    @FXML
    private JFXTextField testInfo_txtContactMail;

    @FXML
    private JFXTextArea testInfo_txtArea_testInstruc;
    
	/**
	 * A standard controller starting mechanism.
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		Pane root;
    	FXMLLoader loader = new FXMLLoader();
		Scene scene = null;
		loader.setLocation(getClass().getResource("/fxml/EnterStudentId.fxml"));
		try {
			root = loader.load();
			scene = new Scene(root);
			primaryStage.setTitle("Computerized test - Enter ID");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

    /**
     * This method will demand the user to enter his ID, it will check if it fits the current 
     * user's ID and it will route the user to the questions window.
     * @param event
     */
    @FXML
    void StartTest(ActionEvent event) {
    	String studentId = testInfo_txtEnterUserID.getText();
    	DataManager dm = DataManager.getDataManager();
    	String currStudentId= dm.getCurrentUser().getPersonalSID();
    	if(!currStudentId.equals(studentId)) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Wrong ID, please re-enter");
			alert.showAndWait();
    	}
    	else {
    		TestQuestionMiddleController tqmc = new TestQuestionMiddleController();
    		Stage primaryStage = new Stage();
    		Stage stage = (Stage) testInfo_btnStartTest.getScene().getWindow();
    		stage.close();
    		tqmc.start(primaryStage);
    	}
    }

	public void setTestInfo_txtArea_testInstruc(String str) {
		this.testInfo_txtArea_testInstruc.setText(str);
	}

	public void setTestInfo_txtContactMail(String str) {
		this.testInfo_txtContactMail.setText(str);
	}
	/**
	 *This method initializes all of the text fields and areas that should be initialized
	 *with data from DataManager (which he got from server);
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DataManager dm = DataManager.getDataManager();
		ExecutedTest execTest = dm.getTestInExecution();
		ClientUI.chat.accept(new Message(Operation.getInstructionsAndMail, execTest.getComposedBy()));
		setTestInfo_txtArea_testInstruc(execTest.getTest().getCommentsForStudents());
		setTestInfo_txtContactMail(dm.getCurrentExecEmail());
		testInfo_txtArea_testInstruc.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
	}
	
}
